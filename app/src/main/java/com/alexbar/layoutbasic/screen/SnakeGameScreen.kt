package com.alexbar.layoutbasic.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.*
import com.alexbar.layoutbasic.utils.GameConstants
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SnakeGame() {
    val snakeBodyColor = Color.Blue
    val foodColor = Color.Red
    val snakeSize = Dimens.snake_size_100
    var snakePosition by remember { mutableStateOf(Offset.Zero) }
    var direction by remember { mutableStateOf(Offset(snakeSize, Dimens.snake_init_direction_y)) }
    var foodPosition by remember { mutableStateOf(randomOffset(snakeSize)) }
    var gameOver by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        while (!gameOver) {
            delay(GameConstants.game_delay_300_ms)
            val newPosition = snakePosition + direction
            if (newPosition.x < 0 || newPosition.y < 0) {
                gameOver = true
            } else {
                snakePosition = newPosition
            }

            if (snakePosition == foodPosition) {
                foodPosition = randomOffset(snakeSize)
            }
        }
    }

    if (!gameOver) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { offset ->
                        direction = changeDirection(snakePosition, offset, snakeSize)
                    }
                )
            }
        ) {

            drawBoard(snakeSize, Dimens.board_width, Dimens.board_height)
            drawSnake(snakePosition, snakeBodyColor)
            drawCell(foodColor, foodPosition, Size(snakeSize, snakeSize))
        }
    } else {
        Text(
            text = GameConstants.game_over_text,
            color = Color.Black,
            modifier = Modifier.fillMaxSize()
        )
    }
}

fun DrawScope.drawBoard(
    snakeSize: Float,
    boardWidth: Int,
    boardHeight: Int
) {
    for (i in 0 until boardWidth) {
        for (j in 0 until boardHeight) {
            val isDarkCell = (i + j) % 2 == 1
            val cellColor = if (isDarkCell) BoardDarkColor else BoardLightColor
            val cellTopLeft = Offset(i * snakeSize, j * snakeSize)
            drawCell(cellColor, cellTopLeft, Size(snakeSize, snakeSize))
        }
    }
}

fun DrawScope.drawSnake(
    position: Offset,
    snakeBodyColor: Color
) {
    drawCircle(
        color = snakeBodyColor,
        radius = Dimens.snake_circle_radius,
        center = position + Offset(Dimens.snake_circle_radius, Dimens.snake_circle_radius))
}

fun DrawScope.drawCell(
    cellColor: Color,
    cellTopLeft: Offset,
    cellSize: Size
) {
    drawRect(
        color = cellColor,
        topLeft = cellTopLeft,
        size = cellSize
    )
}

fun changeDirection(snakePosition: Offset, tapPosition: Offset, snakeSize: Float): Offset {
    return when {
        tapPosition.x < snakePosition.x -> Offset(-snakeSize, 0f)  // Move left
        tapPosition.x > snakePosition.x + snakeSize -> Offset(snakeSize, 0f)  // Move right
        tapPosition.y < snakePosition.y -> Offset(0f, -snakeSize)  // Move up
        tapPosition.y > snakePosition.y + snakeSize -> Offset(0f, snakeSize)  // Move down
        else -> Offset(0f, 0f)
    }
}

fun randomOffset(snakeSize: Float): Offset {
    val randomX = Random.nextInt(0, Dimens.board_width) * snakeSize
    val randomY = Random.nextInt(0, Dimens.board_height) * snakeSize

    return Offset(randomX, randomY)
}

@Preview
@Composable
fun PreviewSnakeGame() {
    SnakeGame()
}
