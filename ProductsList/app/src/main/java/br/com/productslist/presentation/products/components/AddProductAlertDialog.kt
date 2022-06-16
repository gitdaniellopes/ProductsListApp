package br.com.productslist.presentation.products.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.productslist.core.Constants
import br.com.productslist.presentation.products.ProductViewModel
import br.com.productslist.ui.theme.ProductsListTheme
import kotlinx.coroutines.job

@Composable
fun AddProductAlertDialog(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    //rever codelab de estado do compose
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    if (viewModel.openDialog) {
        AlertDialog(
            onDismissRequest = {
                viewModel.openDialog = false
            },
            title = {
                Text(text = Constants.ADD_PRODUCT)
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = {
                            Text(text = Constants.NAME)
                        },
                        modifier = modifier.focusRequester(focusRequester)
                    )
                    //pesquisar sobre
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = modifier.height(8.dp)
                    )
                    OutlinedTextField(
                        value = price,
                        onValueChange = {
                            price = it
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = Constants.PRICE)
                        },
                    )
                    Spacer(
                        modifier = modifier.height(8.dp)
                    )
                    OutlinedTextField(
                        value = amount.toString(),
                        onValueChange = {
                            amount = it
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = Constants.AMOUNT)
                        },
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.openDialog = false
                        viewModel.addProduct(name, price, amount)
                    }
                ) {
                    Text(
                        text = Constants.ADD
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        viewModel.openDialog = false
                    }
                ) {
                    Text(
                        text = Constants.CANCEL
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AddProductAlertDialogPreview() {
    ProductsListTheme {
        AddProductAlertDialog()
    }
}