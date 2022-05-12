package com.sourcegraph.semanticdb_javac;

import com.sun.source.tree.*;
import com.sun.source.util.*;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.EndPosTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.Position;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Kind;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Property;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;

import javax.lang.model.element.ElementKind;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.SemanticdbBuilders.*;
import static com.sourcegraph.semanticdb_javac.SemanticdbTypeVisitor.ARRAY_SYMBOL;

/** Walks the AST of a typechecked compilation unit and generates a SemanticDB TextDocument. */
public class SemanticdbVisitor extends TreePathScanner<Void, Void> {

  private final GlobalSymbolsCache globals;
  private final LocalSymbolsCache locals;
  private final JavacTask task;
  private final TaskEvent event;
  private final JavacTypes javacTypes;
  private final Trees trees;
  private final SemanticdbJavacOptions options;
  private final EndPosTable endPosTable;
  private final ArrayList<Semanticdb.SymbolOccurrence> occurrences;
  private final ArrayList<Semanticdb.SymbolInformation> symbolInfos;
  private String source;

  public SemanticdbVisitor(
      JavacTask task,
      GlobalSymbolsCache globals,
      TaskEvent event,
      SemanticdbJavacOptions options,
      JavacTypes javacTypes) {
    this.task = task;
    this.globals = globals; // Reused cache between compilation units.
    this.locals = new LocalSymbolsCache(); // Fresh cache per compilation unit.
    this.event = event;
    this.options = options;
    this.javacTypes = javacTypes;
    this.trees = Trees.instance(task);
    if (event.getCompilationUnit() instanceof JCTree.JCCompilationUnit) {
      this.endPosTable = ((JCTree.JCCompilationUnit) event.getCompilationUnit()).endPositions;
    } else {
      this.endPosTable = new EmptyEndPosTable();
    }
    this.occurrences = new ArrayList<>();
    this.symbolInfos = new ArrayList<>();
    this.source = semanticdbText();
  }

  public Semanticdb.TextDocument buildTextDocument(CompilationUnitTree tree) {
    this.scan(tree, null); // Trigger recursive AST traversal to collect SemanticDB information.

    return Semanticdb.TextDocument.newBuilder()
        .setSchema(Semanticdb.Schema.SEMANTICDB4)
        .setLanguage(Semanticdb.Language.JAVA)
        .setUri(semanticdbUri())
        .setText(options.includeText ? this.source : "")
        .setMd5(semanticdbMd5())
        .addAllOccurrences(occurrences)
        .addAllSymbols(symbolInfos)
        .build();
  }

  private <T extends JCTree & JCDiagnostic.DiagnosticPosition> void emitSymbolOccurrence(
      Symbol sym, T posTree, Role role, CompilerRange kind) {
    if (sym == null) return;
    Optional<Semanticdb.SymbolOccurrence> occ = semanticdbOccurrence(sym, posTree, kind, role);
    occ.ifPresent(occurrences::add);
    if (role == Role.DEFINITION) {
      // Only emit SymbolInformation for symbols that are defined in this compilation unit.
      emitSymbolInformation(sym, posTree);
    }
  }

  private void emitSymbolInformation(Symbol sym, JCTree tree) {
    Semanticdb.SymbolInformation.Builder builder = symbolInformation(semanticdbSymbol(sym));
    Semanticdb.Documentation documentation = semanticdbDocumentation(sym);
    if (documentation != null) builder.setDocumentation(documentation);
    Semanticdb.Signature signature = semanticdbSignature(sym);
    if (signature != null) builder.setSignature(signature);
    List<Semanticdb.AnnotationTree> annotations =
        new SemanticdbTrees(globals, locals, semanticdbUri()).annotations(tree);
    if (annotations != null) builder.addAllAnnotations(annotations);

    builder
        .setProperties(semanticdbSymbolInfoProperties(sym))
        .setDisplayName(sym.name.toString())
        .setAccess(semanticdbAccess(sym));

    switch (sym.getKind()) {
      case ENUM:
      case CLASS:
        builder.setKind(Kind.CLASS);
        builder.addAllOverriddenSymbols(semanticdbParentSymbols(sym, new ArrayList<>()));
        break;
      case INTERFACE:
      case ANNOTATION_TYPE:
        builder.setKind(Kind.INTERFACE);
        builder.addAllOverriddenSymbols(semanticdbParentSymbols(sym, new ArrayList<>()));
        break;
      case FIELD:
        builder.setKind(Kind.FIELD);
        break;
      case METHOD:
        builder.setKind(Kind.METHOD);
        builder.addAllOverriddenSymbols(semanticdbOverrides(sym));
        break;
      case CONSTRUCTOR:
        builder.setKind(Kind.CONSTRUCTOR);
        break;
      case TYPE_PARAMETER:
        builder.setKind(Kind.TYPE_PARAMETER);
        break;
      case ENUM_CONSTANT: // overwrite previous value here
        String args =
            ((JCTree.JCNewClass) ((JCTree.JCVariableDecl) tree).init)
                .args.stream().map(JCTree::toString).collect(Collectors.joining(", "));
        if (!args.isEmpty()) builder.setDisplayName(sym.name.toString() + "(" + args + ")");
    }

    Semanticdb.SymbolInformation info = builder.build();

    symbolInfos.add(info);
  }

