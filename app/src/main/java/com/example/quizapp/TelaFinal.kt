package com.example.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun TelaFinal(
    pontuacaoFinal: Int,
    totalDePerguntas: Int,
    aoReiniciarQuiz: () -> Unit
) {
    // Calculamos a porcentagem de acertos
    val porcentagem = if (totalDePerguntas > 0) {
        ((pontuacaoFinal.toFloat() / totalDePerguntas) * 100).roundToInt()
    } else {
        0
    }

    // Definimos a mensagem final baseada no desempenho
    val mensagemFinal = if (porcentagem >= 70) {
        "Parabéns!"
    } else {
        "Tente novamente!"
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Fim do Quiz!", fontSize = 32.sp, modifier = Modifier.padding(bottom = 16.dp))

        Text(text = mensagemFinal, fontSize = 24.sp, modifier = Modifier.padding(bottom = 32.dp))

        Text(text = "Sua pontuação: $pontuacaoFinal de $totalDePerguntas", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))

        Text(text = "Acertos: $porcentagem%", fontSize = 20.sp, modifier = Modifier.padding(bottom = 32.dp))

        Button(onClick = { aoReiniciarQuiz() }) {
            Text(text = "Reiniciar Quiz", fontSize = 20.sp)
        }
    }
}