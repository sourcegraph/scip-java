package lsifjava;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;

public class IndexingVisitor extends TreePathScanner<Void, Void> {
    private final Trees trees;
    private final CompilationUnitTree compUnit;
    private final Map<Path, DocumentIndexer> indexers;
    private final DocumentIndexer currentIndexer;
    
    public IndexingVisitor(
            JavacTask task,
            CompilationUnitTree compUnit,
            DocumentIndexer indexer,
            Map<Path, DocumentIndexer> indexers) {
        this.trees = Trees.instance(task);
        this.compUnit = compUnit;
        this.indexers = indexers;
        this.currentIndexer = indexer;
    }

    @Override
    public Void visitMethod(MethodTree node, Void p) {
        // synthetic constructors still exist in the AST, ignore it.
        // TODO(noahsc) point to class decl?
        if((((JCTree.JCMethodDecl)node).mods.flags & Flags.GENERATEDCONSTR) != 0L) {
            return null;
        }

        var methodName = node.getName().toString();
        if(methodName.equals("<init>")) {
            methodName = ((JCTree.JCMethodDecl) node).sym.owner.name.toString();
        }

        var returnType = "";
        if(node.getReturnType() != null) {
            returnType = node.getReturnType().toString() + " ";
        }

        var range = location(getCurrentPath(), methodName).getRange();
        currentIndexer.emitDefinition(
                range,
                node.getModifiers().toString() +
                        returnType +
                        methodName + "(" +
                        node.getParameters().toString() + ")"
        );

        return super.visitMethod(node, p);
    }

    @Override
    public Void visitClass(ClassTree node, Void p) {
        var packagePrefix = "";
        if (compUnit.getPackageName() != null) {
            packagePrefix = compUnit.getPackageName() + ".";
        }
        
        var classOrEnum = "class ";
        if((((JCTree.JCClassDecl) node).sym.flags() & Flags.ENUM) > 0L) {
            classOrEnum = "enum ";
        }

        // gets the range of the def ident
        var range = location(getCurrentPath(), node.getSimpleName().toString()).getRange();
        currentIndexer.emitDefinition(
                range,
                node.getModifiers().toString() + classOrEnum + packagePrefix + node.getSimpleName()
        );

        return super.visitClass(node, p);
    }

    @Override
    public Void visitVariable(VariableTree node, Void p) {
        // emit def for var
        var defRange = location(getCurrentPath(), node.getName().toString()).getRange();

        currentIndexer.emitDefinition(defRange, node.toString());

        // emit use for type
        // TODO(noahsc): handle generic types...and more types/symbols
        var name = "";
        Range refRange = null;
        Range useRange = null;
        Path defPath = null;
        if(((JCTree.JCVariableDecl) node).type instanceof Type.ClassType type) {
            if(type.tsym instanceof Symbol.ClassSymbol clazz) {
                name = clazz.name.toString();
                var identPath = new TreePath(
                        getCurrentPath(), node.getType()
                );
                var identElement = trees.getElement(identPath);

                var defContainer = LanguageUtils.getTopLevelClass(identElement);
                if(defContainer == null) return super.visitVariable(node, p);

                var sourceFile = ((Symbol.ClassSymbol)defContainer).sourcefile;
                if(sourceFile != null && !sourceFile.getName().equals(compUnit.getSourceFile().getName())) {
                    // if cross-file, index the file so definitions are populated
                    if(!indexers.containsKey(Paths.get(sourceFile.getName()))) return super.visitVariable(node, p);
                    try {
                        indexers.get(Paths.get(sourceFile.getName())).index();
                    } catch (IOException e) {
                        return super.visitVariable(node, p);
                    }
                    var location = findDefinition(defContainer);
                    if(location == null) return super.visitVariable(node, p);
                    refRange = location.getRange();
                    defPath = Paths.get(location.getUri());
                } else {
                    // if same file
                    var location = findDefinition(defContainer);
                    if(location == null) return super.visitVariable(node, p);
                    refRange = location.getRange();
                    defPath = Paths.get(compUnit.getSourceFile().toUri());
                }

                var location = location(identPath, name);
                if(location == null) return super.visitVariable(node, p);
                useRange = location.getRange();
            }
        }

        if(refRange == null || useRange == null) return super.visitVariable(node, p);

        currentIndexer.emitUse(useRange, refRange, defPath);


        return super.visitVariable(node, p);
    }

