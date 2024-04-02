package br.senai.sp.jandira.mytrips.screens

import android.content.ClipData.Item
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun TelaHome() {
    Column {
        Surface (
            modifier = Modifier
                .height(300.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.destaque),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()

            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.susana),
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                )

                Text(
                    text = "Susanna Hoffs",
                    color = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Column (
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .padding(15.dp)
            ){
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn ,
                        contentDescription = "",
                        tint = Color.White

                    )
                    Text(
                        text = "You're in Paris",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Text(
                    text = "My Trips",
                    fontSize = 33.sp,
                    fontWeight = FontWeight.W900,
                    color = Color.White
                )

            }
        }

        Text(
            text = "Categories",
            color = Color.Gray,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
        )

        LazyRow(){
            items (3){
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(vertical = 8.dp),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color(0x889c27b0)
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(listOf(Color.White, Color.Magenta))
                    )
                ){

                }


            }

        }




    }

}

@Preview()
@Composable
fun TelaHomePreview() {
    MyTripsTheme {
        TelaHome()

    }

}