  // =======================================
  // Overridden methods from TreePathScanner
  // =======================================

  @Override
  public Void visitClass(ClassTree node, Void unused) {
    if (node instanceof JCTree.JCClassDecl) {
      JCTree.JCClassDecl cls = (JCTree.JCClassDecl) node;
      if (cls.sym == null) return super.visitClass(node, unused);
      emitSymbolOccurrence(
          cls.sym, cls, Role.DEFINITION, CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);

      List<JCTree.JCTypeParameter> typeParameters = cls.getTypeParameters();
      int i = 0;
      for (Symbol.TypeVariableSymbol typeSym : cls.sym.getTypeParameters()) {
        if (i >= typeParameters.size()) {
          // Happens in testcontainers/testcontainers-java, see
          // https://github.com/sourcegraph/scip-java/issues/319
          // Failed to reproduce with a minimal source file so we don't have a test case that hits
          // this branch.
          break;
        }
        emitSymbolOccurrence(
            typeSym,
            typeParameters.get(i),
            Role.DEFINITION,
            CompilerRange.FROM_POINT_TO_SYMBOL_NAME);
        i++;
      }
    }
    return super.visitClass(node, unused);
  }

  @Override
  public Void visitMethod(MethodTree node, Void unused) {
    if (node instanceof JCTree.JCMethodDecl) {
      JCTree.JCMethodDecl meth = (JCTree.JCMethodDecl) node;
      if (meth.sym == null) return super.visitMethod(node, unused);
      CompilerRange range = CompilerRange.FROM_POINT_TO_SYMBOL_NAME;
      if (meth.sym.isConstructor()) {
        if (meth.sym.owner.isAnonymous()) return null;
        range = CompilerRange.FROM_POINT_WITH_TEXT_SEARCH;
      }
      emitSymbolOccurrence(meth.sym, meth, Role.DEFINITION, range);

      List<JCTree.JCTypeParameter> typeParameters = meth.getTypeParameters();
      int i = 0;
      for (Symbol.TypeVariableSymbol typeSym : meth.sym.getTypeParameters()) {
        emitSymbolOccurrence(
            typeSym,
            typeParameters.get(i),
            Role.DEFINITION,
            CompilerRange.FROM_POINT_TO_SYMBOL_NAME);
        i++;
      }
    }
    return super.visitMethod(node, unused);
  }

  @Override
  public Void visitVariable(VariableTree node, Void unused) {
    if (node instanceof JCTree.JCVariableDecl) {
      JCTree.JCVariableDecl decl = (JCTree.JCVariableDecl) node;
      emitSymbolOccurrence(
          decl.sym, decl, Role.DEFINITION, CompilerRange.FROM_POINT_TO_SYMBOL_NAME);
    }
    return super.visitVariable(node, unused);
  }

  @Override
  public Void visitIdentifier(IdentifierTree node, Void unused) {
    if (node instanceof JCTree.JCIdent) {
      JCTree.JCIdent ident = (JCTree.JCIdent) node;
      if (ident.name == null || ident.sym == null) return null;
      if (ident.name.toString().equals("this") && ident.sym.getKind() != ElementKind.CONSTRUCTOR)
        return null;
      emitSymbolOccurrence(ident.sym, ident, Role.REFERENCE, CompilerRange.FROM_START_TO_END);
    }
    return super.visitIdentifier(node, unused);
  }

  @Override
  public Void visitMemberReference(MemberReferenceTree node, Void unused) {
    if (node instanceof JCTree.JCMemberReference) {
      JCTree.JCMemberReference ref = (JCTree.JCMemberReference) node;
      emitSymbolOccurrence(ref.sym, ref, Role.REFERENCE, CompilerRange.FROM_END_WITH_TEXT_SEARCH);
    }
    return super.visitMemberReference(node, unused);
  }

