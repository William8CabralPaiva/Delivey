package com.cabral.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabral.delivery.exampledata.sampleProducts
import com.cabral.delivery.exampledata.sampleSections
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.components.CardProductItem
import com.cabral.delivery.ui.components.ProductsSection
import com.cabral.delivery.ui.components.SearchTextField
import com.cabral.delivery.ui.theme.DeliveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
) {

    var focusSearch by remember { mutableStateOf(FocusRequester()) }
    Column {
        var searchText by remember { mutableStateOf("") }
//        OutlinedTextField(value = searchText, onValueChange = {
//            searchText = it
//        })
        SearchTextField(
            value = searchText,
            label = "Pesquisar",
            placeholder = "O que vc procura?",
            focus = focusSearch,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp),
        ) {
            //  item { Spacer(Modifier) }// // Este item está recebendo um espaço do verticalArrangement
//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ProductsSection(title, products)
//                }
//            }
          //  item { Spacer(Modifier) }
            items(sampleProducts){
                CardProductItem(it,Modifier.padding(horizontal = 16.dp))
            }
        }
    }

    LaunchedEffect(Unit) {
        focusSearch.requestFocus()
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    DeliveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}