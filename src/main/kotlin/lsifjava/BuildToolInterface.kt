package lsifjava

import org.gradle.tooling.GradleConnector
import org.gradle.tooling.model.eclipse.EclipseProject
import java.nio.file.Path
import java.nio.file.Paths

interface BuildToolInterface {
    fun getClasspaths(): List<Classpath>
    fun getSourceDirectories(): List<List<Path>>
    fun javaSourceVersions(): List<String?>
}

// TODO(nsc) exclusions? subprojects? lazy eval with tail rec?
class GradleInterface(private val projectDir: CanonicalPath): AutoCloseable, BuildToolInterface {
    private val projectConnection by lazy {
        GradleConnector.newConnector()
            .forProjectDirectory(projectDir.path.toFile())
            .connect()
    }

    private val eclipseModel by lazy {
        projectConnection.getModel(EclipseProject::class.java)
    }

    override fun getClasspaths() = classpath(eclipseModel)
    
    private fun classpath(project: EclipseProject): List<Classpath> {
        val classPaths = arrayListOf<Classpath>()
        classPaths += Classpath(project.classpath.map { it.file.canonicalPath })
        project.children.forEach { classpath(it).toCollection(classPaths) }
        return classPaths
    }

    override fun getSourceDirectories() = sourceDirectories(eclipseModel)

    private fun sourceDirectories(project: EclipseProject): List<List<Path>> {
        val sourceDirs = arrayListOf<List<Path>>()
        sourceDirs += project.sourceDirectories.map { Paths.get(project.projectDirectory.path, it.path) }
        project.children.forEach { sourceDirectories(it).toCollection(sourceDirs) }
        return sourceDirs
    }
    
    override fun javaSourceVersions() = javaSourceVersion(eclipseModel)

    // get rid of String?, use parent version or else fallback
    private fun javaSourceVersion(project: EclipseProject): List<String?> {
        val javaVersions = arrayListOf<String?>()
        javaVersions.add(project.javaSourceSettings?.sourceLanguageLevel?.toString())
        project.children.forEach { javaSourceVersion(it).toCollection(javaVersions) }
        return javaVersions
    }

    override fun close() = projectConnection.close()
}

class Classpath(private val classpaths: Iterable<String>): Iterable<String> by classpaths {
    override fun toString() = classpaths.joinToString(":")
}