  @Override
  public Void visitMemberSelect(MemberSelectTree node, Void unused) {
    if (node instanceof JCTree.JCFieldAccess) {
      JCTree.JCFieldAccess select = (JCTree.JCFieldAccess) node;
      emitSymbolOccurrence(
          select.sym, select, Role.REFERENCE, CompilerRange.FROM_POINT_TO_SYMBOL_NAME_PLUS_ONE);
    }
    return super.visitMemberSelect(node, unused);
  }

  @Override
  public Void visitNewClass(NewClassTree node, Void unused) {
    if (node instanceof JCTree.JCNewClass) {
      JCTree.JCNewClass cls = (JCTree.JCNewClass) node;
      if (cls.type != null && cls.type.tsym != null && !cls.type.tsym.isAnonymous()) {
        emitSymbolOccurrence(cls.constructor, cls, Role.REFERENCE, CompilerRange.FROM_TEXT_SEARCH);
      }
    }

    // to avoid emitting a reference to the class itself, we manually scan everything
    // except the identifier
    scan(node.getTypeArguments(), unused);
    scan(node.getArguments(), unused);
    return scan(node.getClassBody(), unused);
  }

  // =================================================
  // Utilities to generate SemanticDB data structures.
  // =================================================

  private Semanticdb.Signature semanticdbSignature(Symbol sym) {

    return new SemanticdbSignatures(globals, locals).generateSignature(sym);
  }

  private String semanticdbSymbol(Symbol sym) {
    return globals.semanticdbSymbol(sym, locals);
  }

  private Optional<Semanticdb.Range> semanticdbRange(
      JCDiagnostic.DiagnosticPosition pos, CompilerRange kind, Symbol sym) {
    LineMap lineMap = event.getCompilationUnit().getLineMap();
    if (sym == null) return Optional.empty();
    int start, end;
    if (kind.isFromPoint() && sym.name != null) {
      start = pos.getPreferredPosition();
      if (kind == CompilerRange.FROM_POINT_TO_SYMBOL_NAME_PLUS_ONE) {
        start++;
      }
      end = start + sym.name.length();
    } else {
      start = pos.getStartPosition();
      end = pos.getEndPosition(endPosTable);
    }

    if (kind.isFromTextSearch() && sym.name.length() > 0) {
      Optional<Semanticdb.Range> range =
          RangeFinder.findRange(
              getCurrentPath(),
              trees,
              getCurrentPath().getCompilationUnit(),
              sym,
              start,
              this.source,
              kind.isFromEnd());
      if (range.isPresent()) return Optional.of(correctForTabs(range.get(), lineMap, start));
      else return range;
    } else if (start != Position.NOPOS && end != Position.NOPOS && end > start) {
      Semanticdb.Range range =
          Semanticdb.Range.newBuilder()
              .setStartLine((int) lineMap.getLineNumber(start) - 1)
              .setStartCharacter((int) lineMap.getColumnNumber(start) - 1)
              .setEndLine((int) lineMap.getLineNumber(end) - 1)
              .setEndCharacter((int) lineMap.getColumnNumber(end) - 1)
              .build();

      range = correctForTabs(range, lineMap, start);

      return Optional.of(range);
    }

    return Optional.empty();
  }

  private Semanticdb.Range correctForTabs(Semanticdb.Range range, LineMap lineMap, int start) {
    int startLinePos = (int) lineMap.getPosition(lineMap.getLineNumber(start), 0);

    // javac replaces every tab with 8 spaces in the linemap. As this is potentially inconsistent
    // with the source file itself, we adjust for that here if the line is actually indented with
    // tabs.
    // As for every tab there are 8 spaces, we remove 7 spaces for every tab to get the correct
    // char offset (note: different to _column_ offset your editor shows)
    if (this.source.charAt(startLinePos) == '\t') {
      int count = 1;
      while (this.source.charAt(++startLinePos) == '\t') count++;
      range =
          range
              .toBuilder()
              .setStartCharacter(range.getStartCharacter() - (count * 7))
              .setEndCharacter(range.getEndCharacter() - (count * 7))
              .build();
    }

    return range;
  }

