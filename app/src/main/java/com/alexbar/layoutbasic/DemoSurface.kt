package com.alexbar.layoutbasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun PlayerComponent(
    painter: Painter,
    contentDescription: String,
    title: String,
    artist: String
) {
    Surface(
        color = Color.DarkGray,
        shape = CircleShape,
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Red)
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                modifier = Modifier.weight(1f).padding(16.dp),
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
            Spacer(modifier = Modifier.size(8.dp))
            Image(
                painter = painterResource(id = R.drawable.heart_icon),
                contentDescription = "favorite image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(height = 35.dp, width = 35.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Image(
                painter = painterResource(id = R.drawable.pause_icon),
                contentDescription = "pause image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(height = 35.dp, width = 35.dp)
            )
        }
    }
}

@Composable
fun BottomBar() {
    Surface(
        color = Color.White,
        shape = CircleShape
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.house_icon),
                contentDescription = "contentDescription",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "contentDescription",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.file_icon),
                contentDescription = "contentDescription",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "contentDescription",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
        }
    }
}