package com.example.buysell

data class Product(
    val name: String,
    val buyPrice: Double,
    val sellPrice: Double
) {
    val profitOrLoss: Double
        get() = sellPrice - buyPrice
}
