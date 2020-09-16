package lsifjava;

import java.io.IOException;
import java.nio.file.Paths;

public class Arguments {
    public final String projectRoot;
    public final boolean contents;
    public final String outFile;
    public final boolean verbose;

    public Arguments(String projectRoot, boolean contents, String outFile, boolean verbose) throws IOException {
        this.projectRoot = Paths.get(projectRoot).toFile().getCanonicalPath();
        this.contents = contents;
        this.outFile = outFile != null ? outFile : projectRoot + "/dump.lsif";
        this.verbose = verbose;
    }
}
