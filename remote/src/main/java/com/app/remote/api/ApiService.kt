package com.app.remote.api

import com.app.remote.model.CharactersModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): CharactersModel
}