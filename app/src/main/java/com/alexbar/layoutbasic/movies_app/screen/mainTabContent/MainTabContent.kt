package com.alexbar.layoutbasic.movies_app.screen.mainTabContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

enum class Tab { Trending, Favorites, Mix }

@Composable
fun MainTabContent(
    onMediaItemSelected: (Media) -> Unit
) {
    val context = LocalContext.current
    val movieList: List<Media> = context.getListFromJsonAsset(MovieConstants.movies_file) ?: emptyList()
    val seriesList: List<Media> = context.getListFromJsonAsset(MovieConstants.tv_series_file) ?: emptyList()
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(Tab.Trending) }
    val (favoritesMedia, setFavoritesMedia) = remember { mutableStateOf(emptyList<Media>()) }

    fun onTabSelected(tab: Tab) {
        setSelectedTab(tab)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AppTabBar { selectedIndex ->
            onTabSelected(
                when (selectedIndex) {
                    0 -> Tab.Trending
                    1 -> Tab.Favorites
                    else -> Tab.Mix
                }
            )
        }

        when (selectedTab) {
            Tab.Trending -> {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(AppBackground)
                ) {
                    TrendingMediaScreen(
                        favorites = favoritesMedia,
                        onMediaItemSelected = { onMediaItemSelected(it) },
                    ) { media ->
                        setFavoritesMedia(
                            if (favoritesMedia.contains(media))
                                favoritesMedia - media
                            else
                                favoritesMedia + media
                        )
                    }
                }
            }

            Tab.Favorites -> {
                FavoritesMediaScreen(favorites = favoritesMedia) { media ->
                    setFavoritesMedia(favoritesMedia - media)
                }
            }

            Tab.Mix -> {
                MixMediaScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainTabContentPreview() {
    MainTabContent() {}
}