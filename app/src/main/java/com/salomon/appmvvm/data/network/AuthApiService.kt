package com.salomon.appmvvm.data.network

import com.salomon.appmvvm.core.RetrofitHelper
import com.salomon.appmvvm.data.model.request.LoginRequest
import com.salomon.appmvvm.data.model.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthApiService {
    private val retrofitAuth = RetrofitHelper.getRetrofitAuth()

    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        return withContext((Dispatchers.IO)){

            val response = retrofitAuth.create(AuthApiClient::class.java).login(loginRequest)
            response.body() ?: LoginResponse("Problemas con el servidor", null, "error")
        }
    }
}