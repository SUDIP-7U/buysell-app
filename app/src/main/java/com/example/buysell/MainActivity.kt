package com.example.buysell

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val products = mutableListOf<Product>()

    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etProductName)
        val etBuy = findViewById<EditText>(R.id.etBuyPrice)
        val etSell = findViewById<EditText>(R.id.etSellPrice)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = ProductAdapter(products)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val buy = etBuy.text.toString().toDoubleOrNull()
            val sell = etSell.text.toString().toDoubleOrNull()

            if (name.isNotBlank() && buy != null && sell != null) {

                val product = Product(name, buy, sell)
                products.add(product)
                adapter.notifyItemInserted(products.size - 1)
                etName.text.clear()
                etBuy.text.clear()
                etSell.text.clear()
            } else {
                Toast.makeText(this, "Enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
