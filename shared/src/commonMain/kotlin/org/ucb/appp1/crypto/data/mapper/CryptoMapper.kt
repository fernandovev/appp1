package org.ucb.appp1.crypto.data.mapper

import org.ucb.appp1.crypto.data.dto.CryptoDto
import org.ucb.appp1.crypto.domain.model.CryptoModel

fun CryptoDto.toDomain(): CryptoModel = CryptoModel(
    name = name,
    symbol = symbol,
    image = image,
    currentPrice = currentPrice,
    priceChangePercentage24h = priceChangePercentage24h ?: 0.0,
    marketCap = marketCap,
    marketCapRank = marketCapRank ?: 0
)