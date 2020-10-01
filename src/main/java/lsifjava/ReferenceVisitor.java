package lsifjava;

import com.sun.source.tree.*;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreeScanner;
import com.sun.source.util.Trees;
import org.apache.commons.lang3.tuple.Pair;

import javax.lang.model.element.Element;

import java.util.Collection;
import java.util.List;

public class ReferenceVisitor extends TreeScanner<LanguageConstruct, Void> {
    private final Trees trees;

    private final CompilationUnitTree compilationUnit;

    private final PositionCalculator positionCalculator;

    private final SourcePositions sourcePositions;

    private final long offset;

    public ReferenceVisitor(Trees trees, CompilationUnitTree compilationUnit, long position) {
        this.trees = trees;
        this.compilationUnit = compilationUnit;
        this.sourcePositions = trees.getSourcePositions();
        this.positionCalculator = new PositionCalculator(sourcePositions, compilationUnit);
        //this.offset = PositionCalculator.positionToOffset(getSourceFileContent(compilationUnit.getSourceFile()), position);
        this.offset = position;
    }

    @Override
    public LanguageConstruct visitAnnotatedType(AnnotatedTypeTree annotatedTypeTree, Void aVoid) {
        return firstNonNull(
                search(annotatedTypeTree.getAnnotations()),
                search(annotatedTypeTree.getUnderlyingType())
        );
    }

    @Override
    public LanguageConstruct visitAnnotation(AnnotationTree annotationTree, Void aVoid) {

        // alexsaveliev: end position of Nth annotation argument may return -1
        // because compiler can transform @foo(bar) into @foo(value=bar) shifting offsets
        // bar location, however, points to proper location so we will ignore range check for
        // annotation arguments and rely on argument's children position
        List<? extends Tree> args = annotationTree.getArguments();
        if (args != null) {
            for (Tree tree : args) {
                LanguageConstruct data = tree.accept(this, null);
                if (data != null) {
                    return data;
                }
            }
        }

        return firstNonNull(
                search(annotationTree.getAnnotationType()),
                getHoverData(annotationTree)
        );
    }

    @Override
    public LanguageConstruct visitMethodInvocation(MethodInvocationTree methodInvocationTree, Void aVoid) {
        return firstNonNull(
                search(methodInvocationTree.getTypeArguments()),
                search(methodInvocationTree.getMethodSelect()),
                search(methodInvocationTree.getArguments()),
                getHoverData(methodInvocationTree)
        );
    }

    @Override
    public LanguageConstruct visitAssert(AssertTree assertTree, Void aVoid) {
        return firstNonNull(
                search(assertTree.getCondition()),
                search(assertTree.getDetail())
        );
    }

    @Override
    public LanguageConstruct visitAssignment(AssignmentTree assignmentTree, Void aVoid) {
        return firstNonNull(
                search(assignmentTree.getVariable()),
                search(assignmentTree.getExpression())
        );
    }

    @Override
    public LanguageConstruct visitCompoundAssignment(CompoundAssignmentTree compoundAssignmentTree, Void aVoid) {
        return firstNonNull(
                search(compoundAssignmentTree.getVariable()),
                search(compoundAssignmentTree.getExpression())
        );
    }

    @Override
    public LanguageConstruct visitBinary(BinaryTree binaryTree, Void aVoid) {
        return firstNonNull(
                search(binaryTree.getLeftOperand()),
                search(binaryTree.getRightOperand())
        );
    }

    @Override
    public LanguageConstruct visitBlock(BlockTree blockTree, Void aVoid) {
        return search(blockTree.getStatements());
    }

    @Override
    public LanguageConstruct visitBreak(BreakTree breakTree, Void aVoid) {
        return null;
    }

    @Override
    public LanguageConstruct visitCase(CaseTree caseTree, Void aVoid) {
        return firstNonNull(
                search(caseTree.getExpressions()),
                search(caseTree.getStatements())
        );
    }

    @Override
    public LanguageConstruct visitCatch(CatchTree catchTree, Void aVoid) {
        return firstNonNull(
                search(catchTree.getParameter()),
                search(catchTree.getBlock())
        );
    }

    @Override
    public LanguageConstruct visitClass(ClassTree classTree, Void aVoid) {
        if (inside(positionCalculator.getBoundingBox(classTree))) return getHoverData(classTree);
        return firstNonNull(
                search(classTree.getModifiers()),
                search(classTree.getTypeParameters()),
                search(classTree.getExtendsClause()),
                search(classTree.getImplementsClause()),
                search(classTree.getMembers())
        );
    }

    @Override
    public LanguageConstruct visitConditionalExpression(ConditionalExpressionTree conditionalExpressionTree, Void aVoid) {
        return firstNonNull(
                search(conditionalExpressionTree.getCondition()),
                search(conditionalExpressionTree.getTrueExpression()),
                search(conditionalExpressionTree.getFalseExpression())
        );
    }

