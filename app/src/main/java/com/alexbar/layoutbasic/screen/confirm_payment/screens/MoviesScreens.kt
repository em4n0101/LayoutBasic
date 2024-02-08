package com.alexbar.layoutbasic.screen.confirm_payment.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.DisplayMedia
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.ShowAllMediaGrid
import com.alexbar.layoutbasic.utils.Media
import com.alexbar.layoutbasic.utils.movieList
import com.alexbar.layoutbasic.utils.tvSeriesList

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MoviesScreens() {
    val context = LocalContext.current
    val movieList = movieList(context)
    val tvSeriesList = tvSeriesList(context)
    var showMediaGrid by remember { mutableStateOf(false) }
    var mediaListSelected by remember { mutableStateOf(emptyList<Media>()) }
    
    if (showMediaGrid) {
        ShowAllMediaGrid(
            mediaList = mediaListSelected,
            onClosedClicked = {showMediaGrid = false}
        )
    } else {
        DisplayMedia(
            mixList = listOf(movieList, tvSeriesList),
            onViewAllClicked = {
                mediaListSelected = it
                showMediaGrid = true
            }
        )
    }
}

@Preview
@Composable
fun MoviesScreensPreview() {
    MoviesScreens()
}

