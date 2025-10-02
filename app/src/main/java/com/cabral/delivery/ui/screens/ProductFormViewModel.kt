package com.cabral.delivery.ui.screens

import androidx.lifecycle.ViewModel
import com.cabral.delivery.ui.screens.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )

    val uiState get() = _uiState.asStateFlow()

    private val formatter = DecimalFormat("#.##")


    init {
        _uiState.update { currentState ->

            currentState.copy(
                onUrlChange = {
                    _uiState.value =
                        _uiState.value.copy(product = _uiState.value.product.copy(url = it))
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        product = _uiState.value.product.copy(name = it)
                    )
                },
                onPriceChange = {
                    val price = formatter.format(BigDecimal(it))

                    price?.let {
                        _uiState.value =
                            _uiState.value.copy(product = _uiState.value.product.copy(price = it))
                    }

                },
                onDescriptionChange = {
                    _uiState.value =
                        _uiState.value.copy(product = _uiState.value.product.copy(description = it))
                }
            )


        }
    }
}