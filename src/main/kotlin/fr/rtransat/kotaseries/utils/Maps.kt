package fr.rtransat.kotaseries.utils

fun <K, V> mapOfNotNullValues(vararg entries: Pair<K, V>) = buildMap {
    entries.forEach { (k, v) ->
        if (v != null) {
            this[k] = v.toString()
        }
    }
}
