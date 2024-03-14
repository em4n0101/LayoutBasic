package com.alexbar.layoutbasic.movies_app.screen.mix

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.networking.RetrofitInstance
import com.alexbar.layoutbasic.movies_app.screen.mix.widgets.MixMediaItem
import com.alexbar.layoutbasic.ui.theme.AppBackground
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_4_dp

@Composable
fun MixMediaScreen() {
    var movieList by remember { mutableStateOf<List<Media>>(emptyList()) }
    var seriesList by remember { mutableStateOf<List<Media>>(emptyList()) }

    LaunchedEffect(Unit) {
        val responseMovies = RetrofitInstance.mediaService.getTrendingMovies()
        val responseSeries = RetrofitInstance.mediaService.getTrendingSeries()

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

    if (movieList.isNotEmpty() && seriesList.isNotEmpty()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                contentPadding = PaddingValues(dimen_4_dp),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(dimen_4_dp),
                verticalItemSpacing = dimen_4_dp
            ) {
                items((seriesList + movieList).shuffled()) { media ->
                    MixMediaItem(media = media)
                }
            }
        }
    }

}
