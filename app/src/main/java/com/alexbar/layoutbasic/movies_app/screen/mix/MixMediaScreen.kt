package com.alexbar.layoutbasic.movies_app.screen.mix

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.mix.widgets.MixMediaItem
import com.alexbar.layoutbasic.ui.theme.AppBackground
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_4_dp

@Composable
fun MixMediaScreen(listMedia: List<Media>) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppBackground)
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            contentPadding = PaddingValues(dimen_4_dp),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(dimen_4_dp),
            verticalItemSpacing = dimen_4_dp
        ) {
            items(listMedia.shuffled()) { media ->
                MixMediaItem(media = media)
            }
        }
    }
}
