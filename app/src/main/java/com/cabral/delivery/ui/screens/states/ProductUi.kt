package com.cabral.delivery.ui.screens.states

data class ProductUi(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
){
    // executa sempre que chama a classe
    val isShowPreview: Boolean = url.isNotBlank()
}