package org.ucb.appp1.crypto.presentation.viewmodel

import org.ucb.appp1.crypto.domain.model.CryptoModel

data class CryptoState(
    val cryptos: List<CryptoModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)