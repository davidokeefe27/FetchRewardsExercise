package com.example.fetchrewardsexercise.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HiringModel (
    val id: Int,
    @Json(name = "listId")
    val listId: Int,
    val name: String?,
)