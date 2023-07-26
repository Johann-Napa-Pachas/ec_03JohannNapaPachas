package com.example.ec_appmoviles.data.repository

import com.example.ec_appmoviles.data.response.ApiResponse
import com.example.ec_appmoviles.data.response.ProductListResponse
import com.example.ec_appmoviles.data.retrofit.RetrofitInstance

class ProductsRepository {
    suspend fun getProducts():ApiResponse<ProductListResponse>{
        return try{
            val response = RetrofitInstance.getProductService().getProducts()
            ApiResponse.Success(response)
        }catch (e:Exception){
            ApiResponse.Error(e)
        }
    }
}