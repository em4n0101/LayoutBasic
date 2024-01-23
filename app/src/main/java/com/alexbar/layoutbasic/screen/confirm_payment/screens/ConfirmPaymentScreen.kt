package com.alexbar.layoutbasic.screen.confirm_payment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.*
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_cards_button
import com.alexbar.layoutbasic.utils.ConfirmPayment.checkout_button
import com.alexbar.layoutbasic.utils.ConfirmPayment.current_user_balance
import com.alexbar.layoutbasic.utils.ConfirmPayment.no_credit_cards_message
import com.alexbar.layoutbasic.utils.ConfirmPayment.payment_method_credit_card
import com.alexbar.layoutbasic.utils.ConfirmPayment.payment_method_title
import com.alexbar.layoutbasic.utils.ConfirmPayment.payment_method_user_balance
import com.alexbar.layoutbasic.utils.ConfirmPayment.total_amount
import com.alexbar.layoutbasic.utils.ConfirmPayment.welcome_message
import kotlinx.coroutines.launch

@Composable
fun ConfirmPaymentScreen() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedIndex by remember { mutableIntStateOf(0) }
    var showNewCreditCardDialog by remember { mutableStateOf(false) }
    val paymentMethods = listOf(payment_method_user_balance, payment_method_credit_card)
    val currentUserBalance = current_user_balance

    LaunchedEffect(Unit) {
        scope.launch {
            snackBarHostState
                .showSnackbar(welcome_message)
        }
    }

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        val (header, paymentMethodSegmentedControl, payButton, snackBar,
            userBalance, emptyCreditCards) = createRefs()

        HeaderConfirmPayment(
            userBalance = total_amount,
            modifier = Modifier.constrainAs(header){}
        )

        SegmentedControlConfirmPayment(
            title = payment_method_title,
            options = paymentMethods,
            selectedIndex = selectedIndex,
            onOptionSelected = { index -> selectedIndex = index },
            modifier = Modifier.constrainAs(paymentMethodSegmentedControl) {
                top.linkTo(header.bottom)
            }
        )

        if (selectedIndex == 0) {
            UserBalance(
                currentBalance = currentUserBalance,
                modifier = Modifier.constrainAs(userBalance) {
                    top.linkTo(paymentMethodSegmentedControl.bottom)
                }
            )
        } else {
            EmptyCreditCards(
                modifier = Modifier.constrainAs(emptyCreditCards) {
                    top.linkTo(paymentMethodSegmentedControl.bottom)
                },
                onClickAddNewCard = { showNewCreditCardDialog = true }
            )
        }

        if (showNewCreditCardDialog)
            AddCreditCardDialog { showNewCreditCardDialog = false }

        Button(
            onClick = {
                if (selectedIndex == 1)
                    scope.launch {
                        val result = snackBarHostState
                            .showSnackbar(
                                message = no_credit_cards_message,
                                actionLabel = add_credit_cards_button,
                                duration = SnackbarDuration.Short
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                showNewCreditCardDialog = true
                            }
                            SnackbarResult.Dismissed -> {}
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimen_16_dp)
                .constrainAs(payButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
            }
        ) {
            Text(text = checkout_button)
        }

        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.constrainAs(snackBar) {
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview
@Composable
fun PreviewConfirmPaymentScreen() {
    ConfirmPaymentScreen()
}
