package org.scip_code.scip_java.buildtools

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.xml.parsers.DocumentBuilderFactory
import org.scip_code.scip_java.aggregator.MavenPackage
import org.w3c.dom.Element
import org.w3c.dom.Node

/**
 * Represents a single classpath entry on the classpath of a project, used to emit SCIP
 * "packageInformation" nodes. A classpath entry can either be a jar file or a directory path.
 */
data class ClasspathEntry(
    val entry: Path,
    val groupId: String,
    val artifactId: String,
    val version: String,
) {
    fun mavenCoordinate(): String = "maven:$groupId:$artifactId:$version"

    fun toPackageInformation(): MavenPackage = MavenPackage(entry, groupId, artifactId, version)

    companion object {
        /**
         * Parses ClasspathEntry from the SCIP targetroot directory.
         *
         * Two separate formats are supported:
         * - javacopts.txt: line-separated list of Java compiler options.
         * - dependencies.txt: line-separated list of dependency information.
         *
         * Note that the targetroot can contain several files with names ending in
         * "dependencies.txt" - for example if they come from a multi-module build.
         */
        @JvmStatic
        fun fromTargetroot(targetroot: Path, sourceroot: Path): List<ClasspathEntry> {
            val javacopts = targetroot.resolve("javacopts.txt")
            return if (Files.isRegularFile(javacopts)) {
                fromJavacopts(javacopts, sourceroot)
            } else {
                discoverDependenciesFromFiles(targetroot)
            }
        }

        private fun discoverDependenciesFromFiles(targetroot: Path): List<ClasspathEntry> {
            if (!Files.isDirectory(targetroot)) return emptyList()
            return Files.list(targetroot).use { stream ->
                stream
                    .filter {
                        Files.isRegularFile(it) &&
                            it.fileName.toString().endsWith("dependencies.txt")
                    }
                    .toArray()
                    .map { it as Path }
                    .flatMap { fromDependencies(it) }
                    .distinct()
            }
        }

        private fun fromDependencies(dependencies: Path): List<ClasspathEntry> =
            Files.readAllLines(dependencies, StandardCharsets.UTF_8).mapNotNull { line ->
                val parts = line.split('\t')
                if (parts.size == 4) {
                    val (groupId, artifactId, version, entry) = parts
                    ClasspathEntry(
                        entry = Paths.get(entry),
                        groupId = groupId,
                        artifactId = artifactId,
                        version = version,
                    )
                } else null
            }

        private fun fromJavacopts(javacopts: Path, sourceroot: Path): List<ClasspathEntry> {
            val lines =
                Files.readAllLines(javacopts, StandardCharsets.UTF_8).map {
                    it.removePrefix("\"").removeSuffix("\"")
                }
            val result = mutableListOf<ClasspathEntry>()
            for (i in 0 until lines.size - 1) {
                val key = lines[i]
                val value = lines[i + 1]
                when (key) {
                    "-d" -> {
                        val entry = fromClassesDirectory(Paths.get(value), sourceroot)
                        if (entry != null) result += entry
                    }
                    "-cp",
                    "-classpath" -> {
                        value.split(File.pathSeparator).forEach { jarPath ->
                            val entry = fromClasspathJarFile(Paths.get(jarPath))
                            if (entry != null) result += entry
                        }
                    }
                }
            }
            return result
        }

        private tailrec fun fromClassesDirectory(
            classesDirectory: Path,
            sourceroot: Path,
            currentDir: Path? = classesDirectory.parent,
        ): ClasspathEntry? {
            if (currentDir == null || !currentDir.startsWith(sourceroot)) return null
            val pomEntry = fromPomXml(currentDir.resolve("pom.xml"), classesDirectory)
            if (pomEntry != null) return pomEntry
            return fromClassesDirectory(classesDirectory, sourceroot, currentDir.parent)
        }

        /**
         * Tries to parse a ClasspathEntry from the POM file that lies next to the given jar file.
         */
        private fun fromClasspathJarFile(jar: Path): ClasspathEntry? {
            val fileName = jar.fileName?.toString() ?: return null
            val base = fileName.removeSuffix(".jar")
            val pom = jar.resolveSibling("$base.pom")
            return fromPomXml(pom, jar)
        }

        private fun fromPomXml(pom: Path, classpathEntry: Path): ClasspathEntry? {
            if (!Files.isRegularFile(pom)) return null
            val factory =
                DocumentBuilderFactory.newInstance().apply {
                    isNamespaceAware = false
                    isValidating = false
                    // Defensive: disable external entity resolution to avoid
                    // accidental XXE against attacker-controlled pom.xml files.
                    setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
                    setFeature("http://xml.org/sax/features/external-general-entities", false)
                    setFeature("http://xml.org/sax/features/external-parameter-entities", false)
                    isXIncludeAware = false
                    isExpandEntityReferences = false
                }
            val document = factory.newDocumentBuilder().parse(Files.newInputStream(pom))
            val root = document.documentElement ?: return null

            fun textOf(parent: Element, key: String): String {
                val direct = childElementByName(parent, key)
                if (direct != null) return direct.textContent.orEmpty().trim()
                val parentTag = childElementByName(parent, "parent") ?: return ""
                return childElementByName(parentTag, key)?.textContent.orEmpty().trim()
            }

            return ClasspathEntry(
                entry = classpathEntry,
                groupId = textOf(root, "groupId"),
                artifactId = textOf(root, "artifactId"),
                version = textOf(root, "version"),
            )
        }

        private fun childElementByName(parent: Element, name: String): Element? {
            val nodes = parent.childNodes
            for (i in 0 until nodes.length) {
                val node = nodes.item(i)
                if (node.nodeType == Node.ELEMENT_NODE && (node as Element).tagName == name) {
                    return node
                }
            }
            return null
        }
    }
}
