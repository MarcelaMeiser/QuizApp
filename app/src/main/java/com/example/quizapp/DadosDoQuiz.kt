package com.example.quizapp

enum class NivelDificuldade { FACIL, MEDIO, DIFICIL }

data class Pergunta(
    val textoDaPergunta: String,
    val listaDeOpcoes: List<String>,
    val respostaCorreta: String,
    val nivel: NivelDificuldade
)

val listaDeTodasAsPerguntas = listOf(
    // Perguntas nível fácil
    Pergunta(
        textoDaPergunta = "Qual linguagem estamos utilizando no Android Studio?",
        listaDeOpcoes = listOf("Java", "Kotlin", "C++", "Python"),
        respostaCorreta = "Kotlin",
        nivel = NivelDificuldade.FACIL
    ),
    Pergunta(
        textoDaPergunta = "Qual componente usamos para mostrar texto na tela no Compose?",
        listaDeOpcoes = listOf("TextView", "Label", "Text", "String"),
        respostaCorreta = "Text",
        nivel = NivelDificuldade.FACIL
    ),
    Pergunta(
        textoDaPergunta = "Qual componente permite que o usuário digite texto?",
        listaDeOpcoes = listOf("TextField", "EditText", "Input", "TextBox"),
        respostaCorreta = "TextField",
        nivel = NivelDificuldade.FACIL
    ),

    // Perguntas nível médio
    Pergunta(
        textoDaPergunta = "Qual função é frequentemente usada para guardar estado no Compose?",
        listaDeOpcoes = listOf("save", "remember", "store", "keep"),
        respostaCorreta = "remember",
        nivel = NivelDificuldade.MEDIO
    ),
    Pergunta(
        textoDaPergunta = "Qual componente é usado para ações de clique?",
        listaDeOpcoes = listOf("Clicker", "Touchable", "Button", "Action"),
        respostaCorreta = "Button",
        nivel = NivelDificuldade.MEDIO
    ),
    Pergunta(
        textoDaPergunta = "O Jetpack Compose cria interfaces utilizando XML ou código Kotlin?",
        listaDeOpcoes = listOf("XML", "Java", "Kotlin", "HTML"),
        respostaCorreta = "Kotlin",
        nivel = NivelDificuldade.MEDIO
    ),

    // Perguntas nível difícil
    Pergunta(
        textoDaPergunta = "Qual conceito permite que a interface seja atualizada automaticamente quando um valor muda?",
        listaDeOpcoes = listOf("Variável", "Estado", "Constante", "Ciclo de vida"),
        respostaCorreta = "Estado",
        nivel = NivelDificuldade.DIFICIL
    ),
    Pergunta(
        textoDaPergunta = "Qual função é usada para definir a interface principal de uma Activity usando Compose?",
        listaDeOpcoes = listOf("setContentView", "initView", "startCompose", "setContent"),
        respostaCorreta = "setContent",
        nivel = NivelDificuldade.DIFICIL
    ),
    Pergunta(
        textoDaPergunta = "No Compose, a interface é construída a partir de funções chamadas...",
        listaDeOpcoes = listOf("Classes", "Fragments", "Composables", "Activities"),
        respostaCorreta = "Composables",
        nivel = NivelDificuldade.DIFICIL
    )
)