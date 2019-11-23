public class Arguments {
    public final String projectRoot;
    public final boolean contents;
    public final String outFile;
    public final boolean stdout;

    public Arguments(String projectRoot, boolean contents, String outFile, boolean stdout) {
        this.projectRoot = projectRoot;
        this.contents = contents;
        this.outFile = outFile != null ? outFile : projectRoot + "/dump.lsif";
        this.stdout = stdout;
    }
}
