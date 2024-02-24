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
import com.alexbar.layoutbasic.movies_app.screen.mainTabContent.MainTabContent

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTabContent()

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
