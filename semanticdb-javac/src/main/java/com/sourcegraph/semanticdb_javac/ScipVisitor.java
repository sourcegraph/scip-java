package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.semanticdb.LocalSymbolsCache;
import com.sourcegraph.semanticdb.ScipDocumentBuilder;
import com.sourcegraph.semanticdb.SemanticdbSymbols;
import com.sun.source.tree.AnnotatedTypeTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.LineMap;
import com.sun.source.tree.MemberReferenceTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.NewClassTree;
import com.sun.source.tree.PackageTree;
import com.sun.source.tree.ParameterizedTypeTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TypeParameterTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.Signature;
import org.scip_code.scip.SymbolInformation;
import org.scip_code.scip.SymbolRole;

/**
 * Walks a typechecked compilation unit and feeds SCIP {@link Occurrence}/{@link SymbolInformation}
 * messages into a {@link ScipDocumentBuilder}.
 *
 * <p>Replaces the old {@code SemanticdbVisitor} + {@code SemanticdbSignatures} + {@code
 * SemanticdbTrees} chain that first produced SemanticDB protos and then converted them to SCIP.
 * Symbols are emitted in their <em>bare</em> form (e.g. {@code _root_/com/example/Foo#bar().}); the
 * aggregator prefixes them with the resolved package coordinates at index time.
 */
final class ScipVisitor extends TreePathScanner<Void, Void> {
  private final GlobalSymbolsCache globals;
  private final LocalSymbolsCache<Element, String> locals;
  private final Types types;
  private final Trees trees;
  private final Elements elements;
  private final CompilationUnitTree compUnitTree;
  private final ScipDocumentBuilder documentBuilder;
  private final ScipJavaSignatureFormatter signatureFormatter;
  private final LinkedHashMap<Tree, TreePath> nodes = new LinkedHashMap<>();
  private final LinkedHashMap<Element, Tree> declTrees = new LinkedHashMap<>();

  private String source;

  ScipVisitor(
      GlobalSymbolsCache globals,
      LocalSymbolsCache<Element, String> locals,
      CompilationUnitTree compUnitTree,
      Types types,
      Trees trees,
      Elements elements,
      ScipDocumentBuilder documentBuilder) {
    this.globals = globals;
    this.locals = locals;
    this.types = types;
    this.trees = trees;
    this.elements = elements;
    this.compUnitTree = compUnitTree;
    this.documentBuilder = documentBuilder;
    this.signatureFormatter = new ScipJavaSignatureFormatter(trees, compUnitTree);
    this.source = readSource();
  }

  void visitCompilationUnit() {
    scan(compUnitTree, null);
    resolveNodes();
  }

  // =======================================
  // TreePathScanner overrides
  // =======================================
  @Override
  public Void scan(Tree tree, Void unused) {
    if (tree != null) {
      TreePath path = new TreePath(getCurrentPath(), tree);
      nodes.put(tree, path);
    }
    return super.scan(tree, unused);
  }

  @Override
  public Void visitPackage(PackageTree node, Void unused) {
    // JDK 17+ TreePathScanner would otherwise recurse into the package name's
    // identifiers and emit a self-reference for `package X.Y;`. JDK 11 does
    // not. Skipping the package subtree keeps output stable across JDKs.
    return null;
  }

