package br.com.productslist.presentation.update_product.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import br.com.productslist.core.Constants
import br.com.productslist.core.Constants.BACK
import br.com.productslist.presentation.destinations.ProductScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun UpdateProductTopBar(
    navigator: DestinationsNavigator
) {
    TopAppBar(
        title = {
            Text(text = Constants.UPDATE_PRODUCT_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = {
                navigator.navigate(ProductScreenDestination)
            }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = BACK,
                )
            }
        }
    )
}