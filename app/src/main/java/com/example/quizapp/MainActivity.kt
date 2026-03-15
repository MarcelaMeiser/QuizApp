package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.quizapp.ui.theme.QuizAppTheme

// Enum para controlar em qual tela o usuário está
enum class TelaAtual {
    INICIAL, QUIZ, FINAL
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppQuiz()
                }
            }
        }
    }
}

@Composable
fun AppQuiz() {
    // Variáveis de estado pra controlar a navegação e os dados do jogo
    var telaAtual by remember { mutableStateOf(TelaAtual.INICIAL) }
    var nivelSelecionado by remember { mutableStateOf(NivelDificuldade.FACIL) }
    var pontuacaoFinal by remember { mutableIntStateOf(0) }
    var totalDePerguntas by remember { mutableIntStateOf(0) }

    // Qual tela é exibida com base no estado 'telaAtual'
    when (telaAtual) {
        TelaAtual.INICIAL -> {
            TelaInicial(
                aoClicarEmIniciar = { nivel ->
                    nivelSelecionado = nivel
                    telaAtual = TelaAtual.QUIZ
                }
            )
        }
        TelaAtual.QUIZ -> {
            TelaQuiz(
                nivelEscolhido = nivelSelecionado,
                aoFinalizarQuiz = { pontuacao, total ->
                    pontuacaoFinal = pontuacao
                    totalDePerguntas = total
                    telaAtual = TelaAtual.FINAL
                }
            )
        }
        TelaAtual.FINAL -> {
            TelaFinal(
                pontuacaoFinal = pontuacaoFinal,
                totalDePerguntas = totalDePerguntas,
                aoReiniciarQuiz = {
                    telaAtual = TelaAtual.INICIAL
                }
            )
        }
    }
}