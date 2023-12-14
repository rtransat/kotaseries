package fr.rtransat.kotaseries.exceptions

class ShowException(override val message: String?, val code: Int? = null) : RuntimeException(message) {
    override fun toString(): String = code?.let {
        "${super.toString()} - Code: $code"
    } ?: super.toString()
}