  private Optional<Semanticdb.SymbolOccurrence> semanticdbOccurrence(
      Symbol sym, JCDiagnostic.DiagnosticPosition pos, CompilerRange kind, Role role) {
    Optional<Semanticdb.Range> range = semanticdbRange(pos, kind, sym);
    if (range.isPresent()) {
      String ssym = semanticdbSymbol(sym);
      if (!ssym.equals(SemanticdbSymbols.NONE)) {
        Semanticdb.SymbolOccurrence occ = symbolOccurrence(ssym, range.get(), role);
        return Optional.of(occ);
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.empty();
    }
  }

  private String semanticdbText() {
    if (source != null) return source;
    try {
      source = event.getSourceFile().getCharContent(true).toString();
    } catch (IOException e) {
      source = "";
    }
    return source;
  }

  private String semanticdbMd5() {
    try {
      return MD5.digest(event.getSourceFile().getCharContent(true).toString());
    } catch (IOException | NoSuchAlgorithmException e) {
      return "";
    }
  }

  private int semanticdbSymbolInfoProperties(Symbol sym) {
    int properties = 0;
    properties |= sym.isEnum() ? Property.ENUM_VALUE : 0;
    properties |= sym.isStatic() ? Property.STATIC_VALUE : 0;
    // for default interface methods, Flags.ABSTRACT is also set...
    boolean abstractNotDefault =
        ((sym.flags() & Flags.ABSTRACT) > 0) && ((sym.flags() & Flags.DEFAULT) == 0);
    properties |= abstractNotDefault ? Property.ABSTRACT_VALUE : 0;
    properties |= (sym.flags() & Flags.FINAL) > 0 ? Property.FINAL_VALUE : 0;
    properties |= (sym.flags() & Flags.DEFAULT) > 0 ? Property.DEFAULT_VALUE : 0;
    return properties;
  }

  private List<String> semanticdbParentSymbols(Symbol sym, List<String> result) {
    if (!(sym instanceof Symbol.ClassSymbol)) {
      return result;
    }
    Symbol.ClassSymbol csym = (Symbol.ClassSymbol) sym;
    if (csym.getSuperclass() != Type.noType) {
      semanticdbParentSymbol(csym.getSuperclass().tsym, result);
    }
    for (Type iType : csym.getInterfaces()) {
      semanticdbParentSymbol(iType.tsym, result);
    }
    return result;
  }

  private void semanticdbParentSymbol(Symbol sym, List<String> result) {
    if (sym == null) {
      return;
    }
    String ssym = semanticdbSymbol(sym);
    if (!Objects.equals(ssym, SemanticdbSymbols.NONE)) {
      result.add(ssym);
      semanticdbParentSymbols(sym, result);
    }
  }

  private List<String> semanticdbOverrides(Symbol sym) {
    ArrayList<String> overriddenSymbols = new ArrayList<>();
    Set<Symbol.MethodSymbol> overriddenMethods = javacTypes.getOverriddenMethods(sym);

    for (Symbol.MethodSymbol meth : overriddenMethods) {
      overriddenSymbols.add(semanticdbSymbol(meth));
    }

    return overriddenSymbols;
  }

  private Semanticdb.Access semanticdbAccess(Symbol sym) {
    switch ((int) sym.flags() & Flags.AccessFlags) {
      case Flags.PRIVATE:
        return privateAccess();
      case Flags.PUBLIC:
        return publicAccess();
      case Flags.PROTECTED:
        return protectedAccess();
      case 0:
        return privateWithinAccess(semanticdbSymbol(sym.owner));
      default:
        throw new IllegalStateException("access flag " + (sym.flags() & Flags.AccessFlags));
    }
  }

  private String semanticdbUri() {
    Path absolutePath = SemanticdbTaskListener.absolutePathFromUri(options, event.getSourceFile());
    Path relativePath = options.sourceroot.relativize(absolutePath);
    StringBuilder out = new StringBuilder();
    Iterator<Path> it = relativePath.iterator();
    if (it.hasNext()) out.append(it.next().getFileName().toString());
    while (it.hasNext()) {
      Path part = it.next();
      out.append('/').append(part.getFileName().toString());
    }
    return out.toString();
  }

  private Semanticdb.Documentation semanticdbDocumentation(Symbol sym) {
    try {
      Elements elements = task.getElements();
      if (elements == null) return null;

      String doc = elements.getDocComment(sym);
      if (doc == null) return null;

      return Semanticdb.Documentation.newBuilder()
          .setFormat(Semanticdb.Documentation.Format.JAVADOC)
          .setMessage(doc)
          .build();
    } catch (NullPointerException e) {
      // Can happen in `getDocComment()`
      // Caused by: java.lang.NullPointerException
      //   at com.sun.tools.javac.model.JavacElements.cast(JavacElements.java:605)
      //   at com.sun.tools.javac.model.JavacElements.getTreeAndTopLevel(JavacElements.java:543)
      //   at com.sun.tools.javac.model.JavacElements.getDocComment(JavacElements.java:321)
      //   at
      // com.sourcegraph.semanticdb_javac.SemanticdbVisitor.semanticdbDocumentation(SemanticdbVisitor.java:233)
      return null;
    }
  }
}
