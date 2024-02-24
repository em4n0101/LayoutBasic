package com.alexbar.layoutbasic.movies_app.screen.mainTabContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.favorites.FavoritesMediaScreen
import com.alexbar.layoutbasic.movies_app.screen.mainTabContent.widgets.AppTabBar
import com.alexbar.layoutbasic.movies_app.screen.mix.MixMediaScreen
import com.alexbar.layoutbasic.movies_app.screen.trending.TrendingMediaScreen
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.movies_app.utils.getListFromJsonAsset
import com.alexbar.layoutbasic.ui.theme.AppBackground

@Composable
fun MainTabContent() {
    val context = LocalContext.current
    var showTrending by remember { mutableStateOf(true) }
    var showFavorites by remember { mutableStateOf(false) }
    var showMix by remember { mutableStateOf(false) }
    val movieList: List<Media> = context.getListFromJsonAsset(MovieConstants.movies_file) ?: emptyList()
    val seriesList: List<Media> = context.getListFromJsonAsset(MovieConstants.tv_series_file) ?: emptyList()
    var favoritesMedia by remember { mutableStateOf(listOf<Media>()) }

    Column (modifier = Modifier.fillMaxSize()) {
        AppTabBar { selectedIndex ->
            when (selectedIndex) {
                0 -> {
                    showTrending = true
                    showFavorites = false
                    showMix = false
                }
                1 -> {
                    showTrending = false
                    showFavorites = true
                    showMix = false
                }
                2 -> {
                    showTrending = false
                    showFavorites = false
                    showMix = true
                }
            }
        }

        if (showTrending) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(AppBackground)
            ) {
                TrendingMediaScreen(
                    movieList = movieList,
                    seriesList = seriesList,
                    favorites = favoritesMedia
                ) {
                    favoritesMedia = if (favoritesMedia.contains(it))
                        favoritesMedia.toMutableList().apply { remove(it) }
                    else
                        favoritesMedia.toMutableList().apply { add(it) }

                }
            }
        }
        if (showFavorites) {
            FavoritesMediaScreen(favorites = favoritesMedia){
                favoritesMedia = favoritesMedia.toMutableList().apply { remove(it) }
            }
        }
        if (showMix) {
            MixMediaScreen(listMedia = seriesList + movieList)
        }
    }
}

@Preview
@Composable
fun MainTabContentPreview() {
    MainTabContent()
}