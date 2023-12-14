package fr.rtransat.kotaseries.models


import fr.rtransat.kotaseries.serializers.ShowResponseSerializer
import kotlinx.serialization.Serializable

@Serializable
data class Show(val id: Long, val thetvdbId: Long, val slug: String, val title: String)

@Serializable(with = ShowResponseSerializer::class)
sealed interface ShowResponse {
    @Serializable
    data class Success(val show: Show) : ShowResponse

    @Serializable
    data class Errors(val errors: List<Error>) : ShowResponse
}
