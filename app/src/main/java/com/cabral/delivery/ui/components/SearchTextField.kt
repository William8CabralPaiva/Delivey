package com.cabral.delivery.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabral.delivery.ui.theme.DeliveryTheme

@Composable
fun SearchTextField(
    value: String,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    onValueChange: (String) -> Unit = {},
    focus: FocusRequester = FocusRequester(),
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder ={ Text(placeholder)},
        modifier = modifier.focusRequester(focus),
        shape = RoundedCornerShape(50),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Icone Pesquisar",
                modifier = Modifier.padding(start = 4.dp),
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun SearTextFieldPreview() {
    DeliveryTheme {
        Surface {
            SearchTextField("Espetinho", label = "Pesquisar", placeholder = "O que vc procura?")
        }
    }
}

