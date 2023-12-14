package fr.rtransat.kotaseries.api

import fr.rtransat.kotaseries.api.params.shows.DisplayParams
import fr.rtransat.kotaseries.models.Show
import fr.rtransat.kotaseries.models.ShowResponse
import fr.rtransat.kotaseries.exceptions.ShowException
import io.ktor.client.*

class Shows internal constructor(httpClient: HttpClient): AbstractApi(httpClient) {
    suspend fun display(params: DisplayParams): Show {
        val data = get("shows/display", params)
        val showResponse = json.decodeFromString<ShowResponse>(data)

        if (showResponse is ShowResponse.Errors) {
            throw ShowException(showResponse.errors.first().text, showResponse.errors.first().code)
        }

        return (showResponse as ShowResponse.Success).show
    }
}
