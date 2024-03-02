package com.alexbar.layoutbasic.movies_app.screen.favorites.widgets

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import com.alexbar.layoutbasic.movies_app.model.Media
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_100_dp
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteMediaItemSwipe(
    media: Media,
    onSwipeToDelete: (Media) -> Unit
) {
    val density = LocalDensity.current
    val defaultActionSize = dimen_100_dp
    val endActionSizePx = with(density) { (defaultActionSize * 2).toPx() }

    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Center,
            anchors = DraggableAnchors {
                DragAnchors.Center at 0f
                DragAnchors.End at endActionSizePx
            },
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { dimen_100_dp.toPx() } },
            animationSpec = tween(),
        )
    }

    LaunchedEffect(media) {
        state.animateTo(DragAnchors.Center)
    }

    DraggableItem(state = state,
        startAction = null,
        endAction = {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .offset {
                        IntOffset(
                            ((-state
                                .requireOffset()) + endActionSizePx)
                                .roundToInt(), 0
                        )
                    }
            )
            {
                DeleteAction(
                    Modifier
                        .width(defaultActionSize)
                        .fillMaxHeight()
                        .clickable { onSwipeToDelete(media) }
                )
            }
        }, content = {
            FavoriteMediaItem(media = media)
        }
    )
}
