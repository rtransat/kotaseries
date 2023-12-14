package fr.rtransat.kotaseries

import fr.rtransat.kotaseries.api.Shows
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class Client(private val apiKey: String) {
    companion object {
        const val API_VERSION = "3.0"
        const val BASE_URL = "https://api.betaseries.com"
    }

    private val httpClient = HttpClient(OkHttp) {
        defaultRequest {
            url(BASE_URL)
            headers {
                append("X-BetaSeries-Key", apiKey)
                append("X-BetaSeries-Version", API_VERSION)
                append("Content-Type", "application/json")
            }
        }
    }

    val shows: Shows = Shows(httpClient)
}
