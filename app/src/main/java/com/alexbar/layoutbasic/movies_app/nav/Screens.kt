package com.alexbar.layoutbasic.movies_app.nav

sealed class Screens(val route: String) {
    object TrendingMediaScreen : Screens("trending_media_screen")
    object FavoritesMediaScreen : Screens("favorites_media_screen")
    object MixMediaScreen : Screens("mix_media_screen")
    object DetailMediaScreen : Screens("detail_screen")
}
