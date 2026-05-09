package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        title = stringResource(R.string.jetpack_compose_title),
                        shortText = stringResource(R.string.jetpack_compose_shortText),
                        longText = stringResource(R.string.jetpack_compose_longText),
                        image = painterResource(R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        GreetingImage(
            title = stringResource(R.string.jetpack_compose_title),
            shortText = stringResource(R.string.jetpack_compose_shortText),
            longText = stringResource(R.string.jetpack_compose_longText),
            image = painterResource(R.drawable.bg_compose_background)
        )
    }
}

@Composable
fun GreetingImage(title: String, shortText: String, longText:String, modifier: Modifier = Modifier, image: Painter) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = shortText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            style = LocalTextStyle.current.copy(letterSpacing = TextUnit.Unspecified)
        )
        Text(
            text = longText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp),
            style = LocalTextStyle.current.copy(letterSpacing = TextUnit.Unspecified)
        )
    }

}