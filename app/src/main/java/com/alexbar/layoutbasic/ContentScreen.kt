package com.alexbar.layoutbasic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alexbar.layoutbasic.ui.theme.BackgroundColor

@Composable
fun ContentScreen() {
    val painter = painterResource(id = R.drawable.album_img)
    val contentDescription = "Queen Album"
    val title = "Bohemian Rhapsody"
    val artist = "Queen"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(100.dp))
            PlayingCard(
                painter = painter,
                contentDescription = contentDescription,
                title = title,
                artist = artist
            )
            Spacer(modifier = Modifier.height(36.dp))
            Box(modifier = Modifier.padding(24.dp)) {
                ListSongs()
            }
            Spacer(modifier = Modifier.weight(1f))
            PlayerComponent(
                painter = painter,
                contentDescription = contentDescription,
                title = title,
                artist = artist
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}