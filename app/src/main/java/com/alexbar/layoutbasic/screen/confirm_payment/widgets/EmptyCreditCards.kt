package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_300_dp
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_cards_button
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_cards_button_icon_description
import com.alexbar.layoutbasic.utils.ConfirmPayment.no_credit_cards_message

@Composable
fun EmptyCreditCards(
    onClickAddNewCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(dimen_300_dp)
            .padding(dimen_16_dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            imageVector = Icons.Filled.CreditCardOff,
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier
                .size(Dimens.sign_up_icon_gym_size)
        )
        Text(
            text = no_credit_cards_message,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(dimen_16_dp))
        ExtendedFloatingActionButton(
            onClick = onClickAddNewCard,
            icon = { Icon(Icons.Filled.AddCard, add_credit_cards_button_icon_description) },
            text = { Text(text = add_credit_cards_button) }
        )
    }
}

@Preview
@Composable
fun PreviewEmptyCreditCards() {
    EmptyCreditCards({})
}