package com.curso.android.app.practica.ticsmas.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlayerViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var observer: Observer<Boolean>

    private lateinit var viewModel: PlayerViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = PlayerViewModel()
        viewModel.resultPlayer.observeForever(observer)
    }

    @Test
    fun `test comparePlayers with equal players`() = runBlockingTest {
        // Arrange
        val player1 = "Majixux"
        val player2 = "Majixux"

        // Act
        viewModel.comparePlayers(player1, player2)

        // Assert
        coEvery { observer.onChanged(true) }
    }

    @Test
    fun `test comparePlayers with different players`() = runBlockingTest {
        // Arrange
        val player1 = "Majixux"
        val player2 = "Astin"

        // Act
        viewModel.comparePlayers(player1, player2)

        // Assert
        coEvery { observer.onChanged(false) }
    }
}