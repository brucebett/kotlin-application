package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.ui.theme.ApllicationTheme
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplicationTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize() ){ innerPadding ->
                    Greeting(
                        name = "Alvin",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var firstName by remember {
        mutableStateOf(value = "")
    }
    var lastName by remember {
        mutableStateOf(value = "")
    }
    var emailAddress by remember {
        mutableStateOf(value = "")
    }

    Column(
        modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center


    ){
        Text(text = "GoodMorning $name",
            fontSize = 20.sp,
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .fillMaxWidth()


        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .height(80.dp),
            painter = painterResource(id = R.drawable.car), contentDescription =" lorem")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier= Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label =  { Text(text = "Enter First Name")},
            placeholder = { Text(text = "Please Enter First Name")},
            value = firstName,
            onValueChange ={
                    newName -> firstName = newName
            } )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label ={ Text(text = "Enter Last Name")} ,
            placeholder = {Text(text = "Please Enter Last Name")},
            value =lastName,
            onValueChange ={
                    newLastName -> lastName = newLastName
            } )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label ={ Text(text = "Enter Email Address")} ,
            placeholder = {Text(text = "Please Enter Email Address")},
            value =emailAddress,
            onValueChange ={
                    newEmail -> emailAddress = newEmail
            } )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ } ,
        colors = ButtonDefaults.buttonColors(Color.Green),
        modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "FORGET PASSWORD"
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApplicationTheme {
        Greeting("Alvin")
    }
}