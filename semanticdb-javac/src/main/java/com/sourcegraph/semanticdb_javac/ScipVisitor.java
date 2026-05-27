package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.Scip;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;
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
import com.sun.source.tree.ParameterizedTypeTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TypeParameterTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

/**
 * Walks the AST of a typechecked compilation unit and generates a {@link Scip.Document} directly.
 *
 * <p>Structurally this is a fork of {@link SemanticdbVisitor} that emits SCIP types instead of
 * SemanticDB ones. Symbols are produced through {@link GlobalSymbolsCache} and then translated to
 * the placeholder SCIP form via {@link ScipSymbols#fromSemanticdbSymbol(String)}. Signature
 * documentation is produced by {@link ScipSignatureFormatter} directly from javac's element model.
 */
public final class ScipVisitor extends TreePathScanner<Void, Void> {

  private final GlobalSymbolsCache globals;
  private final LocalSymbolsCache locals;
  private final Types types;
  private final Trees trees;
  private final CompilationUnitTree compUnitTree;
  private final Elements elements;
  private final SemanticdbJavacOptions options;
  private final ArrayList<Scip.Occurrence> occurrences;
  private final LinkedHashMap<String, Scip.SymbolInformation> symbols;
  private final String source;
  private final String relativePath;
  private final LinkedHashMap<Tree, TreePath> nodes;

  public ScipVisitor(
      GlobalSymbolsCache globals,
      CompilationUnitTree compUnitTree,
      SemanticdbJavacOptions options,
      Types types,
      Trees trees,
      Elements elements) {
    this.globals = globals;
    this.locals = new LocalSymbolsCache();
    this.options = options;
    this.types = types;
    this.elements = elements;
    this.trees = trees;
    this.compUnitTree = compUnitTree;
    this.occurrences = new ArrayList<>();
    this.symbols = new LinkedHashMap<>();
    this.source = sourceText(compUnitTree);
    this.relativePath = sourceRelativePath(compUnitTree, options);
    this.nodes = new LinkedHashMap<>();
  }

  /** Builds a single-document {@link Scip.Index} shard for the given compilation unit. */
  public Scip.Index buildShard(CompilationUnitTree tree) {
    this.scan(tree, null);
    resolveNodes();

    Scip.Document.Builder document =
        Scip.Document.newBuilder()
            .setRelativePath(relativePath)
            .setLanguage(LANGUAGE_JAVA);
    if (options.includeText) {
      document.setText(source);
    }
    document.addAllOccurrences(ScipOccurrences.deduplicate(occurrences));
    document.addAllSymbols(symbols.values());

    return Scip.Index.newBuilder().addDocuments(document).build();
  }

  /**
   * SCIP `Document.language` value. Lowercased to match the canonical scheme used by other
   * tooling (see {@link com.sourcegraph.scip_semanticdb.ScipSemanticdb}).
   */
  static final String LANGUAGE_JAVA = "java";

  // ==========================
  // Symbol/occurrence emission
  // ==========================

  private Optional<Semanticdb.Range> emitSymbolOccurrence(
      Element sym, Tree tree, Name name, Role role, CompilerRange kind) {
    if (sym == null || name == null) return Optional.empty();
    Optional<Semanticdb.Range> range = semanticdbRange(tree, kind, sym, name.toString());
    if (role == Role.DEFINITION) {
      emitOccurrence(sym, range, role, computeEnclosingRange(tree));
      emitSymbolInformation(sym, tree);
      return range;
    }
    emitOccurrence(sym, range, role, Optional.empty());
    return range;
  }

  private void emitOccurrence(
      Element sym,
      Optional<Semanticdb.Range> range,
      Role role,
      Optional<Semanticdb.Range> enclosingRange) {
    if (sym == null || !range.isPresent()) return;
    String semanticdbSymbol = semanticdbSymbol(sym);
    if (semanticdbSymbol.equals(SemanticdbSymbols.NONE)) return;

    Scip.Occurrence.Builder occ =
        Scip.Occurrence.newBuilder()
            .addAllRange(scipRange(range.get()))
            .setSymbol(ScipSymbols.fromSemanticdbSymbol(semanticdbSymbol))
            .setSymbolRoles(scipRole(role));
    enclosingRange.ifPresent(r -> occ.addAllEnclosingRange(scipRange(r)));
    occurrences.add(occ.build());
  }

