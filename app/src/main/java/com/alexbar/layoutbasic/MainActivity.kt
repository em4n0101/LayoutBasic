package com.alexbar.layoutbasic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexbar.layoutbasic.ui.theme.BackgroundColor
import com.alexbar.layoutbasic.ui.theme.LayoutBasicTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutBasicTheme {
                Scaffold(
                    topBar = {
                        Surface(
                            modifier = Modifier.padding(24.dp),
                            color = BackgroundColor
                        ) {
                            Text(
                                text = "DISCOVER",
                                style = TextStyle(
                                    color = Color.DarkGray,
                                    fontSize = 20.sp,
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
