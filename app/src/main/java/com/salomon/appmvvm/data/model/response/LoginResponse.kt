package com.salomon.appmvvm.data.model.response

import com.google.gson.annotations.SerializedName
import com.salomon.appmvvm.data.model.UserModel

data class LoginResponse(
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: UserModel?,
    @SerializedName("status") val status: String
)