  // =======================================
  // Tree resolution
  // =======================================
  private void resolveNodes() {
    Set<Tree> ignoreNodes = new HashSet<>();
    for (Tree node : nodes.keySet()) {
      if (node instanceof NewClassTree) {
        NewClassTree newClassTree = (NewClassTree) node;
        if (newClassTree.getClassBody() == null) {
          if (newClassTree.getIdentifier() instanceof ParameterizedTypeTree) {
            ParameterizedTypeTree paramNode = (ParameterizedTypeTree) newClassTree.getIdentifier();
            ignoreNodes.add(paramNode.getType());
          }
          ignoreNodes.add(newClassTree.getIdentifier());
        }
      }
    }

    for (Map.Entry<Tree, TreePath> entry : nodes.entrySet()) {
      Tree node = entry.getKey();
      if (ignoreNodes.contains(node)) continue;
      if (node instanceof TypeParameterTree) {
        resolveTypeParameterTree((TypeParameterTree) node, entry.getValue());
      } else if (node instanceof ClassTree) {
        resolveClassTree((ClassTree) node, entry.getValue());
      } else if (node instanceof MethodTree) {
        resolveMethodTree((MethodTree) node, entry.getValue());
      } else if (node instanceof VariableTree) {
        resolveVariableTree((VariableTree) node, entry.getValue());
      } else if (node instanceof IdentifierTree) {
        resolveIdentifierTree((IdentifierTree) node, entry.getValue());
      } else if (node instanceof MemberReferenceTree) {
        resolveMemberReferenceTree((MemberReferenceTree) node, entry.getValue());
      } else if (node instanceof MemberSelectTree) {
        resolveMemberSelectTree((MemberSelectTree) node, entry.getValue());
      } else if (node instanceof NewClassTree) {
        resolveNewClassTree((NewClassTree) node, entry.getValue());
      }
    }
  }

  private void resolveClassTree(ClassTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null && sym.getSimpleName().length() > 0) {
      emitDefinition(sym, node, sym.getSimpleName(), CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
    }
  }

