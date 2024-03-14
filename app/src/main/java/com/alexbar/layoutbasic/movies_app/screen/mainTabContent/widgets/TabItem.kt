package com.alexbar.layoutbasic.movies_app.screen.mainTabContent.widgets

import androidx.compose.ui.graphics.vector.ImageVector
import com.alexbar.layoutbasic.movies_app.nav.Screens

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: Screens,
)
