package org.ucb.appp1.crypto.data.datasource

import org.ucb.appp1.crypto.data.dto.CryptoDto

interface CryptoRemoteDataSource {
    suspend fun getCryptos(): List<CryptoDto>
}