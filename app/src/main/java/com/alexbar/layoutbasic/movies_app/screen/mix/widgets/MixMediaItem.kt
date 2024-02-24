package com.alexbar.layoutbasic.movies_app.screen.mix.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.movies_app.utils.getImageBackdropCompleteUrl
import com.alexbar.layoutbasic.movies_app.utils.getImagePosterCompleteUrl
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_100_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_10_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_180_dp

@Composable
fun MixMediaItem(media: Media) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(if (media.mediaType == MovieConstants.media_type_movie) dimen_180_dp else dimen_100_dp)
        .clip(RoundedCornerShape(dimen_10_dp))
    ) {
        AsyncImage(
            model = if (media.mediaType == MovieConstants.media_type_movie) media.getImagePosterCompleteUrl()
                    else media.getImageBackdropCompleteUrl(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}