package br.com.productslist.data.database

import androidx.room.*
import br.com.productslist.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product ORDER BY id ASC")
     fun getProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id = :id")
     fun getProductById(id: Int): Flow<Product>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addProduct(product: Product)

    @Update
     fun updateProduct(product: Product)

    @Delete
     fun deleteProduct(product: Product)

    @Query("SELECT SUM(price * amount) FROM product")
     fun shoppingCart(): Flow<Double?>
}