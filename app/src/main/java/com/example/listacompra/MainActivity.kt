package com.example.listacompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listacompra.ProductoApplication.Companion.prefs
import com.example.listacompra.databinding.ActivityMainBinding
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    lateinit var btnAddProducto: Button
    lateinit var etProducto: EditText
    lateinit var rvProductos: RecyclerView

    private lateinit var mBinding: ActivityMainBinding


    lateinit var adapter: ProductoAdapter
    var productos = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        initView()
        initListeners()
        initRecyclerView()
    }


    private fun initView() {
        btnAddProducto = findViewById(R.id.btnAddProducto)
        etProducto = findViewById(R.id.etProducto)
        rvProductos = findViewById(R.id.rvProductos)

    }

    private fun initListeners() {
        btnAddProducto.setOnClickListener {
            addProducto()
        }
    }

    private fun addProducto() {
        val producto: String = etProducto.text.toString()
        productos.add(producto)
        //adapter notify
        adapter.notifyDataSetChanged()
        etProducto.setText("")
        //las guardo en prefs para cuando cierre la aplicacion
        prefs.saveProductos(productos)
    }

    private fun initRecyclerView() {
        //obtengo los datos del prefs
        productos = prefs.getProductos()
        rvProductos.layoutManager = LinearLayoutManager(this)
        adapter = ProductoAdapter(productos) { deleteProducto(it) }
        rvProductos.adapter = adapter
    }


    private fun deleteProducto(position: Int) {
        productos.removeAt(position)
        adapter.notifyDataSetChanged()
        prefs.saveProductos(productos)
    }
}