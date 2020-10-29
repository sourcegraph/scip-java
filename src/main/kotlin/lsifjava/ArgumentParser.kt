package lsifjava

import org.apache.commons.cli.*
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.system.exitProcess

const val VERSION = "0.1.0"
const val PROTOCOL_VERSION = "0.4.0"

data class Arguments(
    val projectRoot: CanonicalPath,
    val outFile: String,
    val verbose: Boolean,
    val javacOutWriter: String
)

fun parse(args: Array<String>): Arguments {
    val options = createOptions()
    val formatter = HelpFormatter()

    val cmd = try {
        DefaultParser().parse(options, args)
    } catch (e: ParseException) {
        println(e.message)
        formatter.printHelp("lsif-java", "lsif-java is an LSIF indexer for Java.\n\n", options, "")
        exitProcess(1)
    }

    if (cmd.hasOption("help")) {
        formatter.printHelp("lsif-java", "lsif-java is an LSIF indexer for Java.\n\n", options, "")
        exitProcess(0)
    }
    if (cmd.hasOption("version")) {
        println("$VERSION, protocol version $PROTOCOL_VERSION")
        exitProcess(0)
    }
    
    val projectRoot = CanonicalPath(Paths.get(cmd.getOptionValue("projectRoot", ".")))
    val outFile = cmd.getOptionValue("out", "$projectRoot/dump.lsif")
    val verbosity = cmd.hasOption("verbose")
    val javacOutWriter = cmd.getOptionValue("javacOut", "none")

    return Arguments(projectRoot, outFile, verbosity, javacOutWriter)
}

private fun createOptions() = Options().apply {
    addOption(Option(
        "help", false,
        "Show help."
    ))
    addOption(Option(
        "version", false,
        "Show version."
    ))
    addOption(Option(
        "verbose", false,
        "Display verbose information."
    ))
    addOption(Option(
        "projectRoot", true,
        "Specifies the project root. Defaults to the current working directory."
    ))
    addOption(Option(
        "out", true,
        "The output file the dump is save to."
    ))
    addOption(Option(
        "javacOut", true,
        "The output location for output from javac. Options include stdout, stderr, none or filepath."
    ))
}
