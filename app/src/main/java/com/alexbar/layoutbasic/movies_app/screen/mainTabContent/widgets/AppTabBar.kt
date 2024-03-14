package com.alexbar.layoutbasic.movies_app.screen.mainTabContent.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.nav.Screens
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.tab_favorites
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.tab_mix
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.tab_trending

@Composable
fun AppTabBar(onTabSelected: (Int) -> Unit) {
    val tabItems = listOf(
        TabItem(
            title = tab_trending,
            selectedIcon = Icons.Filled.Movie,
            unselectedIcon = Icons.Outlined.Movie,
            screen = Screens.TrendingMediaScreen
        ),
        TabItem(
            title = tab_favorites,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            screen = Screens.FavoritesMediaScreen
        ),
        TabItem(
            title = tab_mix,
            selectedIcon = Icons.Outlined.GridView,
            unselectedIcon = Icons.Filled.GridView,
            screen = Screens.MixMediaScreen
        )
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    TabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                          },
                text = { Text(text = item.title) },
                icon = { Icon(
                    imageVector = if (index == selectedIndex) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                    contentDescription = item.title
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun AppTabBarPreview() {
    AppTabBar {}
}