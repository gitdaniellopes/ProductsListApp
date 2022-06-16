package br.com.productslist.presentation.products

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.presentation.products.components.*
import br.com.productslist.ui.theme.ProductsListTheme
import br.com.productslist.util.toCurrency
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    LaunchedEffect(Unit) {
        viewModel.getProducts()
        viewModel.getShoppingCart()
    }
    Scaffold(
        topBar = {
            ProductsTopBar()
        },
        floatingActionButton = {
            ProductsFab()
        }

    ) { paddingValues ->
        Column(modifier = modifier) {
            ShoppingCart(
                totalCard = viewModel.shoppingCart.toCurrency()
            )
            ProductsContent(
                paddingValues = paddingValues,
                navigator = navigator
            )
        }
    }

    if (viewModel.openDialog) {
        AddProductAlertDialog()
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun ProductScreenPreview() {
//    ProductsListTheme {
//        ProductScreen()
//    }
//}