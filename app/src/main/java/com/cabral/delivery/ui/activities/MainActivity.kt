package com.cabral.delivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.cabral.delivery.exampledata.sampleSections
import com.cabral.delivery.ui.screens.HomeScreen
import com.cabral.delivery.ui.theme.DeliveryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            val intent = Intent(this, ProductFormActivity::class.java)
            App(onFabClick = { startActivity(intent) })
        }
    }
}

@Composable
private fun App(onFabClick: () -> Unit = {}) {
    DeliveryTheme {

        // Surface é um container visual que aplica forma, cor de fundo e elevação.
        // Quando usado sem passar a propriedade `color`, como aqui,
        // ele automaticamente usa `MaterialTheme.colorScheme.background`,
        // que foi definido dentro do DeliveryTheme.

        // Isso garante que a tela tenha a cor de fundo correta (claro ou escuro),
        // evitando que o fundo fique transparente ou com aparência incorreta.
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = onFabClick
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    HomeScreen(
                        sampleSections
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun AppPreview() {
    App()
}