package com.alexbar.layoutbasic.movies_app.screen.detail.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun MediaInfoText(
    text: String,
    style: TextStyle
) {
    Text(text = text, style = style)
}