    @Override
    public LanguageConstruct visitContinue(ContinueTree continueTree, Void aVoid) {
        return null;
    }

    @Override
    public LanguageConstruct visitDoWhileLoop(DoWhileLoopTree doWhileLoopTree, Void aVoid) {
        return firstNonNull(
                search(doWhileLoopTree.getCondition()),
                search(doWhileLoopTree.getStatement())
        );
    }

    @Override
    public LanguageConstruct visitErroneous(ErroneousTree erroneousTree, Void aVoid) {
        return null;
    }

    @Override
    public LanguageConstruct visitExpressionStatement(ExpressionStatementTree expressionStatementTree, Void aVoid) {
        return search(expressionStatementTree.getExpression());
    }

    @Override
    public LanguageConstruct visitEnhancedForLoop(EnhancedForLoopTree enhancedForLoopTree, Void aVoid) {
        return firstNonNull(
                search(enhancedForLoopTree.getVariable()),
                search(enhancedForLoopTree.getExpression()),
                search(enhancedForLoopTree.getStatement())
        );
    }

    @Override
    public LanguageConstruct visitForLoop(ForLoopTree forLoopTree, Void aVoid) {
        return firstNonNull(
                search(forLoopTree.getInitializer()),
                search(forLoopTree.getCondition()),
                search(forLoopTree.getUpdate()),
                search(forLoopTree.getStatement())
        );
    }

    @Override
    public LanguageConstruct visitIdentifier(IdentifierTree identifierTree, Void aVoid) {
        return getHoverData(identifierTree);
    }

    @Override
    public LanguageConstruct visitIf(IfTree ifTree, Void aVoid) {
        return firstNonNull(
                search(ifTree.getCondition()),
                search(ifTree.getThenStatement()),
                search(ifTree.getElseStatement())
        );
    }

    @Override
    public LanguageConstruct visitImport(ImportTree importTree, Void aVoid) {
        LanguageConstruct ret = firstNonNull(
                search(importTree.getQualifiedIdentifier()),
                getHoverData(importTree));
        if (ret != null) {
            return ret;
        }
        if (importTree.isStatic()) {
            return staticImportData(importTree);
        }
        return null;
    }

    private LanguageConstruct staticImportData(ImportTree importTree) {
        Tree ident = importTree.getQualifiedIdentifier();
        if (!contains(ident, offset)) {
            return null;
        }
        if (!(ident instanceof MemberSelectTree mst)) {
            return null;
        }
        if ("*".equals(mst.getIdentifier().toString())) {
            return null;
        }
        TreePath path = trees.getPath(compilationUnit, mst.getExpression());
        if (path == null) {
            return null;
        }
        Element element = trees.getElement(path);
        if (element == null) {
            return null;
        }
        Collection<? extends Element> elements = element.getEnclosedElements();
        if (elements == null) {
            return null;
        }
        for (Element candidate: elements) {
            if (candidate.getSimpleName().equals(mst.getIdentifier())) {
                LanguageConstruct ret = new LanguageConstruct(compilationUnit.getSourceFile().getName(), candidate, candidate.asType());
                ret.setLocation(positionCalculator.getLocation(ident));
                path = trees.getPath(candidate);
                if (path != null) {
                    ret.setDocComment(trees.getDocComment(path));
                }
                return ret;
            }
        }
        return null;
    }

    @Override
    public LanguageConstruct visitArrayAccess(ArrayAccessTree arrayAccessTree, Void aVoid) {
        return firstNonNull(
                search(arrayAccessTree.getExpression()),
                search(arrayAccessTree.getIndex())
        );
    }

    @Override
    public LanguageConstruct visitLabeledStatement(LabeledStatementTree labeledStatementTree, Void aVoid) {
        return search(labeledStatementTree.getStatement());
    }

    @Override
    public LanguageConstruct visitLiteral(LiteralTree literalTree, Void aVoid) {
        return getHoverData(literalTree);
    }

    @Override
    public LanguageConstruct visitMethod(MethodTree methodTree, Void aVoid) {

        String name = methodTree.getName().toString();

        if ("<init>".equals(name)) {
            Element constructorElement = getElement(methodTree);
            if (constructorElement != null) {
                Element classElement = constructorElement.getEnclosingElement();
                if (classElement != null) {
                    String className = classElement.getSimpleName().toString();
                    if (inside(positionCalculator.getBoundingBox(methodTree, className))) {
                        return getHoverData(methodTree);
                    }
                }
            }
        } else if (inside(positionCalculator.getBoundingBox(methodTree))) {
            return getHoverData(methodTree);
        }

        return firstNonNull(
                search(methodTree.getModifiers()),
                search(methodTree.getReturnType()),
                search(methodTree.getParameters()),
                search(methodTree.getThrows()),
                search(methodTree.getBody()),
                search(methodTree.getDefaultValue())
        );
    }

