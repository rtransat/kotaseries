package fr.rtransat.kotaseries.api

import fr.rtransat.kotaseries.Client
import fr.rtransat.kotaseries.api.params.Params
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.net.URI

abstract class AbstractApi(private val httpClient: HttpClient) {
    protected val json = Json {
        ignoreUnknownKeys = true
        namingStrategy = JsonNamingStrategy.SnakeCase
    }

    protected suspend fun get(path: String, params: Params?) = request(HttpMethod.Get, path, params)

    private suspend fun request(method: HttpMethod, path: String, params: Params?): String {
        val url = URI(Client.BASE_URL).toHttpUrlOrNull()!!.newBuilder()

        params?.toMap()?.forEach { (key, value) -> url.addQueryParameter(key, value) }

        url.addPathSegment(path)

        val response = httpClient.request(url.build().toString()) {
            this.method = method
        }

        return response.body()
    }
}
