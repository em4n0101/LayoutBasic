package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_cancel
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_full_name
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_month
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_number
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_save
import com.alexbar.layoutbasic.utils.ConfirmPayment.add_credit_card_year

@Composable
fun AddCreditCardDialog(
    onDismissRequest: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var expirationMonth by remember { mutableStateOf("") }
    var expirationYear by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismissRequest) {
        Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )  {
            Box(modifier = Modifier
                .clip(RectangleShape)
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(Color.White)
            ) {
                Column {
                    CreditCardUI(name, number, expirationMonth, expirationYear)

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(add_credit_card_full_name) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimen_16_dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                    )

                    TextField(
                        value = number,
                        onValueChange = { number = it },
                        label = { Text(add_credit_card_number) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimen_16_dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimen_16_dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextField(
                            modifier = Modifier.weight(1f),
                            value = expirationMonth,
                            onValueChange = { expirationMonth = it },
                            label = { Text(add_credit_card_month) },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White
                            ),
                        )
                        Spacer(Modifier.width(dimen_16_dp))
                        TextField(
                            modifier = Modifier.weight(1f),
                            value = expirationYear,
                            onValueChange = { expirationYear = it },
                            label = { Text(add_credit_card_year) },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White
                            ),
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimen_16_dp),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = onDismissRequest) {
                            Text(add_credit_card_cancel)
                        }
                        TextButton(onClick = onDismissRequest) {
                            Text(add_credit_card_save)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDialog() {
    AddCreditCardDialog {}
}
