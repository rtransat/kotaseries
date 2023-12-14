package fr.rtransat.kotaseries.models

import kotlinx.serialization.Serializable

@Serializable
data class Error(val code: Int, val text: String)
