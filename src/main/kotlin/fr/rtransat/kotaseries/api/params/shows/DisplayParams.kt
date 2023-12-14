package fr.rtransat.kotaseries.api.params.shows

import fr.rtransat.kotaseries.api.params.Params
import fr.rtransat.kotaseries.utils.mapOfNotNullValues

data class DisplayParams(
    var id: Long? = null,
    val thetvdbId: Long? = null,
    val imdbId: Long? = null,
    val url: String? = null
) : Params {
    override fun toMap(): Map<String, String?> {
        return mapOfNotNullValues(
            "id" to id,
            "thetvdb_id" to thetvdbId,
            "imdb_id" to imdbId,
            "url" to url,
        )
    }
}
