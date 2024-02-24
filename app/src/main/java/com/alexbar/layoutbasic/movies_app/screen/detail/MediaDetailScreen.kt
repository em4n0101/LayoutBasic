package com.alexbar.layoutbasic.movies_app.screen.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.detail.widgets.ExpandableSummaryCard
import com.alexbar.layoutbasic.movies_app.screen.detail.widgets.MediaImageWithGradient
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.first_air_date
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.media_type_movie
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.popularity
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.release_date
import com.alexbar.layoutbasic.movies_app.utils.formatDate
import com.alexbar.layoutbasic.movies_app.utils.getImageBackdropCompleteUrl
import com.alexbar.layoutbasic.movies_app.utils.getImagePosterCompleteUrl
import com.alexbar.layoutbasic.movies_app.utils.getVoteAverageFormatted
import com.alexbar.layoutbasic.ui.theme.AppBackground
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_100_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_110_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_145_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_20_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_24_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_250_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_30_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_8_dp
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun MediaDetailScreen(
    media: Media,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onFavoritePressed: (Media) -> Unit,
    onBackPressed: () -> Unit
) {
    ConstraintLayout(modifier = modifier
        .fillMaxSize()
        .background(AppBackground)) {

        val (posterImage, backdropImageGradient, title, summary, backButton, info, favoriteButton) = createRefs()

        MediaImageWithGradient(url = media.getImageBackdropCompleteUrl(), modifier = Modifier
            .fillMaxWidth()
            .height(dimen_250_dp)
            .constrainAs(backdropImageGradient) {})

        val topGuideline = createGuidelineFromTop(0.22f)

        MediaImageWithGradient(url = media.getImagePosterCompleteUrl(), modifier = Modifier
            .size(height = dimen_145_dp, width = dimen_110_dp)
            .constrainAs(posterImage) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start, dimen_20_dp)
            }
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
            .fillMaxWidth()
            .constrainAs(info) {
                top.linkTo(posterImage.bottom, dimen_24_dp)
            }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = media.getVoteAverageFormatted(), style = Typography.labelMedium)
                Text(text = popularity, style = Typography.labelSmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text =
                if(media.mediaType == media_type_movie)
                    media.releaseDate.formatDate()
                else media.firstAirDate.formatDate(),
                    style = Typography.labelMedium)
                Text(text =
                if(media.mediaType == media_type_movie)
                    release_date
                else first_air_date, style = Typography.labelSmall)
            }
        }

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(dimen_30_dp)
                .clickable { onBackPressed() }
                .constrainAs(backButton) {
                    top.linkTo(parent.top, dimen_16_dp)
                    start.linkTo(parent.start, dimen_16_dp)
                }
        )

        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(dimen_30_dp)
                .clickable { onFavoritePressed(media) }
                .constrainAs(favoriteButton) {
                    top.linkTo(parent.top, dimen_16_dp)
                    end.linkTo(parent.end, dimen_16_dp)
                }
        )

        Text(
            text = media.title ?: media.name ?: "",
            modifier
                .padding(dimen_8_dp)
                .constrainAs(title) {
                    start.linkTo(posterImage.end)
                    top.linkTo(backdropImageGradient.bottom)
                },
            style = Typography.titleLarge
        )

        ExpandableSummaryCard(
            summary = media.description,
            modifier.constrainAs(summary) {
                top.linkTo(title.bottom, dimen_100_dp)
            }
        )

    }
}

@Preview
@Composable
fun MediaDetailScreenPreview() {
    MediaDetailScreen(
        onBackPressed = {},
        onFavoritePressed = {},
        media = Media(
            imagePosterUrl = "",
            title = "Title",
            description = "Description",
            firstAirDate = "2024-01-31",
            voteAverage = 7.214,
            mediaType = "tv",
            imageBackdropUrl = "",
            releaseDate = ""
        ),
    )
}