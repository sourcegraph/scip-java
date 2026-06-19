package tests;

import java.util.Collections;
import java.util.List;
import org.scip_code.scip.Document;

/** Result of an in-process javac compilation driven by {@link TestCompiler}. */
public final class CompileResult {
  public final byte[] byteCode;
  public final String stdout;
  public final List<Document> documents;
  public final boolean isSuccess;

  public CompileResult(
      byte[] byteCode, String stdout, List<Document> documents, boolean isSuccess) {
    this.byteCode = byteCode;
    this.stdout = stdout;
    this.documents = documents;
    this.isSuccess = isSuccess;
  }

  public static CompileResult empty() {
    return new CompileResult(new byte[0], "", Collections.emptyList(), true);
  }
}
