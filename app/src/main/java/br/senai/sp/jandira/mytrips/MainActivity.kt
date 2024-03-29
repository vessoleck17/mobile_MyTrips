package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaLogin()
                    TelaSignUp()
                }
            }
        }
    }
}

@Composable
fun TelaLogin() {
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
                value = "teste@email.com",
                onValueChange = {},
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
                value = "**********",
                onValueChange = {},
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

            Row (horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = (Color(0xFFA81DCE))),
                    modifier = Modifier
                        .padding(0.dp, 25.dp)
                        .width(150.dp)
                        .height(50.dp)
                ) {
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
                    color = Color(0xFFA81DCE)
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

@Composable
fun TelaSignUp() {
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
                    value = "Susanna Hoffs",
                    onValueChange = {},
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
                    value = "99999-0987",
                    onValueChange = {},
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
                    value = "susanna@email.com",
                    onValueChange = {},
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
                    value = "*********",
                    onValueChange = {},
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
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFFA81DCE),
                        checkedColor = Color(0xFFA81DCE)

                    )
                )
                Text(text = "Over 18?" )
            }

            Button(
                onClick = { /*TODO*/ },
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
                Text(text = "Already have an account?", fontWeight = FontWeight.ExtraLight)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {
        TelaLogin()
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun TelaSignUpPreview() {
    MyTripsTheme {
        TelaSignUp()
    }
}