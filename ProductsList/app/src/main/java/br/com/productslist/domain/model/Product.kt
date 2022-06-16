package br.com.productslist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String? = "",
    val price: Double? = 0.0,
    val amount: Int? = 0
)
