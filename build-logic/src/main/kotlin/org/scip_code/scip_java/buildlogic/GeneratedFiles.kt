package org.scip_code.scip_java.buildlogic

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

/**
 * Registers a task that writes [content] (plus a trailing newline) to
 * build/generated/[relativePath], tracking the content for up-to-date checks.
 */
fun Project.registerGeneratedFile(
    name: String,
    relativePath: String,
    content: String,
): TaskProvider<Task> {
    val output = layout.buildDirectory.file("generated/$relativePath")
    return tasks.register(name) {
        inputs.property("content", content)
        outputs.file(output)
        doLast {
            val file = output.get().asFile
            file.parentFile.mkdirs()
            file.writeText("$content\n")
        }
    }
}
