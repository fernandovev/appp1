package org.ucb.appp1.crypto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ucb.appp1.crypto.domain.usecase.FindCryptosUseCase

class CryptoViewModel(
    private val findCryptosUseCase: FindCryptosUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CryptoState())
    val state = _state.asStateFlow()

    fun emitEvent(event: CryptoEvent) {
        when (event) {
            CryptoEvent.OnLoad -> {
                viewModelScope.launch {
                    _state.update { it.copy(isLoading = true, error = null) }

                    findCryptosUseCase.invoke().fold(
                        onSuccess = { cryptos ->
                            _state.update {
                                it.copy(cryptos = cryptos, isLoading = false)
                            }
                        },
                        onFailure = { exception ->
                            _state.update {
                                it.copy(
                                    error = exception.message ?: "No se pudieron cargar las criptomonedas",
                                    isLoading = false
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}