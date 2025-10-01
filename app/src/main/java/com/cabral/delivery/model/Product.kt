package com.cabral.delivery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null
): Parcelable