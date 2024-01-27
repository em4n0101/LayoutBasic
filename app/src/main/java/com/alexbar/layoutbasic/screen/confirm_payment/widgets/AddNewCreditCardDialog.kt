package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    onCreateCard:(CreditCardInfo) -> Unit,
    onDismissRequest: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var expirationMonth by remember { mutableStateOf("") }
    var expirationYear by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismissRequest) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .pointerInput(Unit) { detectTapGestures { } }
            .shadow(8.dp, shape = RoundedCornerShape(16.dp))
            .background(
                MaterialTheme.colorScheme.surface
            ),
            contentAlignment = Alignment.Center
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
                        onValueChange = { number = it.take(16) },
                        label = { Text(add_credit_card_number) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                        TextButton(onClick = {
                            onCreateCard(
                                CreditCardInfo(
                                    name,
                                    number,
                                    expirationMonth,
                                    expirationYear
                                )
                            )
                            onDismissRequest()
                        }) {
                            Text(add_credit_card_save)
                        }
                    }
                }
            }
        }
    }
}

data class CreditCardInfo(
    val name: String,
    val number: String,
    val expirationMonth: String,
    val expirationYear: String
)

@Preview
@Composable
fun PreviewDialog() {
    AddCreditCardDialog({}) {}
}
