package lsifjava;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.MarkedString;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeMirror;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LanguageConstruct {

    private final Element element;

    private String docComment;

    private Location location;

    public LanguageConstruct(String fileName, Element element, TypeMirror typeMirror) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setDocComment(String docComment) {
        this.docComment = docComment;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class Signature {
        public ElementKind elementKind;
        public String simpleName;
        public String qualifiedName;
        public String outermostContainerName;
        public String packageName;

        public static Signature of(ElementKind elementKind, String simpleName, String qualifiedName, String outermostContainerName, String packageName) {
            return new Signature(elementKind, simpleName, qualifiedName, outermostContainerName, packageName);
        }

        private Signature(ElementKind elementKind, String simpleName, String qualifiedName, String outermostContainerName, String packageName) {
            this.elementKind = elementKind;
            this.simpleName = simpleName;
            this.qualifiedName = qualifiedName;
            this.outermostContainerName = outermostContainerName;
            this.packageName = packageName;
        }

        @Override
        public String toString() {
            return String.join(
                    ":",
                    elementKind.toString(),
                    qualifiedName
            );
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            Signature signature = (Signature) object;

            if (elementKind != signature.elementKind) return false;
            if (!Objects.equals(simpleName, signature.simpleName))
                return false;
            if (!Objects.equals(qualifiedName, signature.qualifiedName))
                return false;
            if (!Objects.equals(packageName, signature.packageName))
                return false;
            return Objects.equals(outermostContainerName, signature.outermostContainerName);
        }

        @Override
        public int hashCode() {
            int result = elementKind != null ? elementKind.hashCode() : 0;
            result = 31 * result + (simpleName != null ? simpleName.hashCode() : 0);
            result = 31 * result + (qualifiedName != null ? qualifiedName.hashCode() : 0);
            result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
            result = 31 * result + (outermostContainerName != null ? outermostContainerName.hashCode() : 0);
            return result;
        }
    }
}
