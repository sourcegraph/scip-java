@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
package lsifjava

import com.sun.tools.javac.tree.JCTree.*

fun JCMethodDecl.stringify(): String {
    val methodName = this.methodName()
    val returnType = this.returnType?.toString()?.plus(" ") ?: ""
    
    return this.modifiers.toString() +
        returnType +
        methodName + "(" +
        this.parameters.toString(", ") + ")"
}

fun JCMethodDecl.methodName() = this.name.toString().let {
    if(it == "<init>") this.sym.owner.name.toString() else it
}