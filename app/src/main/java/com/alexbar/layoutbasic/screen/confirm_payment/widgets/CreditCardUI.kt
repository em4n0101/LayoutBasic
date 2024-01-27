package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.CardAmex
import com.alexbar.layoutbasic.ui.theme.CardMastercard
import com.alexbar.layoutbasic.ui.theme.CardUnknown
import com.alexbar.layoutbasic.ui.theme.CardVisa
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_20_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_220_dp
import com.alexbar.layoutbasic.ui.theme.Typography
import com.alexbar.layoutbasic.utils.ConfirmPayment.credit_card_expires
import com.alexbar.layoutbasic.utils.ConfirmPayment.credit_card_holder
import com.alexbar.layoutbasic.utils.conditional
import com.alexbar.layoutbasic.utils.detectCardType

@Composable
fun CreditCardUI (
    name: String,
    number: String,
    expirationMonth: String,
    expirationYear: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(dimen_220_dp)
        .padding(dimen_16_dp)
        .clip(RoundedCornerShape(dimen_20_dp))
        .conditional(
            detectCardType(number),
            ifAmex = { background(CardAmex) },
            ifMastercard = { background(CardMastercard) },
            ifVisa = { background(CardVisa) },
            ifUnknown = { background(CardUnknown) },
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(dimen_16_dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CardItem(key = credit_card_holder, value = name)
            CardItem(value = formatCreditCardNumber(number))
            CardItem(key = credit_card_expires, value = "${expirationMonth}/${expirationYear}")
        }
    }
}

@Composable
fun CardItem(
    key: String? = null,
    value: String
) {
    Column {
        if (key != null) Text(
            text = key,
            style = Typography.bodySmall,
            color = Color.White
        )
        Text(
            text = value,
            style = Typography.titleMedium,
            color = Color.White
        )
    }
}

fun formatCreditCardNumber(input: String): String {
    val trimmed = input.replace(" ", "")
    val formatted = buildString {
        for (i in trimmed.indices) {
            if (i > 0 && i % 4 == 0) {
                append(" ")
            }
            append(trimmed[i])
        }
    }
    return formatted
}

@Preview
@Composable
fun PreviewCreditCardUI() {
    CreditCardUI(
        name = "User Name",
        number = "4242 4242 4242 4242",
        expirationMonth = "10",
        expirationYear = "25"
    )
}