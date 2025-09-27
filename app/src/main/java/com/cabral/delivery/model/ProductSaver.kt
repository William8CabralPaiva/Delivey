//package com.cabral.delivery.model
//
//import androidx.compose.foundation.text.input.TextFieldState
//import androidx.compose.runtime.saveable.mapSaver
//import java.math.BigDecimal
//
//fun ProductSaver(): TextFieldState.Saver<Product, Any> = mapSaver(
//    save = { product ->
//        mapOf(
//            "name" to product.name,
//            "image" to product.image,
//            "price" to product.price.toPlainString(),
//            "description" to product.description
//        )
//    },
//    restore = { map ->
//        Product(
//            name = map["name"] as String,
//            image = map["image"] as String,
//            price = BigDecimal(map["price"] as String),
//            description = map["description"] as String
//        )
//    }
//)