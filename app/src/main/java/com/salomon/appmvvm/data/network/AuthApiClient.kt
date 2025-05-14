package com.salomon.appmvvm.data.network

import com.salomon.appmvvm.data.model.request.LoginRequest
import com.salomon.appmvvm.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiClient {

    @POST("sign_in")
    suspend fun login(@Body loginRequest: LoginRequest):
            Response<LoginResponse>
}