package com.alexbar.layoutbasic.movies_app.screen.trending

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.detail.MediaDetailScreen
import com.alexbar.layoutbasic.movies_app.screen.trending.widgets.DisplayMedia
import com.alexbar.layoutbasic.movies_app.screen.trending.widgets.ShowAllMediaGrid

@Composable
fun TrendingMediaScreen(
    movieList: List<Media>,
    seriesList: List<Media>,
    favorites: List<Media>,
    onFavoriteMediaSelected: (Media) -> Unit
) {
    var showMediaGrid by remember { mutableStateOf(false) }
    var mediaListSelected by remember { mutableStateOf(emptyList<Media>()) }
    var mediaSelected by remember { mutableStateOf<Media?>(null) }

    if (showMediaGrid) {
        ShowAllMediaGrid(
            mediaList = mediaListSelected,
            onClosedClicked = {showMediaGrid = false}
        )
    } else {
        DisplayMedia(
            mixList = listOf(movieList, seriesList),
            onViewAllClicked = {
                mediaListSelected = it
                showMediaGrid = true
            },
            onItemSelected = {
                mediaSelected = it
            }
        )
    }

    if (mediaSelected != null)  {
        MediaDetailScreen(
            media = mediaSelected!!,
            isFavorite = favorites.contains(mediaSelected!!),
            onFavoritePressed = onFavoriteMediaSelected
        ) {
            mediaSelected = null
        }
    }
}

@Preview
@Composable
fun MoviesScreensPreview() {
    TrendingMediaScreen(
        emptyList(),
        emptyList(),
        emptyList()
    ) {}
}

