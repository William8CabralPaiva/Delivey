package com.cabral.delivery

import com.cabral.delivery.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {
    companion object {
        // Lista mutável observável pelo Compose
        // ⚠️ Precisa ser mutableStateListOf para que o Compose perceba alterações
        // quando um produto é adicionado, permitindo atualizar a tela anterior automaticamente
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products(): StateFlow<List<Product>> = products.asStateFlow()

    fun save(product: Product) {
        products.value = products.value + product

    }

}