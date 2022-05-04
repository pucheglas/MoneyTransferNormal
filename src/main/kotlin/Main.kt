fun VkPay (amountMonth: Int, amount: Int): Int {
    val limitMonth = 40_000_00
    val limitNow = 15_000_00
    return if (amountMonth + amount > limitMonth) -1
    else if (amount > limitNow) -2
    else 0
}

fun VisaMir(amountMonth: Int, amount: Int): Int {
    val limitMonth = 600_000_00
    val limitNow = 150_000_00
    val tarifMM = 0.0075
    val minTarif = 35_00

    return if (amountMonth + amount > limitMonth) -1
    else if (amount > limitNow) -2
    else {
         (if (amount * tarifMM > minTarif) amount * tarifMM else minTarif).toInt()
    }
}

fun MasterMaestro(amountMonth: Int, amount: Int): Int {
    val tarif = 0.006
    val limitMonth = 75_000_00
    return if (limitMonth > amountMonth + amount) 0
    else (amount * tarif +20_00).toInt()
}

fun tarifTransver (
    cardType: String = "VkPay",
    amountMonth: Int = 0,
    amount: Int
): Int {
    val tarif = when (cardType) {
        "VkPay" -> VkPay(amountMonth, amount)
        "Mastercard" -> MasterMaestro(amountMonth, amount)
        "Maestro" -> MasterMaestro(amountMonth, amount)
        "Visa" -> VisaMir(amountMonth, amount)
        else -> VisaMir(amountMonth, amount)
    }
    print ("Карта $cardType ")
    print ("Перевод ${amount / 100} руб. ")
    print ("Сумма переводов за месяц ${amountMonth / 100} руб.")
    when (tarif) {
        -1 -> println(" Превышен месячный лимит переводов")
        -2 -> println(" Превышен лимит перевода")
        else -> println(" Комиссия $tarif коп.")
    }
    return tarif
}

fun main() {
    tarifTransver(amount = 1_000_00)
    tarifTransver(amount = 16_000_00)
    tarifTransver(amount = 16_000_00, amountMonth = 25_000_00)
    tarifTransver(cardType = "Mastercard", amount = 1000_00, amountMonth = 73_000_00)
    tarifTransver(cardType = "Maestro", amount = 1000_00, amountMonth = 75_000_00)
    tarifTransver(cardType = "Mir", amount = 10000_00)
    tarifTransver(cardType = "Mir", amount = 151000_00, amountMonth = 75_000_00)
    tarifTransver(cardType = "Visa", amount = 1000_00, amountMonth = 600_000_00)

}