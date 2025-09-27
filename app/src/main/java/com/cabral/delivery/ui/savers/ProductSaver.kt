package com.cabral.delivery.ui.savers

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import com.cabral.delivery.model.Product
import java.math.BigDecimal

//o saver é usado quando tem um tipo não primitivo como BigDecimal e o mutable state n consegue tratar
// podendo ser desde um valor n primitivo um algo objeto criado no app, caso o objeto n seja parcecle nem serialize
val ProductSaver: Saver<Product, Any> = mapSaver(
    save = { product ->
        mapOf(
            "name" to product.name,
            "price" to product.price.toPlainString(),
            "image" to (product.image ?: ""),
            "description" to (product.description ?: "")
        )
    },
    restore = { map ->
        Product(
            name = map["name"] as String,
            price = (map["price"] as String).toBigDecimalOrNull() ?: BigDecimal.ZERO,
            image = (map["image"] as String).ifBlank { null },
            description = (map["description"] as String).ifBlank { null }
        )
    }
)