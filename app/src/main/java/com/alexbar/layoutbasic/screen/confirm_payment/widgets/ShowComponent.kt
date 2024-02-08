package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alexbar.layoutbasic.createVerticalGradient
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_12_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_180_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_250_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_8_dp
import com.alexbar.layoutbasic.utils.Media
import com.alexbar.layoutbasic.utils.Movie
import com.alexbar.layoutbasic.utils.ShowsConstants.base_url
import com.alexbar.layoutbasic.utils.TVSeries

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
        var text = ""
        var imgUrl = ""

        if (media is Movie) {
            text = media.title
            imgUrl = media.imageUrl
        } else if (media is TVSeries) {
            text = media.name
            imgUrl = media.imageUrl
        }

        Box(
            modifier = Modifier.fillMaxSize()
            ) {
            AsyncImage(
                model = "$base_url$imgUrl",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            ShowCardGradientBackground()
            Text(
                text = text,
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomCenter).padding(8.dp),
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
        Movie(
            title = "Title",
            description = "Description",
            imageUrl = "",
            firstAirDate = "",
            voteAverage = 0.0
        )
    )
}

