package com.salomon.appmvvm.domain

import com.salomon.appmvvm.data.model.response.LoginResponse
import com.salomon.appmvvm.data.repository.AuthRepository

class PostLoginRequest {
    private val authRepository = AuthRepository()

    suspend fun invoke(loginRequest: PostLoginRequest): LoginResponse{
        return authRepository.login(loginRequest)
    }
}