package lsifjava;

import java.io.IOException;

import org.apache.commons.cli.*;

public class ArgumentParser {
    public static final String VERSION = "0.1.0";
    public static final String PROTOCOL_VERSION = "0.4.0";

    public static Arguments parse(String[] args) throws IOException{
        Options options = createOptions();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("lsif-java", "lsif-java is an LSIF indexer for Java.\n\n", options, "");
            System.exit(1);
            return null;
        }

        if (cmd.hasOption("help")) {
            formatter.printHelp("lsif-java", "lsif-java is an LSIF indexer for Java.\n\n", options, "");
            System.exit(0);
        }

        if (cmd.hasOption("version")) {
            System.out.printf("%s, protocol version %s\n", VERSION, PROTOCOL_VERSION);
            System.exit(0);
        }

        String projectRoot = cmd.getOptionValue("projectRoot", ".");
        boolean contents = cmd.hasOption("contents");
        String outFile = cmd.getOptionValue("out");
        boolean verbosity = cmd.hasOption("verbose");


        return new Arguments(projectRoot, contents, outFile, verbosity);
    }

    private static Options createOptions() {
        Options options = new Options();

        options.addOption(new Option(
                "help", false,
                "Show help."
        ));

        options.addOption(new Option(
                "version", false,
                "Show version."
        ));

        options.addOption(new Option(
                "verbose", false,
                "Display verbose information."
        ));

        options.addOption(new Option(
                "projectRoot", true,
                "Specifies the project root. Defaults to the current working directory."
        ));

        options.addOption(new Option(
                "contents", false,
                "File contents will be embedded into the dump."
        ));

        options.addOption(new Option(
                "out", true,
                "The output file the dump is save to."
        ));

        return options;
    }
}
