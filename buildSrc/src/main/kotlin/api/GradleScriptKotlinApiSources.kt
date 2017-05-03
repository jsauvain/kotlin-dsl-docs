package api

import java.io.File

import org.gradle.api.*
import org.gradle.api.tasks.*
import org.gradle.script.lang.kotlin.*

open class GradleScriptKotlinApiSources : DefaultTask() {

    @get:InputDirectory
    var gskClone: File? = null

    @get:OutputDirectory
    var sourceDir: File? = null

    @TaskAction
    fun copyGradleScriptKotlinApiSources(): Unit {
        project.copy { spec ->
            spec.from(File(gskClone!!, "src/main/kotlin"))
            spec.from(File(gskClone!!, "src/generated/kotlin"))
            spec.into(sourceDir!!)
            spec.exclude("org/gradle/script/lang/kotlin/provider")
        }
    }
}