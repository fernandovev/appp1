package org.ucb.appp1.crypto.domain.usecase

import org.ucb.appp1.crypto.domain.model.CryptoModel
import org.ucb.appp1.crypto.domain.repository.CryptoRepository

class FindCryptosUseCase(
    private val repository: CryptoRepository
) {
    suspend fun invoke(): Result<List<CryptoModel>> {
        return repository.findCryptos()
    }
}