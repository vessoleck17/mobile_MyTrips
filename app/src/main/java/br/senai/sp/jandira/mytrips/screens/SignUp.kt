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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import br.senai.sp.jandira.mytrips.model.Usuario
import br.senai.sp.jandira.mytrips.repository.UsuarioRepositorio
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable

fun TelaSignUp(controleDeNavegacao: NavHostController) {

    var usernameState = remember{
        mutableStateOf("")
    }
    var emailState = remember{
        mutableStateOf("")
    }

    var phoneState = remember{
        mutableStateOf("")
    }

    var passwordState = remember{
        mutableStateOf("")
    }

    var mais18State = remember{
        mutableStateOf(false)
    }


    var cr = UsuarioRepositorio(LocalContext.current)

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .height(40.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(bottomStart = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFA81DCE))
            ) {}
        }

        Column (modifier = Modifier
            .fillMaxWidth())
        {
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp))
            {
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = "Sign Up",
                    color = Color(0xFFA81DCE),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 35.sp

                )
                Text(
                    text = "Create a new account",
                    color = Color(0xFF777677),
                    fontSize = 17.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(0.dp, 23.dp)
                        .width(80.dp)
                        .height(80.dp)
                )
                OutlinedTextField(
                    value = usernameState.value,
                    onValueChange = {
                                    usernameState.value = it
                    },
                    label = {
                        Text(text = "Username")
                    },
                    modifier = Modifier
                        .padding(0.dp, 7.dp)
                        .fillMaxWidth(),

                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xFFA81DCE),
                            unfocusedBorderColor = Color(0xFFA81DCE)
                        ),
                    shape = RoundedCornerShape(13.dp),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(24.dp)
                                .width(22.dp)
                        )
                    }

                )
                OutlinedTextField(
                    value = phoneState.value,
                    onValueChange = {
                                    phoneState.value = it
                    },
                    label = {
                        Text(text = "Phone")
                    },
                    modifier = Modifier
                        .padding(0.dp, 7.dp)
                        .fillMaxWidth(),

                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xFFA81DCE),
                            unfocusedBorderColor = Color(0xFFA81DCE)
                        ),
                    shape = RoundedCornerShape(13.dp),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }

                )

                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                                    emailState.value = it
                    },
                    label = {
                        Text(text = "E-mail")
                    },
                    modifier = Modifier
                        .padding(0.dp, 7.dp)
                        .fillMaxWidth(),

                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xFFA81DCE),
                            unfocusedBorderColor = Color(0xFFA81DCE)
                        ),
                    shape = RoundedCornerShape(13.dp),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(24.dp)
                                .width(22.dp)
                        )
                    }

                )

                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = {

                                    passwordState.value = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    modifier = Modifier
                        .padding(0.dp, 7.dp)
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

            }
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(7.dp,0.dp)) {
                Checkbox(
                    checked = mais18State.value,
                    onCheckedChange = {
                                      mais18State.value = it
                    },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFFA81DCE),
                        checkedColor = Color(0xFFA81DCE)

                    )
                )
                Text(text = "Over 18?" )
            }

            Button(
                onClick = {
                          val usuario = Usuario(
                              username = usernameState.value,
                              email = emailState.value,
                              password = passwordState.value,
                              phone = phoneState.value,
                              mais18 = mais18State.value
                          )

                    cr.salvar(usuario)
                    controleDeNavegacao.navigate("login")
                          },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(13.dp, 0.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFA81DCE))
            ) {
                Text(
                    text = "CREATE ACCOUNT",
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Row (horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp, 20.dp)
            ){
                Text(text = "Already have an account?",
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.clickable {
                        controleDeNavegacao.navigate("login")
                    }
                )
                Text(
                    text = "Sign in",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFA81DCE)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .height(40.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(topEnd = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFA81DCE))
            ) {
            }
        }
    }
}

@Preview()
@Composable
fun TelaSignUpPreview() {
    MyTripsTheme {
    }
}