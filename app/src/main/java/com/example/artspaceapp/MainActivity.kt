package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.TintableBackgroundView
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                ) { innerPadding->
                      ArtSpace(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun ArtSpace(modifier: Modifier=Modifier){
    val listOfImage=listOf(R.drawable.r,R.drawable.still_life_of_roses_in_blue_vase_rb_mcgrath)
    val listOfTitle= listOf(R.string.bridge_title,R.string.flower_title)
    val listOfDescription= listOf(R.string.bridge_description,R.string.flower_description)
    val listOfYears= listOf(R.string.bridge_Year,R.string.flower_year)
    var index by remember {
        mutableStateOf(0)
    }
    Column(modifier= Modifier
        .background(Color.White)
        .padding(vertical = 20.dp, horizontal = 10.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(480.dp)
            .background(Color.White)
            .shadow(
                elevation = 10.dp,
                ambientColor = Color.Gray, spotColor = Color.DarkGray
            ),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = listOfImage[index]) ,
                contentDescription ="",
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(400.dp)
            )
        }
        Column(modifier= Modifier
            .padding(top = 100.dp)
            .background(Color.LightGray)
            .width(250.dp)
            .height(80.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = listOfTitle[index]), fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Row (modifier=Modifier.padding(start = 16.dp, top = 2.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = stringResource(id = listOfDescription[index]), modifier = Modifier.padding(end = 3.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text =stringResource(id = listOfYears[index]),
                        fontSize = 14.sp
                    )
            }
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Button(onClick = {index-- },
                modifier= Modifier
                    .width(150.dp)
                    .height(38.dp)
                ) {
                Text(text = "Previus")
            }
            Button(onClick = { index++ } ,
                  modifier= Modifier
                      .width(150.dp)
                      .height(38.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}
@Composable
@Preview
fun ArtSpacePreview(){
    ArtSpace(modifier = Modifier.fillMaxSize())
}