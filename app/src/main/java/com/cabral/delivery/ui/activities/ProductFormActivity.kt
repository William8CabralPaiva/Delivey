package com.cabral.delivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.cabral.delivery.exampledata.sampleSections
import com.cabral.delivery.ui.screens.HomeScreen
import com.cabral.delivery.ui.screens.ProductFormScreen
import com.cabral.delivery.ui.theme.DeliveryTheme

class ProductFormActivity : ComponentActivity() {

    //private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }
    }

}