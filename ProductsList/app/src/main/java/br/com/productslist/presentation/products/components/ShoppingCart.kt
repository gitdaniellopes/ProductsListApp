package br.com.productslist.presentation.products.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.productslist.ui.theme.ProductsListTheme

@Composable
fun ShoppingCart(
    modifier: Modifier = Modifier,
    totalCard: String
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Valor da compra:",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = modifier.padding(end = 8.dp)
        )
        Text(
            text = totalCard,
            color = Color.Black,
            fontSize = 18.sp,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ShoppingCartPreview() {
    ProductsListTheme {
        ShoppingCart(
            modifier = Modifier,
            totalCard = "R$ 158,97"
        )
    }
}