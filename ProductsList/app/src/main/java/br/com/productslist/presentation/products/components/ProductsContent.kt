package br.com.productslist.presentation.products.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.presentation.products.ProductViewModel
import br.com.productslist.ui.theme.ProductsListTheme
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ProductsContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    navigator: DestinationsNavigator,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues)
    )
    {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues),

            ) {
            items(
                items = viewModel.products,
                key = { product -> product.id }
            ) { product ->
                ProductsCard(
                    product = product,
                    navigator = navigator
                )
            }
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun ProductsContentPreview() {
//    ProductsListTheme {
//        Scaffold {
//            ProductsContent(
//                modifier = Modifier,
//                paddingValues = PaddingValues()
//            )
//        }
//    }
//}