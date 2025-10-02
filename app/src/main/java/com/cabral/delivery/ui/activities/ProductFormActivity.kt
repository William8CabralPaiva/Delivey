package com.cabral.delivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.cabral.delivery.ProductDao
import com.cabral.delivery.ui.screens.ProductFormScreen
import com.cabral.delivery.ui.screens.ProductFormViewModel
import com.cabral.delivery.ui.theme.DeliveryTheme

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                Surface {
                    val viewModel: ProductFormViewModel by viewModels()
                    ProductFormScreen(
                        viewModel = viewModel,
                        onSaveClick = { product ->
                            dao.save(product)
                            finish()
                        })
                }
            }
        }
    }

}