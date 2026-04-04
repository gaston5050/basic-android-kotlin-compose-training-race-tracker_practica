package com.example.racetracker

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.racetracker.ui.RaceTrackerApp
import org.junit.Rule
import org.junit.Test

//import org.junit.jupiter.api.Assertions.*

class RaceTrackerAppTest {

    // habilito que se pueda ejecutar el test (
    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun raceTrackerCambioBoton(){
        //cargo la pantalla dentro del test
        composeRule.setContent{
            RaceTrackerApp()
        }

        //Chequeo si la pantalla contiene el texto "Start"
        composeRule.onNodeWithText("Start").performClick()

        // 4. Verificar que el texto cambió a "Pause"
        composeRule.onNodeWithText("Pause").assertExists()

    }


}