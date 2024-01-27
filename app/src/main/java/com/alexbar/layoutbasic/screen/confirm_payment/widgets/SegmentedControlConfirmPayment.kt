package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_16_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_4_dp
import com.alexbar.layoutbasic.ui.theme.Dimens.dimen_8_dp
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun SegmentedControlConfirmPayment(
    title: String,
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (index: Int) -> Unit,
    modifier:Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimen_16_dp)
    ) {
        Text(
            text = title,
            style = Typography.bodyMedium,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(dimen_8_dp))
        Row {
            options.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                OutlinedButton(
                    onClick = { onOptionSelected(index) },
                    shape = RoundedCornerShape(dimen_8_dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color.Red else Color.Transparent,
                        contentColor = if (isSelected) Color.White else Color.DarkGray
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimen_4_dp)
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSegmentedControlConfirmPayment() {
    SegmentedControlConfirmPayment(
        title = "Payment Method",
        options = listOf("User Balance", "Credit Card"),
        selectedIndex = 0,
        onOptionSelected = {}
    )
}