package fr.rtransat.kotaseries.api

import fr.rtransat.kotaseries.api.params.shows.DisplayParams
import fr.rtransat.kotaseries.exceptions.ShowException
import fr.rtransat.kotaseries.models.Show
import fr.rtransat.kotaseries.models.ShowResponse
import io.ktor.client.*

class Shows internal constructor(httpClient: HttpClient) : AbstractApi(httpClient) {
    suspend fun display(params: DisplayParams = DisplayParams(), builder: DisplayParams.() -> Unit = {}): Show {
        val data = get("shows/display", params.apply(builder))
        val showResponse = json.decodeFromString<ShowResponse>(data)

        if (showResponse is ShowResponse.Errors) {
            throw ShowException(showResponse.errors.first().text, showResponse.errors.first().code)
        }

        return (showResponse as ShowResponse.Success).show
    }
}
