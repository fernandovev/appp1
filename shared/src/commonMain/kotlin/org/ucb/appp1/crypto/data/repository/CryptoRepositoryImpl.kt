package org.ucb.appp1.crypto.data.repository

import org.ucb.appp1.crypto.data.datasource.CryptoRemoteDataSource
import org.ucb.appp1.crypto.data.mapper.toDomain
import org.ucb.appp1.crypto.domain.model.CryptoModel
import org.ucb.appp1.crypto.domain.repository.CryptoRepository

class CryptoRepositoryImpl(
    private val dataSource: CryptoRemoteDataSource
) : CryptoRepository {

    override suspend fun findCryptos(): Result<List<CryptoModel>> {
        return runCatching {
            dataSource.getCryptos().map { it.toDomain() }
        }
    }
}