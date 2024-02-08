package com.alexbar.layoutbasic.screen.confirm_payment.widgets

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
import androidx.compose.ui.graphics.Color
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography
import com.alexbar.layoutbasic.utils.Media
import com.alexbar.layoutbasic.utils.Movie
import com.alexbar.layoutbasic.utils.ShowsConstants

@Composable
fun DisplayMedia(
    mixList: List<List<Media>>,
    onViewAllClicked: (List<Media>) -> Unit
) {
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
                        text = if (mediaList.first() is Movie) ShowsConstants.movies else ShowsConstants.series,
                        style = Typography.displayLarge,
                        color = Color.DarkGray
                    )
                    TextButton(onClick = { onViewAllClicked(mediaList) }) {
                        Text(text = ShowsConstants.see_all)
                    }
                }

                LazyRow {
                    items(mediaList) { media ->
                        MediaComponent(media = media)
                    }
                }
            }
        }
    }
}