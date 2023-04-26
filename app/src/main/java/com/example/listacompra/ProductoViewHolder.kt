package com.example.listacompra

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //Donde pintamos
    private val tvProducto: TextView = view.findViewById(R.id.tvProducto)
    private val ivProductoDone: ImageView = view.findViewById(R.id.ivProductoDone)


    fun render(producto: String, onItemDone: (Int) -> Unit) {
        tvProducto.text = producto
        //Para cuando pulse en el done
        ivProductoDone.setOnClickListener {
            onItemDone(adapterPosition)
        }
    }
}