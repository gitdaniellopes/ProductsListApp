package br.com.productslist.presentation.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.productslist.domain.model.Product
import br.com.productslist.domain.repository.ProductRepository
import br.com.productslist.util.fromCurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    var products by mutableStateOf(emptyList<Product>())
    var product by mutableStateOf(Product(0, "", 0.0, 0))
    var shoppingCart by mutableStateOf(0.0)
    var openDialog by mutableStateOf(false)

    fun getProducts() = viewModelScope.launch {
        repository.getProducts().collect { response ->
            products = response
        }
    }

    fun getProduct(id: Int) = viewModelScope.launch {
        repository.getProductById(id).collect { response ->
            product = response
        }
    }

    fun getShoppingCart() = viewModelScope.launch {
        repository.shoppingCart().collect { total ->
            total?.let {
                shoppingCart = it
            }
        }
    }

    fun updateName(name: String) {
        product = product.copy(name = name)
    }

    fun updatePrice(price: String) {
        product = product.copy(price = price.toDoubleOrNull())
    }

    fun updateAmount(amount: String?) {
        product = product.copy(amount = amount?.toInt())
    }

    fun addProduct(name: String?, price: String, amount: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val product = Product(
                id = 0,
                name = name.orEmpty().trim(),
                price = price.fromCurrency(),
                amount = amount.toIntOrNull()
            )
            repository.addProduct(product)
        }

    fun updateProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateProduct(product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteProduct(product)
    }
}