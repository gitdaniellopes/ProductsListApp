package br.com.productslist.presentation.update_product

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.presentation.products.ProductViewModel
import br.com.productslist.presentation.update_product.components.UpdateProductContent
import br.com.productslist.presentation.update_product.components.UpdateProductTopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun UpdateProductScreen(
    modifier: Modifier = Modifier,
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    LaunchedEffect(Unit) {
        viewModel.getProduct(productId)
    }

    Scaffold(
        topBar = {
            UpdateProductTopBar(
                navigator = navigator
            )
        },
        content = { paddingValues ->
            UpdateProductContent(
                paddingValues = paddingValues,
                productId = productId,
                modifier = modifier,
                navigator = navigator
            )
        }
    )
}