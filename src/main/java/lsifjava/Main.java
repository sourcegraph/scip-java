package lsifjava;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Running JVM " + System.getProperty("java.version"));

        var arguments = ArgumentParser.parse(args);
        var writer = createWriter(arguments);
        var emitter = new Emitter(writer);
        var indexer = new ProjectIndexer(arguments, emitter);

        long start = System.nanoTime();

        try {
            indexer.index();
        } finally {
            writer.flush();
            writer.close();
        }

        displayStats(indexer, emitter, start);
    }

    private static PrintWriter createWriter(Arguments arguments) {
        try {
            return new PrintWriter(new File(arguments.outFile));
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Failed to open file %s", arguments.outFile));
        }
    }

    private static void displayStats(ProjectIndexer indexer, Emitter emitter, long start) {
        System.out.printf(
                "%d file(s), %d def(s), %d element(s)\n",
                indexer.numFiles,
                indexer.numDefinitions,
                emitter.numElements()
        );

        System.out.printf("Processed in %.0fms", (System.nanoTime() - start) / 1e6);
    }

}
