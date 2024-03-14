package com.alexbar.layoutbasic.movies_app.screen.favorites.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.movies_app.utils.getImagePosterCompleteUrl
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.media_type_movie_text
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.media_type_tv_series_text
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun FavoriteMediaItem(
    media: Media,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        AsyncImage(
            model = media.getImagePosterCompleteUrl(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.dimen_145_dp)
                .padding(Dimens.dimen_16_dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = media.title ?: media.name ?: "",
                style = Typography.titleLarge
            )
            Text(
                text = if (media.mediaType == MovieConstants.media_type_movie) media_type_movie_text
                    else media_type_tv_series_text,
                style = Typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
fun FavoriteMediaItemPreview() {
    FavoriteMediaItem(
        media = Media(
            imagePosterUrl = "",
            title = "Mr. & Mrs. Smith",
            description = "Description",
            firstAirDate = "2024-01-31",
            voteAverage = 7.214,
            mediaType = "tv",
            imageBackdropUrl = "",
            releaseDate = ""
        )
    )
}