  private void resolveTypeParameterTree(TypeParameterTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null && sym.getSimpleName().length() > 0) {
      emitDefinition(sym, node, sym.getSimpleName(), CompilerRange.FROM_POINT_TO_SYMBOL_NAME);
    }
  }

  private void resolveMethodTree(MethodTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    Element owner = sym.getEnclosingElement();
    if (sym.getKind() == ElementKind.CONSTRUCTOR && isAnonymous(owner)) return;
    Name name =
        sym.getKind() == ElementKind.CONSTRUCTOR ? owner.getSimpleName() : sym.getSimpleName();
    emitDefinition(sym, node, name, CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
  }

  private void resolveVariableTree(VariableTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    int[] range =
        emitDefinition(sym, node, sym.getSimpleName(), CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
    if (sym.getKind() == ElementKind.ENUM_CONSTANT) {
      TreePath typeTreePath = nodes.get(node.getInitializer());
      Element typeSym = trees.getElement(typeTreePath);
      if (typeSym != null && range != null) {
        emitOccurrence(typeSym, range, 0, null);
      }
    }
  }

  private void resolveIdentifierTree(IdentifierTree node, TreePath treePath) {
    Name nodeName = node.getName();
    if (nodeName == null) return;
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    boolean isThis = nodeName.toString().equals("this");
    boolean isSuper = !isThis && nodeName.toString().equals("super");
    // exclude `this.` references but include `this(` and `super(` references
    if (!(((sym.getKind() == ElementKind.CONSTRUCTOR) == isThis) || isSuper)) return;
    TreePath parentPath = treePath.getParentPath();
    Element parentSym = trees.getElement(parentPath);
    if (parentSym == null || parentSym.getKind() != null) {
      emitReference(sym, node, sym.getSimpleName(), CompilerRange.FROM_START_TO_END);
    }
  }

  private void resolveMemberReferenceTree(MemberReferenceTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    emitReference(sym, node, sym.getSimpleName(), CompilerRange.FROM_END_TO_SYMBOL_NAME);
  }

  private void resolveMemberSelectTree(MemberSelectTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    emitReference(sym, node, sym.getSimpleName(), CompilerRange.FROM_END_TO_SYMBOL_NAME);
  }

  private void resolveNewClassTree(NewClassTree node, TreePath treePath) {
    if (node.getIdentifier() == null || node.getClassBody() != null) return;
    Element sym = trees.getElement(treePath);
    if (sym == null) return;
    TreePath parentPath = treePath.getParentPath();
    Element parentSym = trees.getElement(parentPath);
    if (parentSym != null && parentSym.getKind() == ElementKind.ENUM_CONSTANT) return;

    TreePath identifierTreePath = nodes.get(node.getIdentifier());
    Element identifierSym = trees.getElement(identifierTreePath);
    if (identifierSym != null) {
      emitReference(sym, node, identifierSym.getSimpleName(), CompilerRange.FROM_TEXT_SEARCH);
    } else if (node.getIdentifier().getKind() == Tree.Kind.ANNOTATED_TYPE) {
      AnnotatedTypeTree annotatedTypeTree = (AnnotatedTypeTree) node.getIdentifier();
      if (annotatedTypeTree.getUnderlyingType() != null
          && annotatedTypeTree.getUnderlyingType().getKind() == Tree.Kind.IDENTIFIER) {
        IdentifierTree ident = (IdentifierTree) annotatedTypeTree.getUnderlyingType();
        emitReference(sym, ident, ident.getName(), CompilerRange.FROM_TEXT_SEARCH);
      }
    }
  }

  // =======================================
  // Occurrence + SymbolInformation emission
  // =======================================
  private int[] emitDefinition(Element sym, Tree tree, Name name, CompilerRange kind) {
    int[] range = computeRange(tree, kind, sym, name == null ? null : name.toString());
    if (range == null) return null;
    emitOccurrence(sym, range, SymbolRole.Definition_VALUE, computeEnclosingRange(tree));
    declTrees.put(sym, tree);
    emitSymbolInformation(sym, tree);
    return range;
  }

  private void emitReference(Element sym, Tree tree, Name name, CompilerRange kind) {
    int[] range = computeRange(tree, kind, sym, name == null ? null : name.toString());
    if (range == null) return;
    emitOccurrence(sym, range, 0 /* reference */, null);
  }

  private void emitOccurrence(Element sym, int[] range, int role, int[] enclosingRange) {
    String symbol = scipSymbol(sym);
    if (symbol.isEmpty()) return;
    Occurrence.Builder b = Occurrence.newBuilder().setSymbol(symbol).setSymbolRoles(role);
    for (int v : range) b.addRange(v);
    if (enclosingRange != null) {
      for (int v : enclosingRange) b.addEnclosingRange(v);
    }
    documentBuilder.addOccurrence(b.build());
  }

  private void emitSymbolInformation(Element sym, Tree tree) {
    String symbol = scipSymbol(sym);
    if (symbol.isEmpty()) return;

    SymbolInformation.Builder builder =
        SymbolInformation.newBuilder()
            .setSymbol(symbol)
            .setDisplayName(sym.getSimpleName().toString());

    String signatureText = signatureFormatter.format(sym, tree);
    if (!signatureText.isEmpty()) {
      builder.setSignatureDocumentation(
          Signature.newBuilder().setLanguage("java").setText(signatureText));
    }

    String documentation = docComment(tree);
    if (documentation != null && !documentation.isEmpty()) {
      builder.addDocumentation(documentation);
    }

    if (SemanticdbSymbols.isLocal(symbol)) {
      String enclosingSymbol = scipSymbol(sym.getEnclosingElement());
      if (!enclosingSymbol.isEmpty()) builder.setEnclosingSymbol(enclosingSymbol);
    }

    SymbolInformation.Kind kind = scipKind(sym);
    if (kind != SymbolInformation.Kind.UnspecifiedKind) builder.setKind(kind);

    if (sym instanceof TypeElement) {
      for (TypeElement parent : parentTypeElements((TypeElement) sym)) {
        String parentSymbol = scipSymbol(parent);
        if (parentSymbol.isEmpty()) continue;
        builder.addRelationships(
            Relationship.newBuilder().setSymbol(parentSymbol).setIsImplementation(true));
      }
    } else if (sym instanceof ExecutableElement && sym.getKind() == ElementKind.METHOD) {
      for (String overridden :
          overriddenSymbols((ExecutableElement) sym, sym.getEnclosingElement(), new HashSet<>())) {
        if (overridden.isEmpty()) continue;
        builder.addRelationships(
            Relationship.newBuilder()
                .setSymbol(overridden)
                .setIsImplementation(true)
                .setIsReference(true));
      }
    }

    if (sym.getKind() == ElementKind.ENUM_CONSTANT && tree instanceof VariableTree) {
      VariableTree variableTree = (VariableTree) tree;
      if (variableTree.getInitializer() instanceof NewClassTree) {
        String args =
            ((NewClassTree) variableTree.getInitializer())
                .getArguments().stream()
                    .map(ExpressionTree::toString)
                    .collect(Collectors.joining(", "));
        if (!args.isEmpty()) {
          builder.setDisplayName(sym.getSimpleName().toString() + "(" + args + ")");
        }
      }
    }

    documentBuilder.addSymbol(builder.build());
  }

  private SymbolInformation.Kind scipKind(Element sym) {
    Set<Modifier> mods = sym.getModifiers();
    boolean isStatic = mods.contains(Modifier.STATIC);
    boolean isAbstract = mods.contains(Modifier.ABSTRACT);
    boolean isDefault = mods.contains(Modifier.DEFAULT);
    switch (sym.getKind()) {
      case ENUM:
        return SymbolInformation.Kind.Enum;
      case CLASS:
        return SymbolInformation.Kind.Class;
      case INTERFACE:
      case ANNOTATION_TYPE:
        return SymbolInformation.Kind.Interface;
      case CONSTRUCTOR:
        return SymbolInformation.Kind.Constructor;
      case METHOD:
        if (isStatic) return SymbolInformation.Kind.StaticMethod;
        if (isAbstract && !isDefault) return SymbolInformation.Kind.AbstractMethod;
        return SymbolInformation.Kind.Method;
      case FIELD:
        return isStatic ? SymbolInformation.Kind.StaticField : SymbolInformation.Kind.Field;
      case LOCAL_VARIABLE:
        return SymbolInformation.Kind.Variable;
      case TYPE_PARAMETER:
        return SymbolInformation.Kind.TypeParameter;
      default:
        return SymbolInformation.Kind.UnspecifiedKind;
    }
  }

  // =======================================
  // Source position / range computation
  // =======================================
  private int[] computeRange(Tree tree, CompilerRange kind, Element sym, String name) {
    if (sym == null) return null;
    SourcePositions sourcePositions = trees.getSourcePositions();
    int start = (int) sourcePositions.getStartPosition(compUnitTree, tree);
    int end = (int) sourcePositions.getEndPosition(compUnitTree, tree);
    if (kind.isPlusOne()) start++;

    if (name != null) {
      if (kind.isFromTextSearch() && name.length() > 0) {
        Optional<RangeFinder.StartEndRange> startEndRange =
            RangeFinder.findRange(sym, name, start, end, this.source, kind.isFromEnd());
        if (startEndRange.isPresent()) {
          start = startEndRange.get().start;
          end = startEndRange.get().end;
        }
      } else if (kind.isFromPoint()) {
        if (start != Diagnostic.NOPOS) {
          int testEnd = start + name.length();
          if (source.length() > testEnd && source.substring(start, testEnd).equals(name))
            end = testEnd;
        }
      } else if (kind.isFromEndPoint()) {
        if (end != Diagnostic.NOPOS) {
          int testStart = end - name.length();
          if (testStart >= 0
              && source.length() > end
              && source.substring(testStart, end).equals(name)) start = testStart;
        }
      }
    }

    return lineMapRange(start, end);
  }

  private int[] computeEnclosingRange(Tree tree) {
    if (tree == null) return null;
    TreePath path = nodes.get(tree);
    if (path == null) return null;
    Tree enclosingTree = tree;
    if (!(tree instanceof MethodTree
        || tree instanceof ClassTree
        || tree instanceof VariableTree)) {
      TreePath parentPath = path.getParentPath();
      if (parentPath == null) return null;
      enclosingTree = parentPath.getLeaf();
      if (enclosingTree == null || enclosingTree == compUnitTree) return null;
    }
    SourcePositions sourcePositions = trees.getSourcePositions();
    int start = (int) sourcePositions.getStartPosition(compUnitTree, enclosingTree);
    int end = (int) sourcePositions.getEndPosition(compUnitTree, enclosingTree);
    return lineMapRange(start, end);
  }

  private int[] lineMapRange(int start, int end) {
    if (start == Diagnostic.NOPOS || end == Diagnostic.NOPOS || end <= start) return null;
    LineMap lineMap = compUnitTree.getLineMap();
    int startLine = (int) lineMap.getLineNumber(start) - 1;
    int startChar = (int) lineMap.getColumnNumber(start) - 1;
    int endLine = (int) lineMap.getLineNumber(end) - 1;
    int endChar = (int) lineMap.getColumnNumber(end) - 1;

    // javac reports tab columns as if every tab were 8 spaces; correct that when
    // the line is actually tab-indented.
    int linePos = (int) lineMap.getPosition(lineMap.getLineNumber(start), 0);
    if (linePos >= 0 && linePos < source.length() && source.charAt(linePos) == '\t') {
      int count = 1;
      while (++linePos < source.length() && source.charAt(linePos) == '\t') count++;
      startChar -= count * 7;
      endChar -= count * 7;
    }

    if (startLine == endLine) return new int[] {startLine, startChar, endChar};
    return new int[] {startLine, startChar, endLine, endChar};
  }

  // =======================================
  // Symbol resolution
  // =======================================
  private String scipSymbol(Element sym) {
    return globals.symbol(sym, locals);
  }

  private List<TypeElement> parentTypeElements(TypeElement typeElement) {
    List<TypeElement> result = new ArrayList<>();
    Set<TypeElement> seen = new HashSet<>();
    collectParents(typeElement, seen, result);
    return result;
  }

  private void collectParents(
      TypeElement typeElement, Set<TypeElement> seen, List<TypeElement> out) {
    addParent(typeElement.getSuperclass(), seen, out);
    for (TypeMirror itf : typeElement.getInterfaces()) addParent(itf, seen, out);
  }

  private void addParent(TypeMirror parent, Set<TypeElement> seen, List<TypeElement> out) {
    if (parent instanceof NoType) return;
    Element parentElement = types.asElement(parent);
    if (!(parentElement instanceof TypeElement)) return;
    if (!seen.add((TypeElement) parentElement)) return;
    // Skip java.lang.Object: it is the implicit superclass of every class and would
    // dominate find-implementations searches in downstream tooling.
    if (!isJavaLangObject((TypeElement) parentElement)) {
      out.add((TypeElement) parentElement);
    }
    collectParents((TypeElement) parentElement, seen, out);
  }

  private static boolean isJavaLangObject(TypeElement element) {
    return "java.lang.Object".contentEquals(element.getQualifiedName());
  }

  private Set<String> overriddenSymbols(
      ExecutableElement sym, Element enclosingElement, Set<String> out) {
    if (!(enclosingElement instanceof TypeElement)) return out;
    for (TypeMirror superType : types.directSupertypes(enclosingElement.asType())) {
      if (!(superType instanceof DeclaredType)) continue;
      Element superElement = ((DeclaredType) superType).asElement();
      if (!(superElement instanceof TypeElement)) continue;
      boolean methodFound = false;
      for (Element enclosed : superElement.getEnclosedElements()) {
        if (!(enclosed instanceof ExecutableElement)) continue;
        ExecutableElement candidate = (ExecutableElement) enclosed;
        if (!elements.overrides(sym, candidate, (TypeElement) sym.getEnclosingElement())) continue;
        String symbol = scipSymbol(candidate);
        if (!symbol.isEmpty()) out.add(symbol);
        methodFound = true;
        overriddenSymbols(candidate, superElement, out);
      }
      if (!methodFound) overriddenSymbols(sym, superElement, out);
    }
    return out;
  }

  // =======================================
  // Misc
  // =======================================
  private String readSource() {
    try {
      return compUnitTree.getSourceFile().getCharContent(true).toString();
    } catch (IOException e) {
      return "";
    }
  }

  String getSource() {
    return source;
  }

  private String docComment(Tree tree) {
    try {
      TreePath treePath = nodes.get(tree);
      return trees.getDocComment(treePath);
    } catch (NullPointerException e) {
      // javac's JavacElements#getDocComment occasionally NPEs on synthetic trees.
      return null;
    }
  }

  private static boolean isAnonymous(Element sym) {
    return sym != null && sym.getSimpleName().length() == 0;
  }
}
