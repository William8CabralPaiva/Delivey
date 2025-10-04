package com.cabral.delivery.ui.screens.states

import com.cabral.delivery.model.Product
import java.math.BigDecimal

data class ProductUi(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
) {
    // executa sempre que chama a classe
    val isShowPreview: Boolean = url.isNotBlank()
}

fun ProductUi.toProduct(): Product {

    val convertedPrice = try {
        BigDecimal(price)
    } catch (_: NumberFormatException) {
        BigDecimal.ZERO
    }

    return Product(
        name = name,
        price = convertedPrice,
        image = url,
        description = description
    )
}