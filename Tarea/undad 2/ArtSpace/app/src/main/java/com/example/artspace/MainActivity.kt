package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val artistRes: Int,
    @StringRes val yearRes: Int
)

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork(R.drawable.artwork1, R.string.artwork1_title, R.string.artwork1_artist, R.string.artwork1_year),
        Artwork(R.drawable.artwork2, R.string.artwork2_title, R.string.artwork2_artist, R.string.artwork2_year),
        Artwork(R.drawable.artwork3, R.string.artwork3_title, R.string.artwork3_artist, R.string.artwork3_year),
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(32.dp))


        ArtworkWall(imageRes = currentArtwork.imageRes)

        ArtworkDescriptor(
            titleRes = currentArtwork.titleRes,
            artistRes = currentArtwork.artistRes,
            yearRes = currentArtwork.yearRes
        )

        DisplayController(
            onPrevious = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else artworks.size - 1
            },
            onNext = {
                currentIndex = if (currentIndex < artworks.size - 1) currentIndex + 1 else 0
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ArtworkWall(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .shadow(elevation = 16.dp, shape = RoundedCornerShape(4.dp))
            .padding(32.dp),
        shape = RoundedCornerShape(4.dp),
        tonalElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(32.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes titleRes: Int,
    @StringRes artistRes: Int,
    @StringRes yearRes: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = stringResource(id = artistRes),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = " (${stringResource(id = yearRes)})",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier.width(140.dp)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(
            onClick = onNext,
            modifier = Modifier.width(140.dp)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}