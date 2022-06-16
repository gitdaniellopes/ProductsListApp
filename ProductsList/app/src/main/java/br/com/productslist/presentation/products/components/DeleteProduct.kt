package br.com.productslist.presentation.products.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.productslist.core.Constants.DELETE_PRODUCT
import br.com.productslist.domain.model.Product
import br.com.productslist.presentation.products.ProductViewModel

@Composable
fun DeleteProduct(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel,
    product: Product
) {
    IconButton(
        onClick = {
            viewModel.deleteProduct(product)
        }
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_PRODUCT,
            tint = MaterialTheme.colors.onSurface
        )
    }
}