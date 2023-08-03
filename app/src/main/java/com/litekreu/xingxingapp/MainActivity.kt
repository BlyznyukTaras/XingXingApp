package com.litekreu.xingxingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.litekreu.xingxingapp.ui.theme.XingXingAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XingXingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    XingXingMain()
                }
            }
        }
    }
}

val random = Random

@Composable
fun XingXingMain(modifier: Modifier = Modifier) {
    var mainText by remember { mutableStateOf("1") }
    var clicks by remember { mutableStateOf(0) }
    Box(contentAlignment = Alignment.Center) {
       Column(horizontalAlignment = Alignment.CenterHorizontally) {
           Text(
               text = mainText,
               fontSize = 120.sp,
               fontStyle = FontStyle.Italic
           )
           Button(onClick = { mainText = getRandomNum(); clicks++ }) {
               Text(text = "Click it!", color = Color.White, fontSize = 20.sp)
           }
       }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
    ) {
        Text(
            text = "Clicks' amount: $clicks",
            fontSize = 24.sp,
            modifier = modifier.padding(bottom = 20.dp)
        )
    }
}

fun getRandomNum(): String = "${random.nextInt(10)}"

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XingXingAppTheme {
        XingXingMain()
    }
}