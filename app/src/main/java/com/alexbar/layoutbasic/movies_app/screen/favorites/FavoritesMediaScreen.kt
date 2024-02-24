package com.alexbar.layoutbasic.movies_app.screen.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.movies_app.screen.favorites.widgets.FavoriteMediaItemSwipe
import com.alexbar.layoutbasic.ui.theme.AppBackground

@Composable
fun FavoritesMediaScreen(
    favorites: List<Media>,
    onSwipeToDelete: (Media) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppBackground)
    ) {
        LazyColumn {
            items(favorites) {
                FavoriteMediaItemSwipe(
                    it,
                    onSwipeToDelete = onSwipeToDelete
                )
            }
        }
    }
}