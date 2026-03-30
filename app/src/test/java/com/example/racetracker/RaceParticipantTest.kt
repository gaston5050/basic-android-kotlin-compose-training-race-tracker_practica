/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.racetracker

import com.example.racetracker.ui.RaceParticipant
import com.example.racetracker.ui.progressFactor
import org.junit.Assert.assertEquals
import org.junit.Test

class RaceParticipantTest {
    private val raceParticipant = RaceParticipant(
        name = "Test",
        maxProgress = 100,
        progressDelayMillis = 500L,
        initialProgress = 0,
        progressIncrement = 1
    )

    @Test
    fun raceParticipant_Reset_ProgressReturnsToZero() {
        // 1. Preparación (Given): Creamos al corredor y le damos progreso
        val participant = RaceParticipant(name = "Test Player", maxProgress = 100)

        // Simulamos que avanzó (acá podrías tocar el currentProgress si no fuera private set,
        // pero como es private, vamos a confiar en que la clase inicia o cambia)
        // Por ahora, vamos a probar directamente la función reset.

        // 2. Acción (When): Ejecutamos lo que queremos probar
       participant.reset()

        // 3. Verificación (Then): El "Assert" (Afirmación)
        // assertEquals(valor_esperado, valor_real)
        assertEquals(0, participant.currentProgress)
    }

    @Test
    fun raceParticipant_ProgressFactor() {
        // 1. Preparación (Given): Creamos al corredor y le damos progreso
        val participant = RaceParticipant(name = "Test Player", maxProgress = 100, initialProgress = 50)




        assertEquals(0.5f, participant.currentProgress/participant.maxProgress.toFloat())
    }


}
