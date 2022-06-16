package br.com.productslist.presentation.products.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.productslist.core.Constants
import br.com.productslist.ui.theme.ProductsListTheme

@Composable
fun ProductsTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = Constants.PRODUCTS_SCREEN)
        }
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ProductsTopBarPreview() {
    ProductsListTheme {
        ProductsTopBar(
            modifier = Modifier
        )
    }
}