package com.example.fetchrewardsexercise.api

import com.example.fetchrewardsexercise.models.HiringModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("hiring.json")
    suspend fun getData(): Response<List<HiringModel>>
}