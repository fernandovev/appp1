package org.ucb.appp1.crypto.domain.repository

import org.ucb.appp1.crypto.domain.model.CryptoModel

interface CryptoRepository {
    suspend fun findCryptos(): Result<List<CryptoModel>>
}