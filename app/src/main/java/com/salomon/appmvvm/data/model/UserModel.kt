package com.salomon.appmvvm.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    val id_user:Int,
    val rol_id:Int,
    val institucion_id:Int,
    val userName: String,
    val identidication:String,

    @SerializedName("name") val name: String,

    @SerializedName("last_name") val lastName: String,

    val grade:String,
    val calendar_type:String,
    val birthday:String,

    @SerializedName("jwt") val jwt:String
)
