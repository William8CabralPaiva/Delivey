package com.cabral.delivery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cabral.delivery.R
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.components.DeliveryTextField
import com.cabral.delivery.ui.components.FieldType
import com.cabral.delivery.ui.savers.ProductSaver
import com.cabral.delivery.ui.theme.DeliveryTheme
import java.math.BigDecimal

@Composable
fun ProductFormScreen(
    onSaveClick: (Product) -> Unit = {},
) {
    var product by rememberSaveable(stateSaver = ProductSaver) {
        mutableStateOf(
            Product(
                name = "",
                price = BigDecimal.ZERO,
                image = "",
                description = ""
            )
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            // foi colocado o margin apenas no horizontal pq quando scrolla tem espaçamento no top e no bottom
            // entao colocamos o spacer no top e bottom
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Criando o produto",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )

        if (!product.image.isNullOrBlank()) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }

        DeliveryTextField(
            value = product.image ?: "",
            onValueChange = { product = product.copy(image = it) },
            label = "Url da imagem",
            modifier = Modifier.fillMaxWidth(),
            type = FieldType.URL
        )

        DeliveryTextField(
            value = product.name,
            onValueChange = { product = product.copy(name = it) },
            label = "Nome",
            modifier = Modifier.fillMaxWidth(),
            type = FieldType.NAME
        )

        DeliveryTextField(
            value = if (product.price == BigDecimal.ZERO) "" else product.price.toPlainString(),
            onValueChange = {
                product = product.copy(
                    price = it.toBigDecimalOrNull() ?: BigDecimal.ZERO
                )
            },
            label = "Preço",
            modifier = Modifier.fillMaxWidth(),
            type = FieldType.MONEY
        )

        DeliveryTextField(
            value = product.description ?: "",
            onValueChange = { product = product.copy(description = it) },
            label = "Descrição",
            modifier = Modifier.fillMaxWidth(),
            type = FieldType.TEXT_AREA
        )

        Button(
            onClick = {
                Log.i("ProductFormActivity", "ProductFormScreen: $product")
                onSaveClick(product)
            },
            Modifier.fillMaxWidth(),
        ) {
            Text(text = "Salvar", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
fun ProductFormScreenPreview() {
    DeliveryTheme {
        Surface {
            ProductFormScreen()
        }
    }
}
