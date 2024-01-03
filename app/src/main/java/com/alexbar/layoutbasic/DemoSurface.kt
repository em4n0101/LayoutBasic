package com.alexbar.layoutbasic

// Compose Foundation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

// Compose Material3 Components
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

// Compose Runtime
import androidx.compose.runtime.Composable

// Compose UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.utils.MusicConstants

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.player_component_padding_horizontal_24, vertical = Dimens.player_component_padding_vertical_16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlayerComponentAlbumImage(painter = painter, contentDescription = contentDescription)
            Column(
                modifier = Modifier
                    .weight(Dimens.player_component_weight_1)
                    .padding(Dimens.player_component_spacer_16),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = Dimens.player_component_font_size_14,
                        FontWeight.ExtraBold
                    )
                )
                Text(
                    text = artist,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = Dimens.player_component_font_size_12,
                        FontWeight.Medium
                    )
                )
            }
            Spacer(modifier = Modifier.size(Dimens.player_component_spacer_8))
            PlayerComponentIcon(R.drawable.heart_icon, MusicConstants.player_component_favorite_icon_content_description)
            Spacer(modifier = Modifier.size(Dimens.player_component_spacer_16))
            PlayerComponentIcon(R.drawable.pause_icon, MusicConstants.player_component_pause_icon_content_description)
        }
    }
}

@Composable
fun PlayerComponentAlbumImage(
    painter: Painter,
    contentDescription: String
) {
    Box(modifier = Modifier
        .size(Dimens.player_component_album_size_50)
        .clip(CircleShape)
        .background(Color.Red)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun PlayerComponentIcon(
    imageId: Int,
    contentDescription: String
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(Dimens.player_component_icon_size_35)
    )
}

@Composable
fun BottomBar() {
    Surface(
        modifier = Modifier.height(Dimens.bottom_bar_height_80),
        color = Color.White,
        shape = CircleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.bottom_bar_padding_16),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val icons = listOf(R.drawable.house_icon, R.drawable.search_icon, R.drawable.file_icon, R.drawable.user_icon)
            icons.forEach { icon ->
                BottomBarItem(iconId = icon)
            }
        }
    }
}

@Composable
fun BottomBarItem(iconId: Int) {
    Image(
        painter = painterResource(id = iconId),
        contentDescription = MusicConstants.bottom_bar_icon_content_description,
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(Dimens.bottom_bar_item_size_20)
    )
}
