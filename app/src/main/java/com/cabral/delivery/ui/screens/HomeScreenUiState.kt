package com.cabral.delivery.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import com.cabral.delivery.exampledata.sampleProducts
import com.cabral.delivery.model.Product

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    private val products: List<Product> = emptyList(),
    searchText: String = "",
) {

    var text by mutableStateOf(searchText)
        private set

    val onSearchChange: (String) -> Unit = { searchText ->
        text = searchText
    }

    var focus by mutableStateOf(FocusRequester())

    val searchedProducts
        get() = if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())
        } else emptyList()

    private fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

}