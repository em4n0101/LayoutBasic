package com.alexbar.layoutbasic.movies_app.screen.main_list

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.detail.MediaDetailScreen
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.movies_file
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.tv_series_file
import com.alexbar.layoutbasic.movies_app.utils.getListFromJsonAsset
import com.alexbar.layoutbasic.movies_app.screen.main_list.widgets.DisplayMedia
import com.alexbar.layoutbasic.movies_app.screen.main_list.widgets.ShowAllMediaGrid

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MoviesScreens() {
    val context = LocalContext.current
    val movieList: List<Media> = context.getListFromJsonAsset(movies_file) ?: emptyList()
    val seriesList: List<Media> = context.getListFromJsonAsset(tv_series_file) ?: emptyList()

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
        MediaDetailScreen(media = mediaSelected!!) {
            mediaSelected = null
        }
    }
}

@Preview
@Composable
fun MoviesScreensPreview() {
    MoviesScreens()
}

