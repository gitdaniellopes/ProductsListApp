package br.com.productslist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.productslist.domain.model.Product

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}