package com.alexbar.layoutbasic

// Android Framework

// Compose Activity

// Compose Foundation

// Compose Material3 Components

// Compose UI

// Project-Specific Imports
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.screen.main_list.MoviesScreens
import com.alexbar.layoutbasic.ui.theme.AppBackground

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(AppBackground)) {
                MoviesScreens()
            }
//            ConfirmPaymentScreen()
//            SnakeGame()
//            WelcomeScreen()
//            UserDataTexFields()
//            ConstraintLayoutScreen()
//            DemoConstraintLayout()
//            LayoutBasicTheme {
//                Scaffold(
//                    topBar = {
//                        Surface(
//                            modifier = Modifier.padding(Dimens.main_activity_top_bar_padding_24),
//                            color = BackgroundColor
//                        ) {
//                            Text(
//                                text = MusicConstants.main_activity_top_bar_title,
//                                style = TextStyle(
//                                    color = Color.DarkGray,
//                                    fontSize = Dimens.main_activity_top_bar_font_size_20,
//                                    FontWeight.ExtraBold
//                                )
//                            )
//                        }
//                    },
//                    bottomBar = {
//                        BottomBar()
//                    },
//                    content = {
//                        ContentScreen()
//                    }
//                )
//            }
        }
    }
}
