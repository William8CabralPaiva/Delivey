package com.cabral.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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


//@Preview(showBackground = true)
//@Composable
//fun VerticalPreview() {
//    Surface(
//        modifier = Modifier.padding(8.dp),
//        shape = RoundedCornerShape(15.dp),
//        tonalElevation = 4.dp
//    ) {
//        Column {
//            Box(
//                Modifier
//                    .height(300.dp)
//                    .width(100.dp)
//                    .background(
//                        brush = Brush.horizontalGradient(
//                            colors = listOf(
//                                Purple500, Teal200
//                            )
//                        )
//                    )
//            )
//        }
//
//    }
//}




