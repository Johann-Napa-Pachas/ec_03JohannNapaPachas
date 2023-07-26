package com.example.ec_appmoviles.data.response

import java.lang.Exception

sealed class ApiResponse<P>(data: P? = null, exception: Exception?= null){
    data class Success<P>(val data: P): ApiResponse<P>(data)
    data class Error<P>(val exception: Exception): ApiResponse<P>(null,exception)
}
