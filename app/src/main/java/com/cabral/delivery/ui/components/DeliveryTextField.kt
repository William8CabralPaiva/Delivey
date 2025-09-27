package com.cabral.delivery.ui.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DeliveryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    type: FieldType = FieldType.NAME
) {
    val config = when (type) {
        FieldType.URL -> FieldConfig(
            keyboardType = KeyboardType.Uri,
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.None,
            minHeight = 0.dp
        )
        FieldType.NAME -> FieldConfig(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.Words,
            minHeight = 0.dp
        )
        FieldType.MONEY -> FieldConfig(
            keyboardType = KeyboardType.Decimal,
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.None,
            minHeight = 0.dp
        )
        FieldType.TEXT_AREA -> FieldConfig(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default,
            capitalization = KeyboardCapitalization.Sentences,
            minHeight = 100.dp
        )
    }

    val finalModifier = if (config.minHeight > 0.dp) {
        modifier.heightIn(min = config.minHeight)
    } else {
        modifier
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = finalModifier,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = config.keyboardType,
            imeAction = config.imeAction,
            capitalization = config.capitalization
        )
    )
}

enum class FieldType {
    URL,
    NAME,
    MONEY,
    TEXT_AREA
}

private data class FieldConfig(
    val keyboardType: KeyboardType,
    val imeAction: ImeAction,
    val capitalization: KeyboardCapitalization,
    val minHeight: Dp
)
