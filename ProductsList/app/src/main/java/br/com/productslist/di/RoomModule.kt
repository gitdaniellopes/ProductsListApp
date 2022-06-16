package br.com.productslist.di

import android.content.Context
import androidx.room.Room
import br.com.productslist.core.Constants.PRODUCT_DB
import br.com.productslist.data.database.ProductDao
import br.com.productslist.data.database.ProductDatabase
import br.com.productslist.data.repository.ProductRepositoryImpl
import br.com.productslist.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideProductDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ProductDatabase::class.java,
        PRODUCT_DB
    ).build()


    @Provides
    fun provideProductDao(
        productDatabase: ProductDatabase
    ) = productDatabase.productDao()

    @Provides
    fun provideProductRepository(
        productDao: ProductDao
    ): ProductRepository = ProductRepositoryImpl(productDao)
}