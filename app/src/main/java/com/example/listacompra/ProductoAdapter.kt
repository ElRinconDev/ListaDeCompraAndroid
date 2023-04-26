package com.example.listacompra

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ProductoAdapter( private val productos: List<String>, private val onProductoDone: (Int) -> Unit ):
    RecyclerView.Adapter<ProductoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
       val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ProductoViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
       return productos.size

    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
      holder.render(productos[position],onProductoDone)
    }


}