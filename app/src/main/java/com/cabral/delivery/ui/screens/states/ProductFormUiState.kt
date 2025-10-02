package com.cabral.delivery.ui.screens.states


data class ProductFormUiState(
    val product: ProductUi = ProductUi(),
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
    val onSaveClick: () -> Unit = {},
)