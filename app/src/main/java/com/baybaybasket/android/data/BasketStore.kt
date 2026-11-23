package com.baybaybasket.android.data

class BasketStore {
    private var selectedBusinessUuid: String? = null
    private val lines = linkedMapOf<String, BasketLine>()

    fun add(product: Product, quantity: Double = 1.0): Result<Unit> {
        if (quantity <= 0.0) return Result.failure(IllegalArgumentException("Quantity must be positive"))
        val business = selectedBusinessUuid
        if (business != null && business != product.businessUuid) {
            return Result.failure(IllegalArgumentException("A basket may contain one business only"))
        }
        selectedBusinessUuid = product.businessUuid
        val current = lines[product.uuid]?.quantity ?: 0.0
        lines[product.uuid] = BasketLine(product.uuid, current + quantity)
        return Result.success(Unit)
    }

    fun snapshot(): Basket? {
        val business = selectedBusinessUuid ?: return null
        return Basket(business, lines.values.toList())
    }

    fun clear() {
        selectedBusinessUuid = null
        lines.clear()
    }
}
