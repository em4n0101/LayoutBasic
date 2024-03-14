package com.alexbar.layoutbasic.movies_app.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.detail.MediaDetailScreen
import com.alexbar.layoutbasic.movies_app.screen.favorites.FavoritesMediaScreen
import com.alexbar.layoutbasic.movies_app.screen.mix.MixMediaScreen
import com.alexbar.layoutbasic.movies_app.screen.trending.TrendingMediaScreen
import com.alexbar.layoutbasic.movies_app.utils.getVoteAverageFormatted
import com.alexbar.layoutbasic.ui.theme.AppBackground

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.TrendingMediaScreen.route
    ) {
        composable(route = Screens.TrendingMediaScreen.route) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(AppBackground)
            ) {
                TrendingMediaScreen(
                    favorites = emptyList(),
                    onMediaItemSelected = { media: Media ->
                        navController.navigate(Screens.DetailMediaScreen.route
                                + "/${media.title ?: media.name ?: ""}"
                                + "/${media.description}"
//                                + "/${media.getImageBackdropCompleteUrl()}"
//                                + "/${media.getImagePosterCompleteUrl()}"
                                + "/${media.getVoteAverageFormatted()}"
                        )
                    },
                ) { _ ->

                }
            }
        }
        composable(route = Screens.FavoritesMediaScreen.route) {
            FavoritesMediaScreen(favorites = emptyList()) { media ->

            }
        }
        composable(route = Screens.MixMediaScreen.route) {
            MixMediaScreen()
        }
        composable(route = Screens.DetailMediaScreen.route + "/{title}/{description}/{voteAverage}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
//            val imageBackdropUrl = backStackEntry.arguments?.getString("imageBackdropUrl") ?: ""
//            val imagePosterUrl = backStackEntry.arguments?.getString("imagePosterUrl") ?: ""
            val voteAverage = backStackEntry.arguments?.getString("voteAverage") ?: ""

            MediaDetailScreen(
                name = title,
                description = description,
                imageBackdropUrl = "https://image.tmdb.org/t/p/w500//mSDsSDwaP3E7dEfUPWy4J0djt4O.jpg",
                imagePosterUrl = "https://image.tmdb.org/t/p/w500//39wmItIWsg5sZMyRUHLkWBcuVCM.jpg",
                voteAverage = voteAverage
            ) {
                navController.popBackStack()
            }
        }
    }
}