  private void emitSymbolInformation(Element sym, Tree tree) {
    String semanticdbSymbol = semanticdbSymbol(sym);
    if (semanticdbSymbol.equals(SemanticdbSymbols.NONE)) return;

    Scip.SymbolInformation.Builder builder =
        Scip.SymbolInformation.newBuilder()
            .setSymbol(ScipSymbols.fromSemanticdbSymbol(semanticdbSymbol))
            .setDisplayName(sym.getSimpleName().toString())
            .setKind(scipKind(sym));

    if (SemanticdbSymbols.isLocal(semanticdbSymbol)) {
      String enclosingSymbol = semanticdbSymbol(sym.getEnclosingElement());
      if (enclosingSymbol != null && !enclosingSymbol.equals(SemanticdbSymbols.NONE)) {
        builder.setEnclosingSymbol(ScipSymbols.fromSemanticdbSymbol(enclosingSymbol));
      }
    }

    String documentation = semanticdbDocumentation(tree);
    if (documentation != null && !documentation.isEmpty()) {
      builder.addDocumentation(documentation);
    }

    String signature = new ScipSignatureFormatter(sym).formatSymbol();
    if (!signature.isEmpty()) {
      builder.setSignatureDocumentation(
          Scip.Document.newBuilder()
              .setLanguage(LANGUAGE_JAVA)
              .setRelativePath(relativePath)
              .setText(signature));
    }

    boolean supportsReferenceRel = supportsReferenceRelationship(sym);

    switch (sym.getKind()) {
      case ENUM:
      case CLASS:
      case INTERFACE:
      case ANNOTATION_TYPE:
        addParentRelationships(builder, (TypeElement) sym, supportsReferenceRel);
        break;
      case METHOD:
        for (String overridden :
            semanticdbOverrides(
                (ExecutableElement) sym, sym.getEnclosingElement(), new HashSet<>())) {
          if (isIgnoredOverriddenSymbol(overridden)) continue;
          builder.addRelationships(
              Scip.Relationship.newBuilder()
                  .setSymbol(ScipSymbols.fromSemanticdbSymbol(overridden))
                  .setIsImplementation(true)
                  .setIsReference(supportsReferenceRel));
        }
        break;
      case ENUM_CONSTANT:
        if (tree instanceof VariableTree && ((VariableTree) tree).getInitializer() != null) {
          String args =
              ((NewClassTree) ((VariableTree) tree).getInitializer())
                  .getArguments().stream()
                      .map(ExpressionTree::toString)
                      .collect(Collectors.joining(", "));
          if (!args.isEmpty()) {
            builder.setDisplayName(sym.getSimpleName().toString() + "(" + args + ")");
          }
        }
        break;
      default:
        break;
    }

    // Deduplicate by symbol; last write wins so newly discovered metadata takes precedence.
    symbols.put(builder.getSymbol(), builder.build());
  }

  private void addParentRelationships(
      Scip.SymbolInformation.Builder builder, TypeElement sym, boolean supportsReferenceRel) {
    for (String parent : semanticdbParentSymbols(sym)) {
      if (isIgnoredOverriddenSymbol(parent)) continue;
      builder.addRelationships(
          Scip.Relationship.newBuilder()
              .setSymbol(ScipSymbols.fromSemanticdbSymbol(parent))
              .setIsImplementation(true)
              .setIsReference(supportsReferenceRel));
    }
  }

  private static boolean isIgnoredOverriddenSymbol(String symbol) {
    return symbol.equals("java/lang/Object#");
  }

  private static boolean supportsReferenceRelationship(Element sym) {
    switch (sym.getKind()) {
      case INTERFACE:
      case CLASS:
      case ANNOTATION_TYPE:
      case ENUM:
        return false;
      default:
        return true;
    }
  }

  // =================================================
  // Range / role / kind translation between SemanticDB and SCIP.
  // =================================================

  private static int scipRole(Role role) {
    if (role == Role.DEFINITION || role == Role.SYNTHETIC_DEFINITION) {
      return Scip.SymbolRole.Definition_VALUE;
    }
    return 0;
  }

  private static List<Integer> scipRange(Semanticdb.Range range) {
    if (range.getStartLine() == range.getEndLine()) {
      return Arrays.asList(
          range.getStartLine(), range.getStartCharacter(), range.getEndCharacter());
    }
    return Arrays.asList(
        range.getStartLine(),
        range.getStartCharacter(),
        range.getEndLine(),
        range.getEndCharacter());
  }

