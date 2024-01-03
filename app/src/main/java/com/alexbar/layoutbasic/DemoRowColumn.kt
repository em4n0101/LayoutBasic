package com.alexbar.layoutbasic

// Compose Foundation
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

// Compose Material3 Components
import androidx.compose.material3.Text

// Compose Runtime
import androidx.compose.runtime.Composable

// Compose UI
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
fun ListSongs() {
    Column {
        SongItem(
            painter = painterResource(id = R.drawable.album_img_3),
            contentDescription = MusicConstants.song_1_content_description,
            title = MusicConstants.song_1_title,
            artist = MusicConstants.song_1_artist
        )
        Spacer(modifier = Modifier.size(Dimens.list_songs_spacer_16))
        SongItem(
            painter = painterResource(id = R.drawable.album_img_2),
            contentDescription = MusicConstants.song_2_content_description,
            title = MusicConstants.song_2_title,
            artist = MusicConstants.song_2_artist
        )
        Spacer(modifier = Modifier.size(Dimens.list_songs_spacer_16))
        SongItem(
            painter = painterResource(id = R.drawable.album_img_2),
            contentDescription = MusicConstants.song_3_content_description,
            title = MusicConstants.song_3_title,
            artist = MusicConstants.song_3_artist
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
        SongItemImage(
            painter = painter,
            contentDescription = contentDescription
        )
        Column(
            modifier = Modifier
                .weight(Dimens.list_songs_item_weight_1)
                .padding(horizontal = Dimens.list_songs_item_padding_horizontal_16, vertical = Dimens.list_songs_item_padding_vertical_8),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = Dimens.list_songs_item_font_size_14,
                    FontWeight.ExtraBold
                )
            )
            Text(
                text = artist,
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = Dimens.list_songs_item_font_size_12,
                    FontWeight.Medium
                )
            )
        }
        Spacer(modifier = Modifier.size(Dimens.list_songs_item_spacer_18))
        SongItemMoreIcon()
    }
}

@Composable
fun SongItemImage(painter: Painter, contentDescription: String) {
    Box(
        modifier = Modifier
            .size(Dimens.list_songs_item_image_size_50)
            .clip(RoundedCornerShape(Dimens.list_songs_item_image_corner_shape))
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SongItemMoreIcon() {
    Image(
        painter = painterResource(id = R.drawable.ellipsis_icon),
        contentDescription = MusicConstants.song_item_more_icon_content_description,
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(Dimens.list_songs_item_more_icon_size)
    )
}