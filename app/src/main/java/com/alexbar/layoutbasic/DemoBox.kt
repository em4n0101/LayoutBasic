package com.alexbar.layoutbasic

// Compose Foundation
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

// Compose Material3 Components
import androidx.compose.material3.Text

// Compose Runtime
import androidx.compose.runtime.Composable

// Compose UI
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

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.Dimens

@Composable
fun PlayingCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    artist: String,
) {
    Box(modifier = Modifier
        .height(Dimens.playing_card_height)
        .width(Dimens.playing_card_width)
        .clip(RoundedCornerShape(Dimens.playing_card_corner_shape))
    ) {
        PlayingCardImage(
            painter = painter,
            contentDescription = contentDescription
        )
        PlayingCardGradientBackground()
        PlayingCardContent(
            title = title,
            artist = artist,
            contentDescription = contentDescription
        )
    }
}
@Composable
fun PlayingCardImage(
    painter: Painter,
    contentDescription: String
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PlayingCardGradientBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(createVerticalGradient())
    )
}

fun createVerticalGradient(): Brush = Brush.verticalGradient(
    colors = listOf(
        Color.Transparent,
        Color.Black
    ),
    startY = Dimens.playing_card_gradient_start_y
)

@Composable
fun PlayingCardContent(
    title: String,
    artist: String,
    contentDescription: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.playing_card_content_box_padding_16),
        contentAlignment = Alignment.BottomStart
    ) {
        Row {
            CardTexts(title = title, artist = artist)
            Spacer(modifier = Modifier.size(Dimens.playing_card_content_spacer_18))
            PlayIcon(
                painter =  painterResource(id = R.drawable.play_icon),
                contentDescription = contentDescription
            )
        }
    }
}

@Composable
fun CardTexts(title: String, artist: String) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                color = Color.White,
                fontSize = Dimens.playing_card_content_font_size_14,
                FontWeight.ExtraBold
            )
        )
        Text(
            text = artist,
            style = TextStyle(
                color = Color.White,
                fontSize = Dimens.playing_card_content_font_size_12,
                FontWeight.Medium
            )
        )
    }
}

@Composable
fun PlayIcon(painter: Painter, contentDescription: String) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop
    )
}
