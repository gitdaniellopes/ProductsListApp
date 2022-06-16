package br.com.productslist.presentation.update_product.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.core.Constants
import br.com.productslist.core.Constants.UPDATE
import br.com.productslist.domain.model.Product
import br.com.productslist.presentation.destinations.ProductScreenDestination
import br.com.productslist.presentation.products.ProductViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun UpdateProductContent(
    paddingValues: PaddingValues,
    productId: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val name = viewModel.product.name.orEmpty()
    val price = viewModel.product.price.toString()
    val amount = viewModel.product.amount.toString()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name ->
                viewModel.updateName(name)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {
                Text(text = Constants.NAME)
            },
        )
        Spacer(
            modifier = modifier.height(8.dp)
        )
        OutlinedTextField(
            value = price,
            onValueChange = { price ->
                viewModel.updatePrice(price = price)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = {
                Text(text = Constants.PRICE)
            },
        )
        Spacer(
            modifier = modifier.height(8.dp)
        )
        //Erro ao atualizar
        OutlinedTextField(
            value = amount,
            onValueChange = { amount ->
                viewModel.updateAmount(amount = amount)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {
                Text(text = Constants.AMOUNT)
            },
        )
        Spacer(
            modifier = modifier.height(8.dp)
        )
        Button(
            onClick = {
                val updateProduct = Product(
                    id = productId,
                    name = name,
                    price = price.toDouble(),
                    amount = amount.toInt()
                )
                viewModel.updateProduct(updateProduct)
                navigator.navigate(ProductScreenDestination)
            }
        ) {
            Text(
                text = UPDATE
            )
        }
    }
}