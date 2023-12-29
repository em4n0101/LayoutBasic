package com.alexbar.layoutbasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayingCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    artist: String,
) {
    Box(modifier = Modifier
        .height(250.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(28.dp))
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Column {
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
                    painter = painterResource(id = R.drawable.play_icon),
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}