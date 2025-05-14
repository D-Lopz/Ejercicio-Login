package com.salomon.appmvvm.data.repository

import com.salomon.appmvvm.data.model.UserProvider
import com.salomon.appmvvm.data.model.request.LoginRequest
import com.salomon.appmvvm.data.model.response.LoginResponse
import com.salomon.appmvvm.data.network.AuthApiService

class AuthRepository {

    private val  authApiService = AuthApiService()

    suspend fun login(loginRequest: LoginRequest): LoginResponse{

        val response = authApiService.login(loginRequest)

        if(response.status == "success"){
        UserProvider.user = response.data
        }
        return response
    }
}