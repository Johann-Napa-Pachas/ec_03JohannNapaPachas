package com.example.ec_appmoviles.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
//    https://api.escuelajs.co/api/v1/products
    private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.escuelajs.co/api/v1/")
    .client(OkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    fun getProductService(): ProductService = retrofit.create(ProductService::class.java)
}