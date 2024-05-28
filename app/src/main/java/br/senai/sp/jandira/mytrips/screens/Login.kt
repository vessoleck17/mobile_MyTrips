package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.UsuarioRepositorio
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme



@Composable
fun TelaLogin(controleDeNavegacao: NavHostController) {

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var erroState = remember {
        mutableStateOf(false)
    }

    var messageErrorState = remember {
        mutableStateOf("")
    }

    var contaRepository = UsuarioRepositorio(LocalContext.current)

    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()) {
        Row (horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .height(40.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(bottomStart = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFA81DCE))
            ){}
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            Text(
                text = "Login",
                color = Color(0xFFA81DCE),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 55.sp


            )
            Text(
                text = "Please sign in to continue.",
                color = Color(0xFF777677),
                fontSize = 14.sp,

                )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                                emailState.value = it
                },
                label =  {
                    Text(text = "E-mail")
                },
                shape = RoundedCornerShape(13.dp),
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 20.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xFFA81DCE),
                        unfocusedBorderColor = Color(0xFFA81DCE)
                    ),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(20.dp)
                            .width(22.dp)
                    )
                }

            )

            OutlinedTextField(
                value = senhaState.value,
                onValueChange = {
                                senhaState.value = it
                },
                label = {
                    Text(text = "Password")
                },
                modifier = Modifier
                    .fillMaxWidth(),

                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xFFA81DCE),
                        unfocusedBorderColor = Color(0xFFA81DCE)
                    ),
                shape = RoundedCornerShape(13.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.senha),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(24.dp)
                            .width(22.dp)
                    )
                }

            )

            Row (
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth() .padding(top = 20.dp )){
                Text(text = messageErrorState.value,
                    color = Color.Red)
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFA81DCE)),
                    onClick = {
                        val email = emailState.value
                        val senha = senhaState.value
                        if(contaRepository.verificacao(email, senha)){
                            controleDeNavegacao.navigate("home")
                        }else{
                            erroState.value = true
                            messageErrorState.value = "Usuário ou senha incorretos!"
                        }
                    }) {
                    Text(
                        text = "SIGN IN",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(7.dp, 0.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                    )

                }
            }
            Row (horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp)
            ){
                Text(text = "Don't have an account?", fontWeight = FontWeight.ExtraLight)
                Text(
                    text = "Sign in",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFA81DCE),
                    modifier = Modifier.clickable {
                        controleDeNavegacao.navigate("sign")
                    }
                )
            }




        }

        Row (
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .height(40.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(topEnd = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFA81DCE))
            ){}
        }





    }
}
@Preview()
@Composable
fun TelaLoginPreview() {
    MyTripsTheme {
    }
}