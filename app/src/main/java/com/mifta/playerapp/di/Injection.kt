package com.mifta.playerapp.di

import com.mifta.playerapp.repository.PlayerRepository

object Injection {

    fun provideRepository(): PlayerRepository {
        return PlayerRepository.getInstance()
    }

}