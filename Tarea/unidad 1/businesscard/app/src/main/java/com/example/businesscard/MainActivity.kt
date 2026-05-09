package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Presentation()
                }
            }
        }
    }
}

@Composable
fun CardPresentation(imagen: Painter,name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xFF073042))
                .size(120.dp)
                .padding(8.dp)
            )
        Text(
            text = name,
            fontSize = 50.sp,
            color = Color(0xFF07190C),
            modifier = Modifier
                .padding(top = 12.dp, bottom = 4.dp)

            )
        Text(
            text = title,
            color = Color(0xFF006C3A),
            fontWeight = FontWeight.Bold,


        )
    }

}

@Composable
fun CardContact() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(bottom = 48.dp)
    ) {
        CardDataContact(
            icon = painterResource(R.drawable.contact_phone_24dp_e3e3e3),
            data = "123-456-7890"
        )
        CardDataContact(
            icon = painterResource(R.drawable.add_link_24dp_e3e3e3),
            data = "@AndoidDev"
        )
        CardDataContact(
            icon = painterResource(R.drawable.attach_email_24dp_e3e3e3),
            data = "join.Dev@gmail.com",
            modifier = Modifier.padding(bottom = 0.dp)
        )
    }
}


@Composable
fun CardDataContact(icon: Painter,data :String, modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFF08884E))
        )
        Text(
            text = data,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }

}
@Composable
fun Presentation() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.weight(1f))
        CardPresentation(
            imagen = painterResource(R.drawable.android_logo),
            name = "Oscar JAJ",
            title = "Engineer TIC's "
        )
        Spacer(modifier = Modifier.weight(1f))
        CardContact()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Presentation()
    }
}