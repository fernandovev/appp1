package org.ucb.appp1.crypto.domain.model

data class CryptoModel(
    val name: String,
    val symbol: String,
    val image: String,
    val currentPrice: Double,
    val priceChangePercentage24h: Double,
    val marketCap: Long,
    val marketCapRank: Int
)