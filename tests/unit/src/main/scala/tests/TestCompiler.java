package tests;

import com.sourcegraph.semanticdb_javac.Semanticdb;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class TestCompiler {

    private final String classpath;
    private final List<String> options;
    private final Path targetroot;
    private static final String PROCESSOR_PATH = System.getProperty("java.class.path");

    public TestCompiler(Path targetroot) {
        this(PROCESSOR_PATH, new ArrayList<>(), targetroot);
    }

    public TestCompiler(String classpath, List<String> options, Path targetroot) {
        this.classpath = classpath;
        this.options = options;
        this.targetroot = targetroot;
    }

    public static class CompileResult {
        public final byte[] byteCode;
        public final String stdout;
        public final Semanticdb.TextDocument textDocument;
        public final boolean isSuccess;

        public CompileResult(byte[] byteCode, String stdout, Semanticdb.TextDocument textDocument, boolean isSuccess) {
            this.byteCode = byteCode;
            this.stdout = stdout;
            this.textDocument = textDocument;
            this.isSuccess = isSuccess;
        }
    }

    public CompileResult compile(String relativePath, String testSource) throws IOException {
        StringWriter output = new StringWriter();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        SimpleFileManager fileManager = new SimpleFileManager(
                compiler.getStandardFileManager(null, null, null));
        Path sourceroot = Files.createTempDirectory("semanticdb-javac");
        Path source = sourceroot.resolve(relativePath);
        List<SimpleSourceFile> compilationUnits
                = singletonList(new SimpleSourceFile(source, testSource));
        List<String> arguments = new ArrayList<>();
        arguments.add("-processorpath");
        arguments.add(PROCESSOR_PATH);
        arguments.add("-classpath");
        arguments.add(classpath);
        arguments.addAll(options);
        arguments.add(String.format("-Xplugin:semanticdb -verbose -text:on -sourceroot:%s -targetroot:%s", sourceroot, targetroot));

        JavaCompiler.CompilationTask task = compiler.getTask(
                output, fileManager, null, arguments,
                null, compilationUnits);

        Boolean isSuccess = task.call();


        byte[] bytecode = new byte[0];
        if (!fileManager.compiled.isEmpty()) {
            bytecode = fileManager.compiled.iterator().next().getCompiledBinaries();
        }

        Semanticdb.TextDocument textDocument = Semanticdb.TextDocument.newBuilder().build();
        Path outputPath = targetroot.resolve("META-INF").resolve("semanticdb").resolve(relativePath + ".semanticdb");
        if (Files.isRegularFile(outputPath)) {
            Semanticdb.TextDocuments textDocuments = Semanticdb.TextDocuments.parseFrom(Files.readAllBytes(outputPath));
            if (textDocuments.getDocumentsCount() > 0) {
                textDocument = textDocuments.getDocuments(0);
            }
        }

        String stdout = output.toString();
        return new CompileResult(bytecode, stdout, textDocument, isSuccess);
    }
}

