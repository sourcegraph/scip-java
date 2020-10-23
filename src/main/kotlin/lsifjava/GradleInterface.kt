package lsifjava

import org.gradle.tooling.GradleConnector
import org.gradle.tooling.model.eclipse.EclipseProject
import java.nio.file.Path
import java.nio.file.Paths

// TODO(nsc) exclusions? subprojects? inter-project dependencies? fml
class GradleInterface(private val projectDir: String): AutoCloseable {
    private val projectConnection by lazy {
        // TODO(nsc) version override, 6.0 < x < 6.3 seems to be an issue
        GradleConnector.newConnector()
            .forProjectDirectory(Paths.get(projectDir).toFile())
            //.useGradleVersion("6.3")
            .connect()
    }

    private val eclipseModel by lazy {
        projectConnection.getModel(EclipseProject::class.java)
    }

    fun getClasspaths() = classpath(eclipseModel)
    
    private fun classpath(project: EclipseProject): List<Classpath> {
        val classPaths = arrayListOf<Classpath>()
        classPaths += Classpath(project.classpath.map { it.file.canonicalPath })
        project.children.forEach { classpath(it).toCollection(classPaths) }
        return classPaths
    }

    fun getSourceDirectories() = sourceDirectories(eclipseModel)

    private fun sourceDirectories(project: EclipseProject): List<List<Path>> {
        val sourceDirs = arrayListOf<List<Path>>()
        sourceDirs += project.sourceDirectories.map { Paths.get(project.projectDirectory.path, it.path) }
        project.children.forEach { sourceDirectories(it).toCollection(sourceDirs) }
        return sourceDirs
    }

    override fun close() = projectConnection.close()
}

class Classpath(private val classpaths: Iterable<String>): Iterable<String> by classpaths {
    override fun toString() = classpaths.joinToString(":")
}