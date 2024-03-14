package com.alexbar.layoutbasic.movies_app.screen.trending

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.networking.RetrofitInstance.mediaService
import com.alexbar.layoutbasic.movies_app.screen.trending.widgets.DisplayMedia
import com.alexbar.layoutbasic.movies_app.screen.trending.widgets.ShowAllMediaGrid

@Composable
fun TrendingMediaScreen(
    favorites: List<Media>,
    onMediaItemSelected: (Media) -> Unit,
    onFavoriteMediaSelected: (Media) -> Unit
) {
    var movieList by remember { mutableStateOf<List<Media>>(emptyList()) }
    var seriesList by remember { mutableStateOf<List<Media>>(emptyList()) }

    LaunchedEffect(Unit) {
        val responseMovies = mediaService.getTrendingMovies()
        val responseSeries = mediaService.getTrendingSeries()

        if (responseMovies.isSuccessful) {
            movieList = responseMovies.body()?.results ?: emptyList()
        } else {
            println("Error")
        }

        if (responseSeries.isSuccessful) {
            seriesList = responseSeries.body()?.results ?: emptyList()
        } else {
            println("Error")
        }
    }

    var showMediaGrid by remember { mutableStateOf(false) }
    var mediaListSelected by remember { mutableStateOf(emptyList<Media>()) }

    if (showMediaGrid) {
        ShowAllMediaGrid(
            mediaList = mediaListSelected,
            onClosedClicked = {showMediaGrid = false}
        )
    } else {
        if (movieList.isNotEmpty() && seriesList.isNotEmpty()) {
            DisplayMedia(
                mixList = listOf(movieList, seriesList),
                onViewAllClicked = {
                    mediaListSelected = it
                    showMediaGrid = true
                },
                onItemSelected = {
                    onMediaItemSelected(it)
                }
            )
        }

    }
}

@Preview
@Composable
fun MoviesScreensPreview() {
    TrendingMediaScreen(
        emptyList(),
        {}
    ) {}
}

