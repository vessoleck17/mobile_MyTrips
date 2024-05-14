package br.senai.sp.jandira.mytrips.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categoria

class CategoriaRepository {

    @Composable
    fun listarTodasAsCategorias(): List<Categoria> {
// Dados das categorias
        val montanha= Categoria()
        montanha.id = 1
        montanha.nome = "Montain"
        montanha.habilitado = true
        montanha.imagem = painterResource(id = R.drawable.montain)

        val neve = Categoria()
        neve.id = 2
        neve.nome = "Snow"
        neve.habilitado = false
        neve.imagem = painterResource(id = R.drawable.ski)

        val praia = Categoria()
        praia.id = 3
        praia.nome = "Beach"
        praia.habilitado = false
        praia.imagem = painterResource(id = R.drawable.beach)

        return listOf(montanha, neve, praia)

    }
}