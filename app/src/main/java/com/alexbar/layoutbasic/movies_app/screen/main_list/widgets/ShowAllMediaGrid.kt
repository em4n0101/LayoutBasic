package com.alexbar.layoutbasic.movies_app.screen.main_list.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_150_dp

@Composable
fun ShowAllMediaGrid(
    mediaList: List<Media>,
    onClosedClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = null,
            modifier = Modifier
                .padding(Dimens.dimen_16_dp)
                .size(Dimens.dimen_24_dp)
                .clickable { onClosedClicked() }
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(dimen_150_dp),
            contentPadding = PaddingValues(
                start = Dimens.dimen_12_dp,
                top = Dimens.dimen_16_dp,
                end = Dimens.dimen_12_dp,
                bottom = Dimens.dimen_16_dp
            ),
            content = {
                items(mediaList) { media ->
                    MediaComponent(media = media)
                }
            }
        )
    }

}