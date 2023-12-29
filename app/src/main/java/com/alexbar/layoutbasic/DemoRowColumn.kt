package com.alexbar.layoutbasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListSongs() {
    Column {
        SongItem(
            painter = painterResource(id = R.drawable.album_img_3),
            contentDescription = "Queen Album",
            title = "Love of my life",
            artist = "Queen"
        )
        Spacer(modifier = Modifier.size(16.dp))
        SongItem(
            painter = painterResource(id = R.drawable.album_img_2),
            contentDescription = "Queen Album",
            title = "We Are the Champions",
            artist = "Queen"
        )
        Spacer(modifier = Modifier.size(16.dp))
        SongItem(
            painter = painterResource(id = R.drawable.album_img_2),
            contentDescription = "Queen Album",
            title = "We Will Rock You",
            artist = "Queen"
        )
    }
}

@Composable
fun SongItem(
    painter: Painter,
    contentDescription: String,
    title: String,
    artist: String
) {
    Row {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    FontWeight.ExtraBold
                )
            )
            Text(
                text = artist,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    FontWeight.Medium
                )
            )
        }
        Spacer(modifier = Modifier.size(18.dp))
        Image(
            painter = painterResource(id = R.drawable.ellipsis_icon),
            contentDescription = "option image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(height = 20.dp, width = 20.dp)
        )
    }
}