package com.example.happybirthday

import android.os.Bundle
import android.widget.ImageSwitcher
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
//                    GreetingImage(stringResource(R.string.happy_day_text),
//                        stringResource(R.string.signature_text)
//                    )
                    ImageSwitcherScreen()
                }
                }
            }
        }
    }


@Composable
fun ImageSwitcherScreen(){
    val images = listOf(R.drawable.androidparty, R.drawable._311459)
    var currentImageIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // для смены изображения
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth())
        {
            Button(onClick = {

                    currentImageIndex = (currentImageIndex - 1 )
                }
            ) {
                Text("Назад")
            }

            Button(
                onClick = {

                    currentImageIndex = (currentImageIndex + 1)
                }
            ) {
                Text("Далее")
            }
        }
        //для отображения текущего изображения
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = "Displayed Image",
            modifier = Modifier
                .border(2.dp, Color.Gray)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )

    }
}


@Composable
fun GreetingText(message: String = stringResource(R.string.happy_day_text) , from: String = stringResource(R.string.signature_text), modifier: Modifier = Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            color = Color.DarkGray,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,

        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier =Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box (modifier){
        Image( // ПОРЯДОК ВАЖЕН!!!
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.6F
        )
        GreetingText(// Вызываем функцию с текстом
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
  //  GreetingImage(stringResource(R.string.happy_day_text) , stringResource(R.string.signature_text))
        ImageSwitcherScreen()
    }
}