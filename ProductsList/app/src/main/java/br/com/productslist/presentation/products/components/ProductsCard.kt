package br.com.productslist.presentation.products.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.domain.model.Product
import br.com.productslist.presentation.destinations.UpdateProductScreenDestination
import br.com.productslist.presentation.products.ProductViewModel
import br.com.productslist.ui.theme.ProductsListTheme
import br.com.productslist.util.toCurrency
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductsCard(
    product: Product,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(
                start = 8.dp,
                top = 4.dp,
                end = 8.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
            .heightIn(56.dp),
        elevation = 3.dp,
        onClick = {
            navigator
                .navigate(
                    UpdateProductScreenDestination(
                        productId = product.id
                    )
                )
        }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth(0.90f)
            ) {
                Text(
                    text = "#${product.id} ${product.name.orEmpty()}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "Preço: ${product.price?.toCurrency()}",
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 15.sp
                )
                Text(
                    text = "Quantidade: ${product.amount}",
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 15.sp
                )
            }
            DeleteProduct(
                viewModel = viewModel,
                product = product
            )
        }
    }
}


//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun ProductsCardPreview() {
//    ProductsListTheme {
//        ProductsCard(
//            product = Product(0, "Arroz", 18.90, 1),
//            modifier = Modifier,
//            navigator = DestinationsNavigator
//        )
//    }
//}