package com.alexbar.layoutbasic.movies_app.screen.trending.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.alexbar.layoutbasic.createVerticalGradient
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.utils.getImagePosterCompleteUrl
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.media_type_movie
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_12_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_180_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_250_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_8_dp
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun MediaComponent(
    media: Media,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimen_12_dp
        ),
        modifier = modifier
            .size(
                width = dimen_180_dp,
                height = dimen_250_dp
            )
            .padding(dimen_8_dp)
    ) {
        val text = if (media.mediaType == media_type_movie) media.title else media.name

        Box(
            modifier = Modifier.fillMaxSize()
            ) {
            AsyncImage(
                model = media.getImagePosterCompleteUrl(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            ShowCardGradientBackground()
            Text(
                text = text ?: "",
                modifier = Modifier.align(Alignment.BottomCenter).padding(dimen_8_dp),
                style = Typography.labelMedium
            )
        }
    }
}

@Composable
fun ShowCardGradientBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(createVerticalGradient())
    )
}

@Preview
@Composable
fun ShowComponentPreview() {
    MediaComponent(
        Media(
            imagePosterUrl = "",
            title = "Title",
            description = "Description",
            firstAirDate = "",
            voteAverage = 0.0,
            mediaType = "tv",
            imageBackdropUrl = "",
            releaseDate = ""
        )
    )
}

