package com.example.ec_appmoviles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ec_appmoviles.databinding.ItemProductsBinding
import com.example.ec_appmoviles.model.Products

class ProductListAdapter(var products: List<Products>): RecyclerView.Adapter<ProductVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val binding = ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductVH(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(products.get(position))
    }
}

class ProductVH(private val binding: ItemProductsBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(products: Products){
        Glide.with(binding.root)
            .load(products.images[0])
            .into(binding.imageView)
        binding.txtIdProd.text = products.id.toString()
        binding.txtTitle.text = products.title
        binding.txtPrice.text = products.price.toString()
        binding.txtDescription.text = products.description
        binding.txtCreacionEn.text = products.createdAt
        binding.txtActualizadoEn.text = products.updatedAt
        binding.txtCategoria.text = products.category.id.toString()
        binding.txtNomCat.text = products.category.name

    }
}