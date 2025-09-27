package com.cabral.delivery

import androidx.compose.runtime.mutableStateListOf
import com.cabral.delivery.model.Product

class ProductDao {

    companion object {
        // Lista mutável observável pelo Compose
        // ⚠️ Precisa ser mutableStateListOf para que o Compose perceba alterações
        // quando um produto é adicionado, permitindo atualizar a tela anterior automaticamente
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }

}