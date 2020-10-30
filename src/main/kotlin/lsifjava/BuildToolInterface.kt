package lsifjava

import org.gradle.tooling.GradleConnector
import org.gradle.tooling.model.eclipse.EclipseProject
import org.gradle.tooling.model.idea.IdeaProject
import org.gradle.tooling.model.idea.IdeaSingleEntryLibraryDependency
import java.nio.file.Path
import java.nio.file.Paths

interface BuildToolInterface {
    fun getClasspaths(): List<Classpath>
    fun getSourceDirectories(): List<List<Path>>
    fun javaSourceVersions(): List<String?>
}

// TODO(nsc) exclusions? lazy eval?
class GradleInterface(private val projectDir: CanonicalPath): AutoCloseable, BuildToolInterface {
    private val projectConnection by lazy {
        GradleConnector.newConnector()
            .forProjectDirectory(projectDir.path.toFile())
            .connect()
    }

    private val eclipseModel by lazy {
        projectConnection.getModel(EclipseProject::class.java)
    }
    
    private val ideaModel by lazy {
        projectConnection.getModel(IdeaProject::class.java)
    }

    // is this even *correct*? Is the order the same?
    override fun getClasspaths(): List<Classpath> {
        val eclipseClasspaths = getClasspathsFromEclipse()
        return ideaModel.children.mapIndexed { i, it ->
            Classpath(it.dependencies
                .filterIsInstance<IdeaSingleEntryLibraryDependency>()
                .map { it.file.canonicalPath }
                .toSet()
            ) + eclipseClasspaths[i]
        }
    }


    private fun getClasspathsFromEclipse() = eclipseClasspath(eclipseModel)

    private fun eclipseClasspath(project: EclipseProject): List<Classpath> {
        val classPaths = arrayListOf<Classpath>()
        classPaths += Classpath(project.classpath.map { it.file.canonicalPath }.toSet())
        project.children.forEach { eclipseClasspath(it).toCollection(classPaths) }
        return classPaths
    }

    override fun getSourceDirectories(): List<List<Path>> {
        return ideaModel.children.flatMap { module ->
            module.contentRoots.map { root ->
                root.sourceDirectories.map { Paths.get(it.directory.canonicalPath) } +
                root.testDirectories.map { Paths.get(it.directory.canonicalPath) } +
                arrayListOf<Path>(
                    Paths.get(module.gradleProject.projectDirectory.path, "src/main"),
                    Paths.get(module.gradleProject.projectDirectory.path, "src/test")
                )
            }
        }
    }

    //override fun getSourceDirectories() = sourceDirectories(eclipseModel)

    private fun sourceDirectories(project: EclipseProject): List<List<Path>> {
        val sourceDirs = arrayListOf<List<Path>>()
        sourceDirs +=
            arrayListOf<Path>(
                Paths.get(project.projectDirectory.path, "src/main"),
                Paths.get(project.projectDirectory.path, "src/test")
            ) +
            project.sourceDirectories.map { Paths.get(project.projectDirectory.path, it.path) }
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

inline class Classpath(private val classpaths: Set<String>) {
    operator fun plus(other: Set<String>) = Classpath(classpaths.union(other))
    
    operator fun plus(other: Classpath) = Classpath(classpaths.union(other.classpaths))

    override fun toString() = classpaths.joinToString(":")
}