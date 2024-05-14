package br.senai.sp.jandira.mytrips.repository


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Viagem
import java.time.LocalDate

class ViagemRepository {




    @Composable
    fun listarTodasAsViagens(): List<Viagem> {

        // Criando objeto
        val londres = Viagem()
        londres.id = 1
        londres.destino = "Londres"
        londres.descricao = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        londres.dataChegada = LocalDate.of(2019,2,18)
        londres.dataPartida = LocalDate.of(2019,2,21)
        // Como nao tenho ainda a imagem coloca null
        londres.imagem = painterResource(id = R.drawable.london)  // tiver dando erro passa o mouse em cima e add composable

        val porto = Viagem()
        porto.id = 2
        porto.destino = "Porto"
        porto.descricao = "Porto é uma cidade costeira no noroeste de Portugal conhecida pelas pontes imponentes e pela produção de vinho do Porto. No distrito medieval de Ribeira, às margens do rio, ruas estreitas de paralelepípedos passam pelas casas e pelos restaurantes dos comerciantes"
        porto.dataChegada = LocalDate.of(2022,11,3)
        porto.dataPartida = LocalDate.of(2022,11,12)
        // Como nao tenho ainda a imagem coloca null
        porto.imagem = painterResource(id = R.drawable.porto)

        val saoPaulo = Viagem()
        saoPaulo.id = 3
        saoPaulo.destino = "São Paulo"
        saoPaulo.descricao = "São Paulo, centro financeiro do Brasil, está entre as cidades mais populosas do mundo, com diversas instituições culturais e uma rica tradição arquitetônica."
        saoPaulo.dataChegada = LocalDate.of(2023,11,10)
        saoPaulo.dataPartida = LocalDate.of(2023,11,20)
        // Como nao tenho ainda a imagem coloca null
        saoPaulo.imagem = painterResource(id = R.drawable.saopaulo)



        val recife = Viagem()
        recife.id = 4
        recife.destino = "Recife"
        recife.descricao = "Recife, a capital do estado de Pernambuco, no nordeste do Brasil, distingue-se pelos seus vários rios, pontes, ilhéus e penínsulas. Recife Antigo, na própria ilha junto ao porto, é o centro histórico da cidade antiga que data do século XVI."
        recife.dataChegada = LocalDate.of(2020,12,20)
        recife.dataPartida = LocalDate.of(2020,12,26)
        recife.imagem = painterResource(id = R.drawable.recifee)


        val rioGrandeDoNorte = Viagem()
        rioGrandeDoNorte.id = 5
        rioGrandeDoNorte.destino = "Rio Grande do Norte"
        rioGrandeDoNorte.descricao = "Rio Grande do Norte é um estado na extremidade nordeste do Brasil. A capital, Natal, fica numa costa repleta de praias onde se encontra o Forte dos Reis Magos, em forma de estrela, um forte português do século XVI. "
        rioGrandeDoNorte.dataChegada = LocalDate.of(2022,5,20)
        rioGrandeDoNorte.dataPartida = LocalDate.of(2022,5,26)
        rioGrandeDoNorte.imagem = null






        return listOf(londres, porto, saoPaulo, recife, rioGrandeDoNorte)

    }


}