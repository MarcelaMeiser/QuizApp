package com.example.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaInicial(aoClicarEmIniciar: (NivelDificuldade) -> Unit) {
    var nivelSelecionado by remember { mutableStateOf(NivelDificuldade.FACIL) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Quiz Android", fontSize = 32.sp, modifier = Modifier.padding(bottom = 32.dp))

        Text(text = "Selecione a dificuldade:", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = nivelSelecionado == NivelDificuldade.FACIL,
                onClick = { nivelSelecionado = NivelDificuldade.FACIL }
            )
            Text(text = "Fácil", fontSize = 18.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = nivelSelecionado == NivelDificuldade.MEDIO,
                onClick = { nivelSelecionado = NivelDificuldade.MEDIO }
            )
            Text(text = "Médio", fontSize = 18.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = nivelSelecionado == NivelDificuldade.DIFICIL,
                onClick = { nivelSelecionado = NivelDificuldade.DIFICIL }
            )
            Text(text = "Difícil", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { aoClicarEmIniciar(nivelSelecionado) }) {
            Text(text = "Iniciar Quiz", fontSize = 20.sp)
        }
    }
}