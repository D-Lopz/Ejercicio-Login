package com.salomon.appmvvm.domain

import com.salomon.appmvvm.data.model.request.LoginRequest
import com.salomon.appmvvm.data.model.response.LoginResponse
import com.salomon.appmvvm.data.repository.AuthRepository

class PostLoginUseCase {
    private val authRepository = AuthRepository()

    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse{
        return authRepository.login(loginRequest)
    }
}