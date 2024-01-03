package com.alexbar.layoutbasic

// Compose Foundation Layouts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

// Compose Material3 Components
import androidx.compose.material3.Surface

// Compose Runtime
import androidx.compose.runtime.Composable

// Compose UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.BackgroundColor
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.utils.MusicConstants

@Composable
fun ContentScreen() {
    val painter = painterResource(id = R.drawable.album_img)
    val contentDescription = MusicConstants.song_1_content_description
    val title = MusicConstants.song_1_title
    val artist = MusicConstants.song_1_artist

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(Dimens.content_screen_spacer_height_100))
            PlayingCard(
                painter = painter,
                contentDescription = contentDescription,
                title = title,
                artist = artist
            )
            Spacer(modifier = Modifier.height(Dimens.content_screen_spacer_height_36))
            Box(modifier = Modifier.padding(Dimens.content_screen_box_padding_24)) {
                ListSongs()
            }
            Spacer(modifier = Modifier.weight(Dimens.content_screen_spacer_weight_1))
            PlayerComponent(
                painter = painter,
                contentDescription = contentDescription,
                title = title,
                artist = artist
            )
            Spacer(modifier = Modifier.height(Dimens.content_screen_spacer_height_80))
        }
    }
}