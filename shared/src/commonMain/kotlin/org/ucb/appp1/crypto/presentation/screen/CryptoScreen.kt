package org.ucb.appp1.crypto.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.appp1.crypto.presentation.viewmodel.CryptoEvent
import org.ucb.appp1.crypto.presentation.viewmodel.CryptoViewModel

@Composable
fun CryptoScreen(viewModel: CryptoViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.emitEvent(CryptoEvent.OnLoad)
    }

    Column {
        if (state.value.isLoading) {
            CircularProgressIndicator()
        }

        state.value.error?.let { error ->
            Text(error)
        }

        LazyColumn {
            items(state.value.cryptos) { crypto ->
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("${crypto.name} (${crypto.symbol.uppercase()})")
                    Text("Precio: $${crypto.currentPrice}")
                    Text("Variación 24 h: ${crypto.priceChangePercentage24h}%")
                    Text("Capitalización: $${crypto.marketCap}")
                    Text("Ranking: ${crypto.marketCapRank}")
                    Text("Logo: ${crypto.image}")
                }
            }
        }
    }
}