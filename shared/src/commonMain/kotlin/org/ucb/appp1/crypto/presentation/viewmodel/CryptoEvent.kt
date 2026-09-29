package org.ucb.appp1.crypto.presentation.viewmodel

sealed interface CryptoEvent {
    data object OnLoad : CryptoEvent
}