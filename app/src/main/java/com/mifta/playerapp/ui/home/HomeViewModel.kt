package com.mifta.playerapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mifta.playerapp.domain.Player
import com.mifta.playerapp.repository.PlayerRepository
import com.mifta.playerapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PlayerRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Player>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Player>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllPlayers()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { player ->
                    _uiState.value = UiState.Success(player)
                }
        }
    }

}