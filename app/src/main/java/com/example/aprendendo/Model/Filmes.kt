package com.example.aprendendo.Model

import com.example.aprendendo.R
// vetor de imagens
data class Filmes(
    //componentes do card
    val capaFilmes: Int // pois so possuimos a capa do filme
)
class FilmesBuider{ // classe de execução
    var capa_Filme: Int = 0
    fun build(): Filmes = Filmes(capa_Filme)
}
fun filmes(block: FilmesBuider.()->Unit): Filmes = FilmesBuider().apply(block).build()

fun addFilmes(): MutableList<Filmes> = mutableListOf(
    filmes {
        capa_Filme =R.drawable.filme1
    },
    filmes {
        capa_Filme =R.drawable.filme2
    },
    filmes {
        capa_Filme =R.drawable.filme3
    },
    filmes {
        capa_Filme =R.drawable.filme4
    },
    filmes {
        capa_Filme =R.drawable.filme5
    },
    filmes {
        capa_Filme =R.drawable.filme6
    },
    filmes {
        capa_Filme =R.drawable.filme7
    },
    filmes {
        capa_Filme =R.drawable.filme8
    },
    filmes {
        capa_Filme =R.drawable.filme9
    },
    filmes {
        capa_Filme =R.drawable.filme10
    },
    filmes {
        capa_Filme =R.drawable.filme11
    },
    filmes {
        capa_Filme =R.drawable.filme12
    },
)

