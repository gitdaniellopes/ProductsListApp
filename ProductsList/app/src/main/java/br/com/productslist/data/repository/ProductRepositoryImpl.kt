package br.com.productslist.data.repository

import br.com.productslist.data.database.ProductDao
import br.com.productslist.domain.model.Product
import br.com.productslist.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val dao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<Product>> = dao.getProducts()

    override suspend fun getProductById(id: Int): Flow<Product> = dao.getProductById(id = id)

    override suspend fun addProduct(product: Product) = dao.addProduct(product = product)

    override suspend fun updateProduct(product: Product) = dao.updateProduct(product = product)

    override suspend fun deleteProduct(product: Product) = dao.deleteProduct(product = product)

    override suspend fun shoppingCart() = dao.shoppingCart()
}