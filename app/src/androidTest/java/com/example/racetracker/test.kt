package com.example.racetracker

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario.launch
import com.example.racetracker.ui.RaceParticipant
import com.example.racetracker.ui.RaceTrackerApp
import com.example.racetracker.ui.progressFactor
import com.example.racetracker.ui.theme.RaceTrackerTheme
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test

class test {


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun raceParticipant_RaceFinished_ProgressMatchesMax() = runTest {
        // 1. Arrange: Un corredor con delay de 500ms y meta de 100
        val participant = RaceParticipant(
            name = "Player 1",
            maxProgress = 100,
            progressDelayMillis = 500L,
            progressIncrement = 1
        )

        // 2. Act: Lanzamos la carrera en una corrutina
        // runTest es el "contenedor mágico" que nos permite controlar el tiempo
        val job = launch { participant.run() }

        // Saltamos en el tiempo 50 segundos (500ms * 100 pasos)
        advanceTimeBy(50001L)

        // 3. Assert: Verificamos que el progreso llegó al máximo
        assertEquals(100, participant.currentProgress)
        job.cancel() // Limpiamos la corrutina
    }


    @Test
    fun raceParticipant_AfterReset_ProgressIsZero() {
        val participant = RaceParticipant(name = "Test", initialProgress = 50)
        participant.reset()
        assertEquals(0, participant.currentProgress)
    }

    @Test
    fun raceParticipant_ProgressFactor_CalculatesCorrectly() {
        // 1. Given: Creamos al corredor naciendo ya con 50 de progreso
        val participant = RaceParticipant(
            name = "Test Player",
            maxProgress = 100,
            initialProgress = 50 // Le pasamos el valor inicial aquí
        )

        // 2. When: No hace falta hacer nada porque ya nació con ese valor.

        // 3. Then: Verificamos que la propiedad CALCULADA (la de abajo de todo) funcione.
        // Usamos participant.progressFactor, NO hacemos la cuenta nosotros.
        assertEquals(0.5f, participant.progressFactor)
    }

        // El "ojo" y la "mano" del robot que me olvidé antes (Perdón de nuevo, salame yo)
        @get:Rule
        val composeTestRule = createComposeRule()

        @Test
        fun raceTracker_ClickStart_ChangesButtonText() {
            // 1. Cargar la pantalla dentro del test
            composeTestRule.setContent {
                RaceTrackerTheme {
                    RaceTrackerApp()
                }
            }

            // 2. Verificar que al principio el botón dice "Start"
            // (Usamos el texto que definiste en los recursos o el string directo)
            composeTestRule.onNodeWithText("Start").assertExists()

            // 3. El robot hace CLIC en el botón
            composeTestRule.onNodeWithText("Start").performClick()

            // 4. Verificar que el texto cambió a "Pause"
            composeTestRule.onNodeWithText("Pause").assertExists()
        }
    }

