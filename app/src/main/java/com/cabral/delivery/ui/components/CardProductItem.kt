package com.cabral.delivery.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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
    elevation: Dp = 4.dp
) {

    var expandedState by remember { mutableStateOf(false) }

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


            val textOverflow =
                if (expandedState) TextOverflow.Visible
                else TextOverflow.Ellipsis


            val maxLines =
                if (expandedState) Int.MAX_VALUE
                else 2
            product.description?.let {
                Text(
                    text = product.description,
                    Modifier
                        .padding(16.dp),
                    overflow = textOverflow,
                    maxLines = maxLines
                )

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
            )
        }
    }
}