package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_24_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_250_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_80_dp
import com.alexbar.layoutbasic.ui.theme.Typography
import com.alexbar.layoutbasic.utils.ConfirmPayment.header_amount
import com.alexbar.layoutbasic.utils.ConfirmPayment.header_title

@Composable
fun HeaderConfirmPayment(
    userBalance: Double,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(dimen_250_dp)
        .clip(RoundedCornerShape(
            bottomEnd = dimen_16_dp,
            bottomStart = dimen_16_dp
        ))
        .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = dimen_24_dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = header_title, style = Typography.displayLarge)
            Icon(
                imageVector = Icons.Filled.Payments,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(dimen_80_dp)
            )
            Text(text = "$$userBalance", style = Typography.displayMedium)
            Text(text = header_amount, style = Typography.bodyLarge, color = Color.Gray)
        }
    }
}

@Preview
@Composable
fun PreviewHeaderConfirmPayment() {
    HeaderConfirmPayment(userBalance = 15.99)
}