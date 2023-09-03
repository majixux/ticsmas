package com.curso.android.app.practica.ticsmas.model

import com.curso.android.app.practica.ticsmas.R

class PlayerDProvider {
    private val players = arrayListOf<Player>()

    init {
        players.add(Player(name = "player1"))
    }

    fun getPlayers() = players
}