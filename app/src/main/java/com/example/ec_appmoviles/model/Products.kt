package com.example.ec_appmoviles.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("identificación")
    val id: Int,
    @SerializedName("título")
    val title: String,
    @SerializedName("precio")
    val price: Int,
    @SerializedName("descripción")
    val description: String,
    @SerializedName("imágenes")
    val images: String,
    @SerializedName("creaciónEn")
    val createdAt: String,
    @SerializedName("actualizado en")
    val updatedAt: String,
    @SerializedName("categoría")
    val category: Category
)

data class Category(
    @SerializedName("identificación")
    val id: Int,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("imagen")
    val image: String,
    @SerializedName("creaciónEn")
    val createdAt: String,
    @SerializedName("actualizado en")
    val updatedAt: String
)

fun getDataFromApi(apiResponse: String): List<Products> {
    val gson = Gson()
    val couponArray = gson.fromJson(apiResponse, Array<Products>::class.java)
    return couponArray.toList()
}