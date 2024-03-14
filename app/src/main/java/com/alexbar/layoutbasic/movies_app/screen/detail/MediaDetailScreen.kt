package com.alexbar.layoutbasic.movies_app.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexbar.layoutbasic.movies_app.screen.detail.widgets.ExpandableSummaryCard
import com.alexbar.layoutbasic.movies_app.screen.detail.widgets.MediaImageWithGradient
import com.alexbar.layoutbasic.movies_app.screen.detail.widgets.MediaInfoText
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.popularity
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
    name: String,
    description: String,
    imageBackdropUrl: String,
    imagePosterUrl: String,
    voteAverage: String,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
//    onFavoritePressed: (Media) -> Unit,
    onBackPressed: () -> Unit
) {
    ConstraintLayout(modifier = modifier
        .fillMaxSize()
        .background(AppBackground)) {

        val (posterImage, backdropImageGradient, title, summary, backButton, info, favoriteButton) = createRefs()

        MediaImageWithGradient(url = imageBackdropUrl, modifier = Modifier
            .fillMaxWidth()
            .height(dimen_250_dp)
            .constrainAs(backdropImageGradient) {})

        val topGuideline = createGuidelineFromTop(0.22f)

        MediaImageWithGradient(url = imagePosterUrl, modifier = Modifier
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
                MediaInfoText(text = voteAverage, style = Typography.labelMedium)
                MediaInfoText(text = popularity, style = Typography.labelSmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                MediaInfoText(
//                    text = if (media.mediaType == media_type_movie) media.releaseDate.formatDate()
//                    else media.firstAirDate.formatDate(),
//                    style = Typography.labelMedium
//                )
//                MediaInfoText(
//                    text = if (media.mediaType == media_type_movie) release_date else first_air_date,
//                    style = Typography.labelSmall
//                )
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
//                .clickable { onFavoritePressed(media) }
                .constrainAs(favoriteButton) {
                    top.linkTo(parent.top, dimen_16_dp)
                    end.linkTo(parent.end, dimen_16_dp)
                }
        )

        Text(
            text = name,
            modifier
                .padding(dimen_8_dp)
                .constrainAs(title) {
                    start.linkTo(posterImage.end)
                    top.linkTo(backdropImageGradient.bottom)
                },
            style = Typography.titleLarge
        )

        ExpandableSummaryCard(
            summary = description,
            modifier.constrainAs(summary) {
                top.linkTo(title.bottom, dimen_100_dp)
            }
        )

    }
}

//@Preview
//@Composable
//fun MediaDetailScreenPreview() {
//    MediaDetailScreen(
//        onBackPressed = {},
//        onFavoritePressed = {},
//        media = Media(
//            name = "",
//            imagePosterUrl = "",
//            title = "Title",
//            description = "Description",
//            firstAirDate = "2024-01-31",
//            voteAverage = 7.214,
//            mediaType = "tv",
//            imageBackdropUrl = "",
//            releaseDate = ""
//        ),
//    )
//}