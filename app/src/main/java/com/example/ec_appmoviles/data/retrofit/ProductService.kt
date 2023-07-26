package com.example.ec_appmoviles.data.retrofit

import com.example.ec_appmoviles.data.response.ProductListResponse
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): ProductListResponse
}