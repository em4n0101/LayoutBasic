package com.alexbar.layoutbasic.movies_app.screen.favorites.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun DeleteAction(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(Dimens.dimen_8_dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(Dimens.dimen_24_dp),
                imageVector = Icons.Filled.Delete,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = MovieConstants.action_delete_text,
                color = Color.White,
                fontSize = Dimens.dimen_12_sp,
                style = Typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
fun DeleteActionPreview () {
    DeleteAction()
}