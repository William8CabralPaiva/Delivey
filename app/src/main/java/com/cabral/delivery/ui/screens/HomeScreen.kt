package com.cabral.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabral.delivery.exampledata.sampleProducts
import com.cabral.delivery.exampledata.sampleSections
import com.cabral.delivery.ui.components.CardProductItem
import com.cabral.delivery.ui.components.ProductsSection
import com.cabral.delivery.ui.components.SearchTextField
import com.cabral.delivery.ui.screens.states.HomeScreenUiState
import com.cabral.delivery.ui.theme.DeliveryTheme

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
    focusRequester: FocusRequester = FocusRequester(),
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts

        SearchTextField(
            value = text,
            label = "Pesquisar",
            placeholder = "O que vc procura?",
            focus = focusRequester,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = state.onSearchChange
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
) {

    val state by viewModel.uiState.collectAsState()
    // usar mutable stateof só quando precisar reconstruir algo na tela
    val focus = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focus.requestFocus()
    }

    HomeScreen(state = state, focusRequester = focus)
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    DeliveryTheme {
        Surface {
            HomeScreen(
                HomeScreenUiState(
                    sections = sampleSections,
                    searchedProducts = sampleProducts,
                )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreviewExpanded() {
    DeliveryTheme {
        Surface {
            HomeScreen(
                HomeScreenUiState(
                    sections = sampleSections,
                    searchedProducts = sampleProducts,
                    searchText = "a"
                )
            )
        }
    }
}