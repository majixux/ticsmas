package com.curso.android.app.practica.ticsmas.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.ticsmas.R
import com.curso.android.app.practica.ticsmas.viewModel.PlayerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PlayerViewModel

    // Declaración de variables
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var btnComparar: Button
    private lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)


        // Inicialización de variables
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        btnComparar = findViewById(R.id.btnComparar)
        resultTextView = findViewById(R.id.resultTextView)

        btnComparar.setOnClickListener {
            val player1 = editText1.text.toString()
            val player2 = editText2.text.toString()
            viewModel.comparePlayers(player1, player2)
        }

        viewModel.resultPlayer.observe(this) { areEqual ->
            if (areEqual) {
                resultTextView.text = "No podes jugar contra vos! Ingresa otro jugador."
            } else {
                resultTextView.text = "Jugadores ingresados correctamente."
            }
        }
    }
}