  private static Scip.SymbolInformation.Kind scipKind(Element sym) {
    Set<Modifier> modifiers = sym.getModifiers();
    boolean isStatic = modifiers.contains(Modifier.STATIC);
    // A `default` interface method has both ABSTRACT and DEFAULT modifiers; treat it as non-abstract.
    boolean isAbstract =
        modifiers.contains(Modifier.ABSTRACT) && !modifiers.contains(Modifier.DEFAULT);

    switch (sym.getKind()) {
      case ENUM:
        return Scip.SymbolInformation.Kind.Enum;
      case ENUM_CONSTANT:
        return Scip.SymbolInformation.Kind.EnumMember;
      case CLASS:
        return Scip.SymbolInformation.Kind.Class;
      case INTERFACE:
      case ANNOTATION_TYPE:
        return Scip.SymbolInformation.Kind.Interface;
      case FIELD:
        return isStatic
            ? Scip.SymbolInformation.Kind.StaticField
            : Scip.SymbolInformation.Kind.Field;
      case CONSTRUCTOR:
        return Scip.SymbolInformation.Kind.Constructor;
      case METHOD:
        if (isStatic) return Scip.SymbolInformation.Kind.StaticMethod;
        if (isAbstract) return Scip.SymbolInformation.Kind.AbstractMethod;
        return Scip.SymbolInformation.Kind.Method;
      case TYPE_PARAMETER:
        return Scip.SymbolInformation.Kind.TypeParameter;
      case LOCAL_VARIABLE:
      case EXCEPTION_PARAMETER:
      case RESOURCE_VARIABLE:
        return Scip.SymbolInformation.Kind.Variable;
      case PARAMETER:
        return Scip.SymbolInformation.Kind.Parameter;
      case PACKAGE:
        return Scip.SymbolInformation.Kind.Package;
      default:
        return Scip.SymbolInformation.Kind.UnspecifiedKind;
    }
  }

  // ===========================================
  // Node resolution and traversal (unchanged from SemanticdbVisitor)
  // ===========================================

  void resolveNodes() {
    HashSet<Tree> ignoreNodes = new HashSet<>();
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
      if (!ignoreNodes.contains(node)) {
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
  }

  @Override
  public Void scan(Tree tree, Void unused) {
    if (tree != null) {
      TreePath path = new TreePath(getCurrentPath(), tree);
      nodes.put(tree, path);
    }
    return super.scan(tree, unused);
  }

  private boolean isAnonymous(Element sym) {
    return sym.getSimpleName().length() == 0;
  }

  private void resolveClassTree(ClassTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null && sym.getSimpleName().length() > 0) {
      emitSymbolOccurrence(
          sym,
          node,
          sym.getSimpleName(),
          Role.DEFINITION,
          CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
    }
  }

  private void resolveTypeParameterTree(TypeParameterTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null && sym.getSimpleName().length() > 0) {
      emitSymbolOccurrence(
          sym, node, sym.getSimpleName(), Role.DEFINITION, CompilerRange.FROM_POINT_TO_SYMBOL_NAME);
    }
  }

  private void resolveMethodTree(MethodTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null) {
      Element enclosingElement = sym.getEnclosingElement();
      if (sym.getKind() != ElementKind.CONSTRUCTOR || !isAnonymous(enclosingElement)) {
        Name name;
        if (sym.getKind() == ElementKind.CONSTRUCTOR) name = enclosingElement.getSimpleName();
        else name = sym.getSimpleName();

        emitSymbolOccurrence(
            sym, node, name, Role.DEFINITION, CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
      }
    }
  }

