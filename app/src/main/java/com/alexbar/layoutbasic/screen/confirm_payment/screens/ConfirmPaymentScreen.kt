package com.alexbar.layoutbasic.screen.confirm_payment.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.AddCreditCardDialog
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.CreditCardInfo
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.CreditCardList
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.EmptyCreditCards
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.HeaderConfirmPayment
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.SegmentedControlConfirmPayment
import com.alexbar.layoutbasic.screen.confirm_payment.widgets.UserBalance
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

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ConfirmPaymentScreen() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedIndex by remember { mutableIntStateOf(0) }
    var showNewCreditCardDialog by remember { mutableStateOf(false) }
    val paymentMethods = listOf(payment_method_user_balance, payment_method_credit_card)
    val currentUserBalance = current_user_balance
    var creditCards by remember { mutableStateOf(mutableListOf<CreditCardInfo>()) }

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
            userBalance, emptyCreditCards, listCreditCards) = createRefs()

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
            if (creditCards.isEmpty()) {
                EmptyCreditCards(
                    modifier = Modifier.constrainAs(emptyCreditCards) {
                        top.linkTo(paymentMethodSegmentedControl.bottom)
                    },
                    onClickAddNewCard = { showNewCreditCardDialog = true }
                )
            } else {
                CreditCardList(
                    creditCards,
                    modifier = Modifier.constrainAs(listCreditCards) {
                        top.linkTo(paymentMethodSegmentedControl.bottom)
                    }
                )
            }
        }

        if (showNewCreditCardDialog)
            AddCreditCardDialog(
                onCreateCard = {
                    creditCards.add(it)
                    showNewCreditCardDialog = false
                }
            ) { showNewCreditCardDialog = false }

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
