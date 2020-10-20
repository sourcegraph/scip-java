package lsifjava

import org.gradle.tooling.GradleConnector
import org.gradle.tooling.model.GradleProject
import org.gradle.tooling.model.eclipse.EclipseProject
import org.gradle.tooling.model.idea.IdeaProject
import java.nio.file.Path
import java.nio.file.Paths

// TODO(nsc) exclusions? subprojects? inter-project dependencies? fml
class GradleInterface(private val projectDir: String): AutoCloseable {
    private val projectConnection by lazy {
        GradleConnector.newConnector().forProjectDirectory(Paths.get(projectDir).toFile()).connect()
    }

    private val eclipseModel by lazy {
        projectConnection.getModel(EclipseProject::class.java)
    }

    fun classpath() = Classpath(eclipseModel.classpath.map { it.file.canonicalPath })

    fun sourceDirectories() = eclipseModel.sourceDirectories.map {
        Paths.get(eclipseModel.projectDirectory.path, it.path)
    }

    override fun close() = projectConnection.close()
}

class Classpath(private val classpaths: Iterable<String>): Iterable<String> by classpaths {
    override fun toString() = classpaths.joinToString(":")
}