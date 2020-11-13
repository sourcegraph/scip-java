@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import javax.tools.ForwardingJavaFileManager
import javax.tools.StandardJavaFileManager
import com.sun.tools.javac.util.Context
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.*
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import javax.tools.JavaFileManager
import javax.tools.StandardLocation

/**
 * FileManager that falls back to JavacPathFileManager for Java 8.
 * Java 8 StandardJavaFileManager doesn't have the <code>setLocationFromPaths</code>
 * method, instead it only has <code>setLocation</code> which requires an 
 * <code>Iterable<? extends File></code>, which would cause an UnsupportedException
 * when trying to turn the ZipFile from the in-memory FileSystem into a File.
 * Because JavacPathFileManager doesnt exist beyond Java 8 (9?) and we build with 14+,
 * the symbol resolver would fail for that symbol, hence we create an instance via
 * reflection if the Java version is 8. God I hate this.
 */
class JDK8CompatFileManager(manager: StandardJavaFileManager): ForwardingJavaFileManager<JavaFileManager>(getFileManager(manager)) {
    companion object {
        private fun getFileManager(fileManager: StandardJavaFileManager): JavaFileManager {
            var java8Manager: JavaFileManager? = null

            if(javaVersion == 8) {
                java8Manager = Class.forName("com.sun.tools.javac.nio.JavacPathFileManager")
                    .constructors[0]
                    .newInstance(Context(), false, Charset.defaultCharset())
                    as JavaFileManager?
            }

            val srcZip = srcZip()
            if(srcZip != null) {
                if(javaVersion > 8) {
                    fileManager.setLocationFromPaths(StandardLocation.MODULE_SOURCE_PATH, setOf(srcZip.getPath("/")))
                } else {
                    java8Manager!!::class.java
                        .getMethod("setDefaultFileSystem", FileSystem::class.java)
                        .invoke(java8Manager, srcZip)
                    java8Manager::class.java
                        .getMethod("setLocation", JavaFileManager.Location::class.java, Iterable::class.java)
                        .invoke(java8Manager, StandardLocation.SOURCE_PATH, setOf(srcZip.getPath("/")))
                }
            }

            return java8Manager ?: fileManager
        }

        private fun srcZip(): FileSystem? {
            val srcZip = findSrcZip() ?: return null
            return try {
                FileSystems.newFileSystem(srcZip, ExternalDocs::class.java.classLoader)
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }

        private fun findSrcZip(): Path? {
            val javaHome = JavaHomeHelper.javaHome() ?: return null
            val locations = arrayOf("lib/src.zip", "src.zip")
            for (rel in locations) {
                val abs = javaHome.resolve(rel)
                if (Files.exists(abs)) {
                    return abs
                }
            }
            return null
        }
    }

    // from https://github.com/georgewfraser/java-language-server
    // bless you george for all the references. Maybe Ill cut this down/refactor
    private object JavaHomeHelper {
        fun javaHome(): Path? {
            val fromEnv = System.getenv("JAVA_HOME")
            if (fromEnv != null)
                return Paths.get(fromEnv)
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
                return execJavaHome()
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

        private fun execJavaHome(): Path {
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

        private fun check(vararg roots: String): Path? {
            for (root in roots) {
                var list: List<Path> = try {
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
}
