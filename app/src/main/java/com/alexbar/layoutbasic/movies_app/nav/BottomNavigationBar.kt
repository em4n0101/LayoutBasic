package com.alexbar.layoutbasic.movies_app.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexbar.layoutbasic.movies_app.screen.mainTabContent.widgets.TabItem
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants

@Composable
fun BottomNavigationBar(navController: NavController) {
    val tabItems = listOf(
        TabItem(
            title = MovieConstants.tab_trending,
            selectedIcon = Icons.Filled.Movie,
            unselectedIcon = Icons.Outlined.Movie,
            screen = Screens.TrendingMediaScreen
        ),
        TabItem(
            title = MovieConstants.tab_favorites,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            screen = Screens.FavoritesMediaScreen
        ),
        TabItem(
            title = MovieConstants.tab_mix,
            selectedIcon = Icons.Outlined.GridView,
            unselectedIcon = Icons.Filled.GridView,
            screen = Screens.MixMediaScreen
        )
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        tabItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(
                    imageVector = if (currentRoute ==  item.screen.route) {
                        item.selectedIcon
                    } else {
                        item.unselectedIcon
                    },
                    contentDescription = item.title
                ) },
                label = { Text(item.title) },
                selected = currentRoute ==  item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
