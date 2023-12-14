package fr.rtransat.kotaseries.api.params.shows

import fr.rtransat.kotaseries.api.params.Params
import fr.rtransat.kotaseries.utils.mapOfNotNullValues

data class DisplayParams(
    private val id: Long? = null,
    private val thetvdbId: Long? = null,
    private val imdbId: Long? = null,
    private val url: String? = null
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
