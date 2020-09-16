package lsifjava;

public class Arguments {
    public final String projectRoot;
    public final String outFile;
    public final boolean verbose;

    public Arguments(String projectRoot, String outFile, boolean verbose) {
        this.projectRoot = projectRoot;
        this.outFile = outFile;
        this.verbose = verbose;
    }
}
