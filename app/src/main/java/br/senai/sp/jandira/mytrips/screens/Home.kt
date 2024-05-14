package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.CategoriaRepository
import br.senai.sp.jandira.mytrips.repository.ViagemRepository
import br.senai.sp.jandira.mytrips.reduzirData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(controleDeNavegacao: NavHostController) {

    val viagens = ViagemRepository().listarTodasAsViagens()
    val categorias = CategoriaRepository().listarTodasAsCategorias()

    var pesquisaState = remember {
        mutableStateOf("")
    }

    Column {
        Surface (
            modifier = Modifier
                .height(200.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.destaque),
                contentDescription = "Paris",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            Column {
                Image(
                    painter = painterResource(id = R.drawable.susana),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .width(61.dp)
                        .height(61.dp)
                        .offset(x = 315.dp, y = 13.dp)
                )

                Text(
                    text = "Susanna Hoffs",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .offset(x = 290.dp, y = 18.dp)


                )

                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "", tint = Color.White,
                    modifier = Modifier
                        .offset(x = 0.dp, y = 64.dp)
                )

                Text(
                    text = "You're in Paris",
                    color = Color.White,
                    modifier = Modifier
                        .offset(x = 25.dp, y = 42.dp)
                )

                Text(
                    text = "My Trips",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .offset(x = 20.dp, y = 38.dp)
                )
            }
        }

        Column {
            Text(
                text = "Categories",
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                color = Color(0xFF565454),
                modifier = Modifier
                    .offset(x = 10.dp, y = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(14.dp))


        LazyRow {
            items(categorias){

                Card (

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .width(140.dp)
                        .offset(x = 10.dp)
                        .padding(horizontal = 6.dp),
                    colors = if (it.habilitado==true) CardDefaults.cardColors(containerColor = Color(0xFFCF06F0))
                    else CardDefaults.cardColors(containerColor = Color(0xFFEAABF4))

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = if (it.imagem==null) painterResource(id = R.drawable.noimage) else it.imagem!!,
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(60.dp)
                                .height(45.dp)
                        )
                        Text(text = it.nome, color = Color.White)
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(4.dp))

        Card (
            elevation = CardDefaults.cardElevation(7.dp),
            shape = RoundedCornerShape(23.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(70.dp)
        ) {
            OutlinedTextField(
                value = pesquisaState.value,
                onValueChange = {
                    pesquisaState.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 7.dp)
                ,
                placeholder = {
                    Text(
                        text = "Search your destiny",
                        color = Color(0xFFA09C9C)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color(0xFFB7B7B7)
                        )

                    }
                },
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent)
            )
        }


        Text(
            text = "Past Trips",
            fontSize = 16.sp,
            color = Color(0xFF565454),
            modifier = Modifier
                .offset(x = 12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))



        LazyColumn{

            items(viagens){
                Card(
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    ){
                        Image(

                            painter = if (it.imagem == null) painterResource(id = R.drawable.noimage)else it.imagem!!,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(120.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text =  "${it.destino}, ${it.dataChegada.year}",
                            color = Color(0xFFCF06F0)
                        )

                        Spacer(modifier = Modifier.height(6.dp))


                        Text(
                            text = "${it.descricao}",
                            fontSize = 12.sp,
                            color = Color(0xFFA09C9C)
                        )

                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(x = -10.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "${reduzirData(it.dataChegada)} - ${reduzirData(it.dataPartida)}",
                                color = Color(0xFFCF06F0),
                                fontSize = 12.sp
                            )
                        }



                    }

                }
            }
        }



    }
}