    @Override
    public Void visitMethodInvocation(MethodInvocationTree node, Void unused) {

        return super.visitMethodInvocation(node, unused);
    }

    @Override
    public Void visitTypeParameter(TypeParameterTree node, Void unused) {
        return super.visitTypeParameter(node, unused);
    }

    @Override
    public Void visitNewClass(NewClassTree node, Void p) {
        JCTree.JCIdent ident;
        if (node.getIdentifier() instanceof JCTree.JCIdent id) {
            ident = id;
        } else if (node.getIdentifier() instanceof JCTree.JCTypeApply apply) {
            ident = (JCTree.JCIdent)apply.clazz;
        } else {
            System.out.println("identifier was neither JCIdent nor JCTypeApply");
            return super.visitNewClass(node, p);
        }
        var identPath = new TreePath(getCurrentPath(), node.getIdentifier());
        var identElement =  ((JCTree.JCNewClass)node).constructor;

            /*var defContainer = LanguageUtils.getTopLevelClass(identElement);
            if(defContainer == null) return super.visitNewClass(node, p);*/

        var range = location(identPath, ident.name.toString()).getRange();

        // first search for constructor
        var location = findDefinition(identElement);
        if(location == null) {
            // fallback to class def
            location = findDefinition(trees.getElement(identPath));
            if(location == null) return super.visitNewClass(node, p);
        }

        currentIndexer.emitUse(
                range,
                location.getRange(),
                Paths.get(getCurrentPath().getCompilationUnit().getSourceFile().toUri())
        );

        return super.visitNewClass(node, p);
    }

    // from https://github.com/georgewfraser/java-language-server/blob/3555762fa35ab99575130911b3c930cc4d2d7b26/src/main/java/org/javacs/FindHelper.java
    private Location findDefinition(Element element) {
        var path = trees.getPath(element);
        if (path == null) return null;
        var name = element.getSimpleName();
        if (name.contentEquals("<init>")) name = element.getEnclosingElement().getSimpleName();
        return location(path, name);
    }

    public Location location(TreePath path, CharSequence name) {
        var lines = path.getCompilationUnit().getLineMap();
        var pos = trees.getSourcePositions();
        var start = (int) pos.getStartPosition(path.getCompilationUnit(), path.getLeaf());
        var end = (int) pos.getEndPosition(path.getCompilationUnit(), path.getLeaf());
        if(end == -1) return null;
        if(name.length() > 0) {
            start = findNameIn(path.getCompilationUnit(), name, start, end);
            end = start + name.length();
        }
        var startLine = (int) lines.getLineNumber(start);
        var startColumn = (int) lines.getColumnNumber(start);
        var startPos = new Position(startLine - 1, startColumn - 1);
        var endLine = (int) lines.getLineNumber(end);
        var endColumn = (int) lines.getColumnNumber(end);
        var endPos = new Position(endLine - 1, endColumn - 1);
        var range = new Range(startPos, endPos);
        var uri = path.getCompilationUnit().getSourceFile().toUri();
        return new Location(uri.getPath(), range);
    }

    public int findNameIn(CompilationUnitTree root, CharSequence name, int start, int end) {
        CharSequence contents;
        try {
            contents = root.getSourceFile().getCharContent(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var matcher = Pattern.compile("\\b" + name + "\\b").matcher(contents);
        matcher.region(start, end);
        if (matcher.find()) {
            return matcher.start();
        }
        return -1;
    }
}
