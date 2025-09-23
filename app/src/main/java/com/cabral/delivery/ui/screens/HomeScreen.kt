package com.cabral.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabral.delivery.exampledata.sampleSections
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.components.ProductsSection
import com.cabral.delivery.ui.theme.DeliveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        //contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
    ) {
        item { Spacer(Modifier) }// // Este item está recebendo um espaço do verticalArrangement
        for (section in sections) {
            val title = section.key
            val products = section.value
            item {
                ProductsSection(title, products)
            }
        }
        //modifier pega os a
        item { Spacer(Modifier) }
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