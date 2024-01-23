package com.alexbar.layoutbasic.utils

import androidx.compose.ui.Modifier

inline fun Modifier.conditional(
    cardType: CardType,
    ifVisa: Modifier.() -> Modifier,
    ifMastercard: Modifier.() -> Modifier,
    ifAmex: Modifier.() -> Modifier,
    ifUnknown: Modifier.() -> Modifier,
) : Modifier = when (cardType) {
    CardType.VISA -> then(ifVisa(Modifier))
    CardType.MASTERCARD -> then(ifMastercard(Modifier))
    CardType.AMEX -> then(ifAmex(Modifier))
    else -> then(ifUnknown(Modifier))
}

enum class CardType(val displayName: String) {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMEX("American Express"),
    UNKNOWN("")
}

fun detectCardType(cardNumber: String): CardType {
    return when {
        cardNumber.startsWith("4") -> CardType.VISA
        (cardNumber.startsWith("51") ||
                cardNumber.startsWith("52") ||
                cardNumber.startsWith("53") ||
                cardNumber.startsWith("54") ||
                cardNumber.startsWith("55") ||
                cardNumber.startsWith("2221") ||
                cardNumber.startsWith("2720")) -> CardType.MASTERCARD
        (cardNumber.startsWith("34") ||
                cardNumber.startsWith("37")) -> CardType.AMEX
        else -> CardType.UNKNOWN
    }
}