package br.com.productslist.domain.repository

import br.com.productslist.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): Flow<List<Product>>

    suspend fun getProductById(id: Int): Flow<Product>

    suspend fun addProduct(product: Product)

    suspend fun updateProduct(product: Product)

    suspend fun deleteProduct(product: Product)

    suspend fun shoppingCart(): Flow<Double?>
}