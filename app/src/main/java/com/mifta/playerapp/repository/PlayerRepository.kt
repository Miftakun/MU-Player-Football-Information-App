package com.mifta.playerapp.repository

import com.mifta.playerapp.domain.FakePlayerData
import com.mifta.playerapp.domain.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PlayerRepository {

    private val dataPlayers = mutableListOf<Player>()

    init {
        if (dataPlayers.isEmpty()) {
            FakePlayerData.dummyPlayer.forEach {
                dataPlayers.add(it)
            }
        }
    }

    fun getAllPlayers(): Flow<List<Player>> {
        return flowOf(dataPlayers)
    }

    fun getPlayerId(playerId: Int): Player {
        return dataPlayers.first {
            it.id == playerId
        }
    }


    companion object {
        @Volatile
        private var instance: PlayerRepository? = null

        fun getInstance(): PlayerRepository =
            instance ?: synchronized(this) {
                PlayerRepository().apply {
                    instance = this
                }
            }
    }
}