    @Override
    public LanguageConstruct visitModifiers(ModifiersTree modifiersTree, Void aVoid) {
        return search(modifiersTree.getAnnotations());
    }

    @Override
    public LanguageConstruct visitNewArray(NewArrayTree newArrayTree, Void aVoid) {
        return firstNonNull(
                search(newArrayTree.getAnnotations()),
                search(newArrayTree.getType()),
                search(newArrayTree.getDimensions()),
                search(newArrayTree.getInitializers()),
                getHoverData(newArrayTree)
        );
    }

    @Override
    public LanguageConstruct visitNewClass(NewClassTree newClassTree, Void aVoid) {
        if (contains(newClassTree.getIdentifier(), offset)) {
            if (newClassTree.getClassBody() != null) {
                // it's an anonymous class so use the class element (which corresponds to the identifier) rather than
                // the constructor element (which corresponds to this whole tree)
                return getHoverData(newClassTree.getIdentifier());
            } else {
                return getHoverData(newClassTree);
            }
        }
        return firstNonNull(
                search(newClassTree.getTypeArguments()),
                search(newClassTree.getArguments()),
                search(newClassTree.getClassBody())
        );
    }

    @Override
    public LanguageConstruct visitLambdaExpression(LambdaExpressionTree lambdaExpressionTree, Void aVoid) {
        return firstNonNull(
                search(lambdaExpressionTree.getParameters()),
                search(lambdaExpressionTree.getBody())
        );
    }

    @Override
    public LanguageConstruct visitParenthesized(ParenthesizedTree parenthesizedTree, Void aVoid) {
        return search(parenthesizedTree.getExpression());
    }

    @Override
    public LanguageConstruct visitReturn(ReturnTree returnTree, Void aVoid) {
        return search(returnTree.getExpression());
    }

    @Override
    public LanguageConstruct visitMemberSelect(MemberSelectTree memberSelectTree, Void aVoid) {
        return firstNonNull(
                search(memberSelectTree.getExpression()),
                getHoverData(memberSelectTree)
        );
    }

    @Override
    public LanguageConstruct visitMemberReference(MemberReferenceTree memberReferenceTree, Void aVoid) {
        return firstNonNull(
                search(memberReferenceTree.getTypeArguments()),
                search(memberReferenceTree.getQualifierExpression()),
                getHoverData(memberReferenceTree)
        );
    }

    @Override
    public LanguageConstruct visitEmptyStatement(EmptyStatementTree emptyStatementTree, Void aVoid) {
        return null;
    }

    @Override
    public LanguageConstruct visitSwitch(SwitchTree switchTree, Void aVoid) {
        return firstNonNull(
                search(switchTree.getExpression()),
                search(switchTree.getCases())
        );
    }

    @Override
    public LanguageConstruct visitSynchronized(SynchronizedTree synchronizedTree, Void aVoid) {
        return firstNonNull(
                search(synchronizedTree.getExpression()),
                search(synchronizedTree.getBlock())
        );
    }

    @Override
    public LanguageConstruct visitThrow(ThrowTree throwTree, Void aVoid) {
        return search(throwTree.getExpression());
    }

    @Override
    public LanguageConstruct visitCompilationUnit(CompilationUnitTree compilationUnitTree, Void aVoid) {
        return firstNonNull(
                search(compilationUnitTree.getPackageName()),
                search(compilationUnitTree.getPackageAnnotations()),
                search(compilationUnitTree.getImports()),
                search(compilationUnitTree.getTypeDecls())
        );
    }

    @Override
    public LanguageConstruct visitTry(TryTree tryTree, Void aVoid) {
        return firstNonNull(
                search(tryTree.getBlock()),
                search(tryTree.getCatches()),
                search(tryTree.getFinallyBlock()),
                search(tryTree.getResources())
        );
    }

    @Override
    public LanguageConstruct visitParameterizedType(ParameterizedTypeTree parameterizedTypeTree, Void aVoid) {
        return firstNonNull(
                search(parameterizedTypeTree.getType()),
                search(parameterizedTypeTree.getTypeArguments())
        );
    }

    @Override
    public LanguageConstruct visitUnionType(UnionTypeTree unionTypeTree, Void aVoid) {
        return search(unionTypeTree.getTypeAlternatives());
    }

    @Override
    public LanguageConstruct visitIntersectionType(IntersectionTypeTree intersectionTypeTree, Void aVoid) {
        return search(intersectionTypeTree.getBounds());
    }

    @Override
    public LanguageConstruct visitArrayType(ArrayTypeTree arrayTypeTree, Void aVoid) {
        return firstNonNull(
                search(arrayTypeTree.getType()),
                getHoverData(arrayTypeTree)
        );
    }

