package fr.rtransat.kotaseries.serializers

import fr.rtransat.kotaseries.models.ShowResponse
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object ShowResponseSerializer: JsonContentPolymorphicSerializer<ShowResponse>(ShowResponse::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ShowResponse> = when {
        "show" in element.jsonObject -> ShowResponse.Success.serializer()
        else -> ShowResponse.Errors.serializer()
    }
}
