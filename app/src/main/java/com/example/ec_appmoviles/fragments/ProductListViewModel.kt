package com.example.ec_appmoviles.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ec_appmoviles.data.repository.ProductsRepository
import com.example.ec_appmoviles.data.response.ApiResponse
import com.example.ec_appmoviles.model.Products
import com.example.ec_appmoviles.model.getDataFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductListViewModel: ViewModel() {
    val repository = ProductsRepository()
    val productList: MutableLiveData<List<Products>> = MutableLiveData<List<Products>>()

    fun getProductList(apiResponse: String){
        val data = getDataFromApi(apiResponse)
        productList.value = data
    }

    fun getProductFromService(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getProducts()
            when(response){
                is ApiResponse.Error -> {}
                is ApiResponse.Success ->{
                    productList.postValue(response.data.products)
                }
            }
        }
    }
}