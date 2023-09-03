package com.curso.android.app.practica.ticsmas.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel: ViewModel() {
    private val _resultPlayer = MutableLiveData<Boolean>()
    val resultPlayer: LiveData<Boolean> = _resultPlayer

    fun comparePlayers(player1: String, player2: String) {
        _resultPlayer.value = player1 == player2
    }

}