    @Override
    public LanguageConstruct visitTypeCast(TypeCastTree typeCastTree, Void aVoid) {
        return firstNonNull(
                search(typeCastTree.getType()),
                search(typeCastTree.getExpression())
        );
    }

    @Override
    public LanguageConstruct visitPrimitiveType(PrimitiveTypeTree primitiveTypeTree, Void aVoid) {
        return getHoverData(primitiveTypeTree);
    }

    @Override
    public LanguageConstruct visitTypeParameter(TypeParameterTree typeParameterTree, Void aVoid) {
        return firstNonNull(
                search(typeParameterTree.getBounds()),
                search(typeParameterTree.getAnnotations()),
                getHoverData(typeParameterTree)
        );
    }

    @Override
    public LanguageConstruct visitInstanceOf(InstanceOfTree instanceOfTree, Void aVoid) {
        return firstNonNull(
                search(instanceOfTree.getExpression()),
                search(instanceOfTree.getType())
        );
    }

    @Override
    public LanguageConstruct visitUnary(UnaryTree unaryTree, Void aVoid) {
        return search(unaryTree.getExpression());
    }

    @Override
    public LanguageConstruct visitVariable(VariableTree variableTree, Void aVoid) {
        if (inside(positionCalculator.getBoundingBox(variableTree))) return getHoverData(variableTree);
        return firstNonNull(
                search(variableTree.getModifiers()),
                search(variableTree.getType()),
                search(variableTree.getNameExpression()),
                search(variableTree.getInitializer())
        );
    }

    @Override
    public LanguageConstruct visitWhileLoop(WhileLoopTree whileLoopTree, Void aVoid) {
        return firstNonNull(
                search(whileLoopTree.getCondition()),
                search(whileLoopTree.getStatement())
        );
    }

    @Override
    public LanguageConstruct visitWildcard(WildcardTree wildcardTree, Void aVoid) {
        return search(wildcardTree.getBound());
    }

    @Override
    public LanguageConstruct visitOther(Tree tree, Void aVoid) {
        return getHoverData(tree);
    }

    private LanguageConstruct search(Tree tree) {
        if (contains(tree, offset)) {
            return tree.accept(this, null);
        }
        return null;
    }

    private LanguageConstruct search(List<? extends Tree> treeList) {
        if (treeList != null) {
            for (Tree tree : treeList) {
                if (contains(tree, offset)) {
                    return tree.accept(this, null);
                }
            }
        }
        return null;
    }

    private boolean contains(Tree tree, long offset) {
        if (tree == null) return false;
        long startOffset = sourcePositions.getStartPosition(compilationUnit, tree);
        long endOffset = sourcePositions.getEndPosition(compilationUnit, tree);
        return startOffset <= offset && offset < endOffset;
    }

    private boolean inside(Pair<Integer, Integer> range) {
        return range.getLeft() <= offset && offset < range.getRight();
    }

    private LanguageConstruct firstNonNull(LanguageConstruct a, LanguageConstruct b) {
        return a != null
                ? a
                : b;
    }

    private LanguageConstruct firstNonNull(LanguageConstruct a, LanguageConstruct b, LanguageConstruct c) {
        return a != null
                ? a
                : firstNonNull(b, c);
    }

    private LanguageConstruct firstNonNull(LanguageConstruct a, LanguageConstruct b, LanguageConstruct c, LanguageConstruct d) {
        return a != null
                ? a
                : firstNonNull(b, c, d);
    }

    private LanguageConstruct firstNonNull(LanguageConstruct a, LanguageConstruct b, LanguageConstruct c, LanguageConstruct d, LanguageConstruct e) {
        return a != null
                ? a
                : firstNonNull(b, c, d, e);
    }

    private LanguageConstruct firstNonNull(LanguageConstruct a, LanguageConstruct b, LanguageConstruct c, LanguageConstruct d, LanguageConstruct e, LanguageConstruct f) {
        return a != null
                ? a
                : firstNonNull(b, c, d, e, f);
    }

    private LanguageConstruct getHoverData(Tree tree) {

        if (tree == null) return null;
        if (!contains(tree, offset)) return null;

        int sourceRange = positionCalculator.getJavaSourceRange(tree);
        TreePath path = trees.getPath(compilationUnit, tree);
        Element element = trees.getElement(path);
        if (element == null || sourceRange <= 0) return null;

        LanguageConstruct data = new LanguageConstruct(compilationUnit.getSourceFile().getName(), element, trees.getTypeMirror(path));
        data.setLocation(positionCalculator.getLocation(tree));
        data.setDocComment(trees.getDocComment(path));
        return data;
    }

    private Element getElement(Tree tree) {
        TreePath path = trees.getPath(compilationUnit, tree);
        if (path == null) return null;
        return trees.getElement(path);
    }
}
