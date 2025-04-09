package com.sourcegraph.semanticdb_kotlinc

@JvmInline
value class Symbol(private val symbol: String) {
    companion object {
        val NONE = Symbol("")
        val ROOT_PACKAGE = Symbol("_root_/")
        val EMPTY_PACKAGE = Symbol("_empty_/")

        fun createGlobal(owner: Symbol, desc: SemanticdbSymbolDescriptor): Symbol =
            when {
                desc == SemanticdbSymbolDescriptor.NONE -> NONE
                owner != ROOT_PACKAGE -> Symbol(owner.symbol + desc.encode().symbol)
                else -> desc.encode()
            }

        fun createLocal(i: Int) = Symbol("local$i")
    }

    fun isGlobal() = !isLocal()

    fun isLocal() = symbol.startsWith("local")

    override fun toString(): String = symbol
}

fun String.symbol(): Symbol = Symbol(this)

data class SemanticdbSymbolDescriptor(
    val kind: Kind,
    val name: String,
    val disambiguator: String = "()"
) {
    companion object {
        val NONE = SemanticdbSymbolDescriptor(Kind.NONE, "")

        private fun encodeName(name: String): String {
            if (name.isEmpty()) return "``"
            val isStartOk = Character.isJavaIdentifierStart(name[0])
            var isPartsOk = true
            var i = 1
            while (isPartsOk && i < name.length) {
                isPartsOk = Character.isJavaIdentifierPart(name[i])
                i++
            }
            return if (isStartOk && isPartsOk) name else "`$name`"
        }
    }

    enum class Kind {
        NONE,
        TERM,
        METHOD,
        TYPE,
        PACKAGE,
        PARAMETER,
        TYPE_PARAMETER
    }

    fun encode() =
        Symbol(
            when (kind) {
                Kind.NONE -> ""
                Kind.TERM -> "${encodeName(name)}."
                Kind.METHOD -> "${encodeName(name)}${disambiguator}."
                Kind.TYPE -> "${encodeName(name)}#"
                Kind.PACKAGE -> "${encodeName(name)}/"
                Kind.PARAMETER -> "(${encodeName(name)})"
                Kind.TYPE_PARAMETER -> "[${encodeName(name)}]"
            })
}
