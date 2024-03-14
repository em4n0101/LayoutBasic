package com.alexbar.layoutbasic.movies_app.screen.trending.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.media_type_movie
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun DisplayMedia(
    mixList: List<List<Media>>,
    onViewAllClicked: (List<Media>) -> Unit,
    onItemSelected: (Media) -> Unit
) {
    if (mixList.isNotEmpty()) {
        LazyColumn {
            items(mixList) {mediaList ->
                Column(modifier = Modifier
                    .padding(vertical = Dimens.dimen_24_dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.dimen_16_dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (mediaList.first().mediaType == media_type_movie)
                                MovieConstants.movies
                            else MovieConstants.series,
                            style = Typography.labelMedium
                        )
                        TextButton(onClick = { onViewAllClicked(mediaList) }) {
                            Text(text = MovieConstants.see_all)
                        }
                    }

                    LazyRow {
                        items(mediaList) { media ->
                            MediaComponent(
                                media = media,
                                modifier = Modifier.clickable { onItemSelected(media) }
                            )
                        }
                    }
                }
            }
        }
    }
}