package com.mifta.playerapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mifta.playerapp.repository.PlayerRepository
import com.mifta.playerapp.ui.detail.DetailPlayerViewModel
import com.mifta.playerapp.ui.home.HomeViewModel

class ViewModelFactory(private val repository: PlayerRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailPlayerViewModel::class.java)) {
            return DetailPlayerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}