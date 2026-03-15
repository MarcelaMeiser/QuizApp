package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaQuiz(
    nivelEscolhido: NivelDificuldade,
    aoFinalizarQuiz: (pontuacaoFinal: Int, totalDePerguntas: Int) -> Unit
) {
    // Filtra pelo nível e embaralha as perguntas uma única vez [cite: 140, 169, 174]
    val perguntasFiltradas = remember {
        listaDeTodasAsPerguntas.filter { it.nivel == nivelEscolhido }.shuffled()
    }

    var indiceAtual by remember { mutableIntStateOf(0) }
    var pontuacao by remember { mutableIntStateOf(0) }
    var opcaoSelecionada by remember { mutableStateOf("") }
    var jaRespondeu by remember { mutableStateOf(false) }

    val perguntaAtual = perguntasFiltradas[indiceAtual]

    // Embaralha as opções da pergunta atual [cite: 175]
    val opcoesEmbaralhadas = remember(perguntaAtual) {
        perguntaAtual.listaDeOpcoes.shuffled()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Nível: ${nivelEscolhido.name}", fontSize = 18.sp)
        Text(text = "Pergunta ${indiceAtual + 1} de ${perguntasFiltradas.size}", fontSize = 18.sp)
        Text(text = "Pontuação: $pontuacao", fontSize = 18.sp, modifier = Modifier.padding(bottom = 24.dp))

        Text(text = perguntaAtual.textoDaPergunta, fontSize = 22.sp, modifier = Modifier.padding(bottom = 24.dp))

        opcoesEmbaralhadas.forEach { opcao ->
            val corFundo = if (jaRespondeu) {
                when {
                    opcao == perguntaAtual.respostaCorreta -> Color.Green.copy(alpha = 0.3f) // [cite: 176]
                    opcao == opcaoSelecionada -> Color.Red.copy(alpha = 0.3f) // [cite: 176]
                    else -> Color.Transparent
                }
            } else {
                Color.Transparent
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().background(corFundo).padding(8.dp)
            ) {
                RadioButton(
                    selected = opcao == opcaoSelecionada,
                    onClick = { if (!jaRespondeu) opcaoSelecionada = opcao },
                    enabled = !jaRespondeu
                )
                Text(text = opcao, fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (!jaRespondeu) {
            Button(
                onClick = {
                    jaRespondeu = true
                    if (opcaoSelecionada == perguntaAtual.respostaCorreta) {
                        pontuacao++
                    }
                },
                enabled = opcaoSelecionada.isNotEmpty() // Impede avançar sem responder [cite: 177]
            ) {
                Text(text = "Confirmar", fontSize = 20.sp)
            }
        } else {
            Button(
                onClick = {
                    if (indiceAtual < perguntasFiltradas.size - 1) {
                        indiceAtual++
                        opcaoSelecionada = ""
                        jaRespondeu = false
                    } else {
                        aoFinalizarQuiz(pontuacao, perguntasFiltradas.size)
                    }
                }
            ) {
                val textoBotao = if (indiceAtual < perguntasFiltradas.size - 1) "Próxima Pergunta" else "Finalizar Quiz"
                Text(text = textoBotao, fontSize = 20.sp)
            }
        }
    }
}