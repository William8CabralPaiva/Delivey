package com.cabral.delivery.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cabral.delivery.R
import com.cabral.delivery.exampledata.sampleProducts
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.theme.DeliveryTheme
import com.cabral.delivery.utils.extesions.toBrCurrency

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    isExpanded: Boolean = false,
) {

    var expandedState by rememberSaveable { mutableStateOf(isExpanded) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expandedState = !expandedState }
            .animateContentSize(), // Adicionado para uma animação suave
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrCurrency()
                )
            }

            if (expandedState) {
                product.description?.let {
                    Text(
                        text = product.description,
                        Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    DeliveryTheme {
        Surface {
            val product = sampleProducts[1]
            CardProductItem(
                product = product,
                isExpanded = false
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemDescriptionPreview() {
    DeliveryTheme {
        Surface {
            val product = sampleProducts[0]
            CardProductItem(
                product = product,
                isExpanded = true
            )
        }
    }
}