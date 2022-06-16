package br.com.productslist.presentation.products.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.core.Constants.ADD_PRODUCT
import br.com.productslist.presentation.products.ProductViewModel
import br.com.productslist.ui.theme.ProductsListTheme

@Composable
fun ProductsFab(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel()
) {
    FloatingActionButton(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        onClick = {
            viewModel.openDialog = true
        }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_PRODUCT

        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ProductFabBarPreview() {
    ProductsListTheme {
        ProductsFab(
            modifier = Modifier
        )
    }
}