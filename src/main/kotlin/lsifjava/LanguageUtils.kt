package lsifjava

import javax.lang.model.element.*

fun getTopLevelClass(element: Element?): Element? {
    var element = element
    var highestClass: Element? = null
    while (element != null) {
        val kind = element.kind
        if (isTopLevel(kind)) {
            highestClass = element
        }
        element = element.enclosingElement
    }
    return highestClass
}

fun isTopLevel(kind: ElementKind): Boolean {
    return kind.isClass || kind.isInterface
}
