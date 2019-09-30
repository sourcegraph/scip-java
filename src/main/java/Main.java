import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Arguments arguments = ArgumentParser.parse(args);

        PrintWriter writer = arguments.stdout
                ? new PrintWriter(System.out)
                : new PrintWriter(new File(arguments.outFile));

        try {
            new ProjectIndexer(arguments, new Emitter(writer)).index();
        } finally {
            if (!arguments.stdout) {
                writer.close();
            }
        }
    }
}
