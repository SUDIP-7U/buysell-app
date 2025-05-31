package com.example.buysell

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)

    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.tvName.text = product.name

        holder.tvPrices.text = "Buy: ${product.buyPrice} | Sell: ${product.sellPrice}"

        holder.tvProfit.text = "Profit/Loss: ${product.profitOrLoss}"

        holder.tvProfit.setTextColor(

            if (product.profitOrLoss >= 0)
                Color.parseColor("#388E3C") else Color.parseColor("#D32F2F")
        )
    }
}
