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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cabral.delivery.R
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.components.DeliveryTextField
import com.cabral.delivery.ui.theme.DeliveryTheme
import java.math.BigDecimal
import java.text.DecimalFormat

@Composable
fun ProductFormScreen(
    onSaveClick: (Product) -> Unit = {},
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    val formatter = DecimalFormat("#.##")

    Column(
        Modifier
            .fillMaxSize()
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

        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }

        // Usando o componente reutilizável
        DeliveryTextField(
            value = url,
            onValueChange = { url = it },
            label = "Url da imagem",
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Uri
        )

        DeliveryTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nome",
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words
        )

        DeliveryTextField(
            value = price,
            onValueChange = {
                try {
                    price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if (it.isBlank()) price = it
                }
            },
            label = "Preço",
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Decimal
        )

        DeliveryTextField(
            value = description,
            onValueChange = { description = it },
            label = "Descrição",
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Sentences,
            minHeight = 100.dp
        )

        Button(
            onClick = {
                val convertedPrice = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }
                val product = Product(
                    name = name,
                    image = url,
                    price = convertedPrice,
                    description = description
                )
                Log.i("ProductFormActivity", "ProductFormScreen: $product")
                onSaveClick(product)
            },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth(),
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