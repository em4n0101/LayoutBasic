package com.alexbar.layoutbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alexbar.layoutbasic.ui.theme.LayoutBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutBasicTheme {
                val painter = painterResource(id = R.drawable.album_img)
                val contentDescription = "Queen Album"
                val title = "Bohemian Rhapsody"
                val artist = "Queen"

                Box(modifier = Modifier.padding(16.dp)) {
                    PlayingCard(
                        painter = painter,
                        contentDescription = contentDescription,
                        title = title,
                        artist = artist
                    )
                }
            }
        }
    }
}
