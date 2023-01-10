package com.app.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//name, species, and gender
@Serializable
data class CharactersModel(
    @SerialName("info")
    val info: InfoBean,
    @SerialName("results")
    val resultsBean: List<ResultsModel>
)

@Serializable
data class ResultsModel(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("species")
    val species: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("origin")
    val origin: OriginBean?,
    @SerialName("location")
    val location: LocationModel?,
    @SerialName("image")
    val image: String?,
    @SerialName("episode")
    val episode: List<String>?,
    @SerialName("url")
    val url: String?,
    @SerialName("created")
    val created: String?
)
@Serializable
data class LocationModel(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

@Serializable
data class OriginBean(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
@Serializable
data class InfoBean(
    @SerialName("count")
    val count: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("next")
    val next: String,
    @SerialName("prev")
    val prev: String
)
