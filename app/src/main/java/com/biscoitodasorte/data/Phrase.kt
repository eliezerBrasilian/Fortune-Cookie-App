package com.biscoitodasorte.data

import java.util.Random

data class Phrase(val id:Int, val content:String, val author:String)

class Phrases {
    private val phrasesList = listOf<Phrase>(
        Phrase( 1, "Acredite em si mesmo. Você é mais forte do que pensa.", "Autor desconhecido"),
        Phrase( 2, "Todo dia é uma nova oportunidade para mudar sua vida.", "Autor desconhecido"),
        Phrase( 3, "O segredo para se dar bem na vida é começar a acreditar que você pode.", "Autor desconhecido"),
        Phrase( 4, "Você é capaz de coisas incríveis. Acredite em si mesmo.", "Autor desconhecido"),
        Phrase( 5, "Lembre-se: você é mais forte do que imagina.", "Autor desconhecido"),
        Phrase( 6, "O futuro pertence àqueles que acreditam na beleza de seus sonhos.", "Eleanor Roosevelt"),
        Phrase( 7, "Nunca é tarde demais para ser o que você poderia ter sido.", "George Eliot"),
        Phrase( 8, "Cada pequeno passo nos leva mais perto de nossos sonhos.", "Autor desconhecido"),
        Phrase( 9, "A vida é cheia de possibilidades esperando para serem descobertas.", "Autor desconhecido"),
        Phrase( 10, "Não importa quão devagar você vá, desde que você não pare.", "Confúcio"),
        Phrase( 11, "Seja corajoso o suficiente para seguir seu coração e sua intuição.", "Steve Jobs"),
        Phrase( 12, "O sucesso é a soma de pequenos esforços repetidos dia após dia.", "Robert Collier"),
    )

    fun getRandomPhrase(): Phrase {
        val random = Random()
        val randomIndex = random.nextInt(this.phrasesList.size)
        val randomPhrase = phrasesList[randomIndex]

        return randomPhrase;
    }
}