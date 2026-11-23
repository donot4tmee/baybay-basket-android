package com.baybaybasket.android.data

data class Business(
    val uuid: String,
    val name: String,
    val serviceArea: String,
)

data class Product(
    val uuid: String,
    val businessUuid: String,
    val name: String,
    val category: String,
    val unitLabel: String,
    val price: Double,
    val archivedAt: String? = null,
)

data class BasketLine(
    val productUuid: String,
    val quantity: Double,
)

data class Basket(
    val businessUuid: String,
    val lines: List<BasketLine>,
)
