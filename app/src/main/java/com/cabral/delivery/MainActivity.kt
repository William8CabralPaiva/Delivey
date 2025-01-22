package com.cabral.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.core.view.WindowCompat
import com.cabral.delivery.model.Product
import com.cabral.delivery.ui.components.ProductItem
import com.cabral.delivery.ui.screens.HomeScreen
import com.cabral.delivery.ui.theme.DeliveryTheme
import com.cabral.delivery.ui.theme.Purple500
import com.cabral.delivery.ui.theme.Teal200
import com.cabral.delivery.utils.extesions.toBrCurrency
import java.math.BigDecimal

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
private fun App(){
    DeliveryTheme {
        Surface {
            HomeScreen()
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




