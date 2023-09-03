package com.curso.android.app.practica.ticsmas.view

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.ticsmas.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompararJugadores() {
        // Ingresar nombres de jugadores en los EditText
        onView(withId(R.id.editText1)).perform(typeText("Jugador1"))
        onView(withId(R.id.editText2)).perform(typeText("Jugador2"))

        // clic botón "Comparar"
        onView(withId(R.id.btnComparar)).perform(click())

        // Verificar que el resultado se muestre
        onView(withId(R.id.resultTextView)).check(matches(withText("Jugadores ingresados correctamente.")))
    }
}
