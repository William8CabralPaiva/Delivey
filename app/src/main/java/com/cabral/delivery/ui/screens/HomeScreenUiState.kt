package com.cabral.delivery.ui.screens

import androidx.compose.ui.focus.FocusRequester
import com.cabral.delivery.model.Product

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val focus : FocusRequester = FocusRequester()
) {

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }

}