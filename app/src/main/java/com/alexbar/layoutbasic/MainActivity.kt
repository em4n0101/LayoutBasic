package com.alexbar.layoutbasic

// Android Framework
import android.annotation.SuppressLint
import android.os.Bundle

// Compose Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Compose Foundation
import androidx.compose.foundation.layout.padding

// Compose Material3 Components
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

// Compose UI
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.BackgroundColor
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.LayoutBasicTheme
import com.alexbar.layoutbasic.utils.MusicConstants

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutBasicTheme {
                Scaffold(
                    topBar = {
                        Surface(
                            modifier = Modifier.padding(Dimens.main_activity_top_bar_padding_24),
                            color = BackgroundColor
                        ) {
                            Text(
                                text = MusicConstants.main_activity_top_bar_title,
                                style = TextStyle(
                                    color = Color.DarkGray,
                                    fontSize = Dimens.main_activity_top_bar_font_size_20,
                                    FontWeight.ExtraBold
                                )
                            )
                        }
                    },
                    bottomBar = {
                        BottomBar()
                    },
                    content = {
                        ContentScreen()
                    }
                )
            }
        }
    }
}
