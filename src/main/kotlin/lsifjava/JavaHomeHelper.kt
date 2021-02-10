package lsifjava

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

// from https://github.com/georgewfraser/java-language-server
// bless you george for all the references. Maybe Ill cut this down/refactor
/**
 * Attempts to derive the possible JAVA_HOME, either from the set env var or
 * through searching various platform dependent directories. If the wrong JAVA_HOME
 * is found via search in the case where multiple versions are installed, the env
 * var should be used.
 */
object JavaHomeHelper {
    fun javaHome(): Path? {
        System.getenv("JAVA_HOME")?.let {
            return Paths.get(it)
        }
        val osName = System.getProperty("os.name")
        if (isWindows(osName)) return windowsJavaHome()
        if (isMac(osName)) return macJavaHome()
        if (isLinux(osName)) return linuxJavaHome()
        throw RuntimeException("Unrecognized os.name $osName")
    }

    private fun windowsJavaHome(): Path? {
        for (root in File.listRoots()) {
            val x64 = root.toPath().resolve("Program Files/Java").toString()
            val x86 = root.toPath().resolve("Program Files (x86)/Java").toString()
            val found = check(x64, x86)
            if (found !== null) return found
        }
        return null
    }

    private fun macJavaHome(): Path? {
        if (Files.isExecutable(Paths.get("/usr/libexec/java_home"))) {
            return try {
                val process = ProcessBuilder().command("/usr/libexec/java_home").start()
                val out = BufferedReader(InputStreamReader(process.inputStream))
                val line = out.readLine()
                process.waitFor(5, TimeUnit.SECONDS)
                Paths.get(line)
            } catch (e: IOException) {
                throw RuntimeException(e)
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }
        val homes = arrayOf(
            "/Library/Java/JavaVirtualMachines/Home",
            "/System/Library/Java/JavaVirtualMachines/Home",
            "/Library/Java/JavaVirtualMachines/Contents/Home",
            "/System/Library/Java/JavaVirtualMachines/Contents/Home")
        return check(*homes)
    }

    private fun linuxJavaHome(): Path? {
        val homes = arrayOf("/usr/java", "/opt/java", "/usr/lib/jvm")
        return check(*homes)
    }

    private fun check(vararg roots: String): Path? {
        for (root in roots) {
            val list: List<Path> = try {
                Files.list(Paths.get(root)).collect(Collectors.toList())
            } catch (e: NoSuchFileException) {
                continue
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
            for (jdk in list) {
                if (Files.exists(jdk.resolve("bin/javac")) || Files.exists(jdk.resolve("bin/javac.exe"))) {
                    return jdk
                }
            }
        }
        return null
    }

    private fun isWindows(osName: String): Boolean {
        return osName.toLowerCase().startsWith("windows")
    }

    private fun isMac(osName: String): Boolean {
        return osName.toLowerCase().startsWith("mac")
    }

    private fun isLinux(osName: String): Boolean {
        return osName.toLowerCase().startsWith("linux")
    }
}