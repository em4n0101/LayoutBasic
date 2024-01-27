package com.alexbar.layoutbasic.screen.confirm_payment.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun CreditCardList(
    creditCards: List<CreditCardInfo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(creditCards) { card ->
            CreditCardItem(card)
        }
    }
}

@Composable
fun CreditCardItem(card: CreditCardInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "**** ${card.number.takeLast(4)}",
            style = Typography.titleMedium,
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
fun PreviewCreditCardList() {
    CreditCardList(creditCards = listOf(CreditCardInfo(
        "",
        "4242424242424242",
        "",
        ""
    )))
}