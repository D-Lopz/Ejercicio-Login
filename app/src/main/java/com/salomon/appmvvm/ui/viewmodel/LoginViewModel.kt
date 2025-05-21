package com.salomon.appmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salomon.appmvvm.data.model.UserModel
import com.salomon.appmvvm.data.model.response.LoginResponse
import com.salomon.appmvvm.domain.PostLoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    val _loginResponse = MutableLiveData<LoginResponse>()
    val _userModel = MutableLiveData<UserModel?>()

    // Feedback de carga
    val _isLoading = MutableLiveData<Boolean>()
    val _message = MutableLiveData<String?>()

    val loginUseCase = PostLoginUseCase()

    fun login(loginRequest: String, toString: String){

        viewModelScope.launch {
            _isLoading.postValue(true)

            val result = loginUseCase(loginRequest)
            _loginResponse.postValue(result)

            when(result.status){
                "success" ->{
                    _userModel.postValue(result.data)
                }
                "invalid" ->{
                    _message.postValue(result.message)
                    _isLoading.postValue(false)
                }
                "error" ->{
                    _message.postValue("Usuario no registrado! \uD83D\uDE14")
                    _isLoading.postValue(false)
                }
            }
        }
    }
}