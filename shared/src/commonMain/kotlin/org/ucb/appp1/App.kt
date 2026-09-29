package org.ucb.appp1

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.appp1.crypto.presentation.screen.CryptoScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        CryptoScreen()
    }
}