  private void resolveVariableTree(VariableTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null) {
      Optional<Semanticdb.Range> range =
          emitSymbolOccurrence(
              sym,
              node,
              sym.getSimpleName(),
              Role.DEFINITION,
              CompilerRange.FROM_POINT_WITH_TEXT_SEARCH);
      if (sym.getKind() == ElementKind.ENUM_CONSTANT) {
        TreePath typeTreePath = nodes.get(node.getInitializer());
        Element typeSym = trees.getElement(typeTreePath);
        if (typeSym != null) emitOccurrence(typeSym, range, Role.REFERENCE, Optional.empty());
      }
    }
  }

  private void resolveIdentifierTree(IdentifierTree node, TreePath treePath) {
    Name nodeName = node.getName();
    if (nodeName != null) {
      Element sym = trees.getElement(treePath);
      if (sym != null) {
        boolean isThis = nodeName.toString().equals("this");
        boolean isSuper = !isThis && nodeName.toString().equals("super");
        if (((sym.getKind() == ElementKind.CONSTRUCTOR) == isThis) || (isSuper)) {
          TreePath parentPath = treePath.getParentPath();
          Element parentSym = trees.getElement(parentPath);
          if (parentSym == null || parentSym.getKind() != null) {
            emitSymbolOccurrence(
                sym, node, sym.getSimpleName(), Role.REFERENCE, CompilerRange.FROM_START_TO_END);
          }
        }
      }
    }
  }

  private void resolveMemberReferenceTree(MemberReferenceTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null) {
      emitSymbolOccurrence(
          sym, node, sym.getSimpleName(), Role.REFERENCE, CompilerRange.FROM_END_TO_SYMBOL_NAME);
    }
  }

  private void resolveMemberSelectTree(MemberSelectTree node, TreePath treePath) {
    Element sym = trees.getElement(treePath);
    if (sym != null) {
      emitSymbolOccurrence(
          sym, node, sym.getSimpleName(), Role.REFERENCE, CompilerRange.FROM_END_TO_SYMBOL_NAME);
    }
  }

  private void resolveNewClassTree(NewClassTree node, TreePath treePath) {
    if (node.getIdentifier() != null && node.getClassBody() == null) {
      Element sym = trees.getElement(treePath);
      if (sym != null) {
        TreePath parentPath = treePath.getParentPath();
        Element parentSym = trees.getElement(parentPath);
        if (parentSym == null || parentSym.getKind() != ElementKind.ENUM_CONSTANT) {
          TreePath identifierTreePath = nodes.get(node.getIdentifier());
          Element identifierSym = trees.getElement(identifierTreePath);
          if (identifierSym != null) {
            emitSymbolOccurrence(
                sym,
                node,
                identifierSym.getSimpleName(),
                Role.REFERENCE,
                CompilerRange.FROM_TEXT_SEARCH);
          } else if (node.getIdentifier().getKind() == Tree.Kind.ANNOTATED_TYPE) {
            AnnotatedTypeTree annotatedTypeTree = (AnnotatedTypeTree) node.getIdentifier();
            if (annotatedTypeTree.getUnderlyingType() != null
                && annotatedTypeTree.getUnderlyingType().getKind() == Tree.Kind.IDENTIFIER) {
              IdentifierTree ident = (IdentifierTree) annotatedTypeTree.getUnderlyingType();
              emitSymbolOccurrence(
                  sym, ident, ident.getName(), Role.REFERENCE, CompilerRange.FROM_TEXT_SEARCH);
            }
          }
        }
      }
    }
  }

  // =================================================
  // Helpers shared with SemanticdbVisitor (range / symbol / parent overrides).
  // =================================================

  private String semanticdbSymbol(Element sym) {
    return globals.semanticdbSymbol(sym, locals);
  }

  private Optional<Semanticdb.Range> semanticdbRange(
      Tree tree, CompilerRange kind, Element sym, String name) {
    if (sym == null) return Optional.empty();

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
          if (source.length() > testEnd && source.substring(start, testEnd).equals(name)) {
            end = testEnd;
          }
        }
      } else if (kind.isFromEndPoint()) {
        if (end != Diagnostic.NOPOS) {
          int testStart = end - name.length();
          if (testStart >= 0
              && source.length() > end
              && source.substring(testStart, end).equals(name)) {
            start = testStart;
          }
        }
      }
    }

    if (start != Diagnostic.NOPOS && end != Diagnostic.NOPOS && end > start) {
      LineMap lineMap = compUnitTree.getLineMap();
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

  private Optional<Semanticdb.Range> computeEnclosingRange(Tree tree) {
    if (tree == null) return Optional.empty();
    TreePath path = nodes.get(tree);
    if (path == null) return Optional.empty();

    Tree enclosingTree = tree;
    if (!(tree instanceof MethodTree
        || tree instanceof ClassTree
        || tree instanceof VariableTree)) {
      TreePath parentPath = path.getParentPath();
      if (parentPath == null) return Optional.empty();
      enclosingTree = parentPath.getLeaf();
      if (enclosingTree == null || enclosingTree == compUnitTree) return Optional.empty();
    }

    SourcePositions sourcePositions = trees.getSourcePositions();
    int start = (int) sourcePositions.getStartPosition(compUnitTree, enclosingTree);
    int end = (int) sourcePositions.getEndPosition(compUnitTree, enclosingTree);

    if (start != Diagnostic.NOPOS && end != Diagnostic.NOPOS && end > start) {
      LineMap lineMap = compUnitTree.getLineMap();
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

  private static String sourceText(CompilationUnitTree tree) {
    try {
      return tree.getSourceFile().getCharContent(true).toString();
    } catch (IOException e) {
      return "";
    }
  }

  private List<String> semanticdbParentSymbols(TypeElement typeElement) {
    ArrayList<String> parentSymbols = new ArrayList<>();
    Set<TypeElement> parentElements = semanticdbParentTypeElements(typeElement, new HashSet<>());
    for (TypeElement parentElement : parentElements) {
      String ssym = semanticdbSymbol(parentElement);
      if (!Objects.equals(ssym, SemanticdbSymbols.NONE)) {
        parentSymbols.add(ssym);
      }
    }
    return parentSymbols;
  }

  private Set<TypeElement> semanticdbParentTypeElements(
      TypeElement typeElement, Set<TypeElement> result) {
    TypeMirror superType = typeElement.getSuperclass();
    semanticdbParentSymbol(superType, result);
    for (TypeMirror interfaceType : typeElement.getInterfaces()) {
      semanticdbParentSymbol(interfaceType, result);
    }
    return result;
  }

  private void semanticdbParentSymbol(TypeMirror elementType, Set<TypeElement> result) {
    if (!(elementType instanceof NoType)) {
      Element superElement = types.asElement(elementType);
      if (superElement instanceof TypeElement) {
        result.add((TypeElement) superElement);
        semanticdbParentTypeElements((TypeElement) superElement, result);
      }
    }
  }

  private Set<String> semanticdbOverrides(
      ExecutableElement sym, Element enclosingElement, HashSet<String> overriddenSymbols) {
    if (enclosingElement instanceof TypeElement) {
      List<? extends TypeMirror> superTypes = types.directSupertypes(enclosingElement.asType());
      for (TypeMirror superType : superTypes) {
        if (superType instanceof DeclaredType) {
          Element superElement = ((DeclaredType) superType).asElement();
          if (superElement instanceof TypeElement) {
            boolean methodFound = false;
            List<? extends Element> enclosedElements =
                ((TypeElement) superElement).getEnclosedElements();
            for (Element enclosedElement : enclosedElements) {
              if (enclosedElement instanceof ExecutableElement) {
                ExecutableElement enclosedExecutableElement = (ExecutableElement) enclosedElement;
                if (elements.overrides(
                    sym, enclosedExecutableElement, (TypeElement) sym.getEnclosingElement())) {
                  String symbol = semanticdbSymbol(enclosedExecutableElement);
                  overriddenSymbols.add(symbol);
                  methodFound = true;
                  semanticdbOverrides(enclosedExecutableElement, superElement, overriddenSymbols);
                }
              }
            }
            if (!methodFound) {
              semanticdbOverrides(sym, superElement, overriddenSymbols);
            }
          }
        }
      }
    }
    return overriddenSymbols;
  }

  private static String sourceRelativePath(
      CompilationUnitTree compUnitTree, SemanticdbJavacOptions options) {
    Path absolutePath =
        SemanticdbTaskListener.absolutePathFromUri(options, compUnitTree.getSourceFile());
    Path uriPath =
        absolutePath.startsWith(options.sourceroot)
            ? options.sourceroot.relativize(absolutePath)
            : absolutePath;
    StringBuilder out = new StringBuilder();
    Iterator<Path> it = uriPath.iterator();
    if (it.hasNext()) out.append(it.next().getFileName().toString());
    while (it.hasNext()) {
      Path part = it.next();
      out.append('/').append(part.getFileName().toString());
    }
    return out.toString();
  }

  private String semanticdbDocumentation(Tree tree) {
    try {
      TreePath treePath = nodes.get(tree);
      String doc = trees.getDocComment(treePath);
      return doc;
    } catch (NullPointerException e) {
      return null;
    }
  }
}
