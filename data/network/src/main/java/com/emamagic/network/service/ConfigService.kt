package com.emamagic.network.service

import com.emamagic.network.dto.ConfigDto
import retrofit2.Response
import retrofit2.http.GET

interface ConfigService {

    @GET("api/v1/config")
    suspend fun getConfig(): Response<ConfigDto>


}