package com.alexbar.layoutbasic.movies_app.screen.detail.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.alexbar.layoutbasic.ui.theme.AppBackground
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_8_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.max_lines
import com.alexbar.layoutbasic.ui.theme.Dimens.min_lines
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun ExpandableSummaryCard(
    summary: String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = AppBackground
        ),
        shape = RoundedCornerShape(dimen_8_dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimen_16_dp)
            .clickable { expanded = !expanded }
    ) {
        Column {
            Text(
                text = MovieConstants.summary,
                style = Typography.bodyMedium
            )
            Text(
                text = summary,
                maxLines = if (expanded) max_lines else min_lines,
                style = Typography.labelSmall
            )
            TextButton(modifier = Modifier.fillMaxWidth(), onClick = { expanded = !expanded }) {
                Text(text = if (expanded) MovieConstants.see_less else MovieConstants.see_more)
            }
        }
    }
}


@Preview
@Composable
fun PreviewExpandableSummaryCard() {
    ExpandableSummaryCard(summary = "Brought back to life by an unorthodox scientist, a young woman runs off with a debauched lawyer on a whirlwind adventure across the continents. Free from the prejudices of her times, she grows steadfast in her purpose to stand for equality and liberation.\",\n Brought back to life by an unorthodox scientist, a young woman runs off with a debauched lawyer on a whirlwind adventure across the continents. Free from the prejudices of her times, she grows steadfast in her purpose to stand for equality and liberation.\",\n")
}