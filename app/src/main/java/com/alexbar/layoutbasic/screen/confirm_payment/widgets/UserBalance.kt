package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_300_dp
import com.alexbar.layoutbasic.ui.theme.Typography
import com.alexbar.layoutbasic.utils.ConfirmPayment.user_balance_title

@Composable
fun UserBalance(
    currentBalance: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(dimen_300_dp)
            .padding(dimen_16_dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$$currentBalance",
            style = Typography.displayLarge,
            color = Color.DarkGray
        )
        Text(
            text = user_balance_title,
            color = Color.DarkGray
        )
    }
}

@Preview
@Composable
fun PreviewUserBalance() {
    UserBalance(currentBalance = 100.99)
}