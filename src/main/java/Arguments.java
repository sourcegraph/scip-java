public class Arguments {
    public final String projectRoot;
    public final boolean noContents;
    public final String outFile;
    public final boolean stdout;

    public Arguments(String projectRoot, boolean noContents, String outFile, boolean stdout) {
        this.projectRoot = projectRoot;
        this.noContents = noContents;
        this.outFile = outFile;
        this.stdout = stdout;
    }
}
