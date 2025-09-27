package com.cabral.delivery.ui.activies

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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            App()
        }
    }
}

@Composable
private fun App() {
    DeliveryTheme {

        // Surface é um container visual que aplica forma, cor de fundo e elevação.
        // Quando usado sem passar a propriedade `color`, como aqui,
        // ele automaticamente usa `MaterialTheme.colorScheme.background`,
        // que foi definido dentro do DeliveryTheme.

        // Isso garante que a tela tenha a cor de fundo correta (claro ou escuro),
        // evitando que o fundo fique transparente ou com aparência incorreta.
        Surface {
            HomeScreen(sampleSections)
        }
    }
}