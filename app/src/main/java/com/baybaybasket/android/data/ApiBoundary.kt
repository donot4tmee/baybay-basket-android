package com.baybaybasket.android.data

interface ApiBoundary {
    suspend fun listBusinesses(): List<Business>
    suspend fun listProducts(businessUuid: String): List<Product>
    suspend fun submitOrder(
        businessUuid: String,
        lines: List<BasketLine>,
        fulfillmentMethod: String,
        deliveryArea: String?,
        privateDeliveryDetails: String?,
    ): String
}

interface OfflineStore {
    suspend fun dirtyProducts(): List<Product>
    suspend fun markSynchronized(uuid: String, updatedAt: String)
    suspend fun saveTombstone(uuid: String, archivedAt: String, updatedAt: String)
}
