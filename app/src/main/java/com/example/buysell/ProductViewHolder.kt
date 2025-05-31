package com.example.buysell

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvName = view.findViewById<TextView>(R.id.tvName)

    val tvPrices = view.findViewById<TextView>(R.id.tvPrices)

    val tvProfit = view.findViewById<TextView>(R.id.tvProfit)


}