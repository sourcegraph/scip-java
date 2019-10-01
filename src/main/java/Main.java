import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Arguments arguments = ArgumentParser.parse(args);

        PrintWriter writer = arguments.stdout
                ? new PrintWriter(System.out)
                : new PrintWriter(new File(arguments.outFile));

        Emitter emitter = new Emitter(writer);
        ProjectIndexer indexer = new ProjectIndexer(arguments, emitter);

        long start = System.nanoTime();

        try {
            indexer.index();
        } finally {
            writer.flush();

            if (!arguments.stdout) {
                writer.close();
            }
        }

        if (!arguments.stdout) {
            long elapsed = System.nanoTime() - start;

            System.out.printf(
                    "%d file(s), %d def(s), %d element(s)\n",
                    indexer.numFiles,
                    indexer.numDefinitions,
                    emitter.getNumElements()
            );

            System.out.printf("Processed in %.0fms", elapsed / 1e6);
        }
    }
}
