package com.alexbar.layoutbasic.movies_app.screen.detail.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.alexbar.layoutbasic.ui.theme.AppBackground
import com.alexbar.layoutbasic.ui.theme.Dimens

@Composable
fun MediaImageWithGradient(
    url: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        ShowMediaImageGradientBackground(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun ShowMediaImageGradientBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(createMediaVerticalGradient())
    )
}

fun createMediaVerticalGradient(): Brush = Brush.verticalGradient(
    colors = listOf(
        Color.Transparent,
        AppBackground,
    ),
    startY = Dimens.value_300
)