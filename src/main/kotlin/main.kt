import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    println("- Денежные переводы -")
    println("1. Перевод с карты Mastercard и Maestro(переводы до 70000р. комиссия 0, свыше 70000р. комиссия 0.6% + 20 рублей)")
    println("2. Перевод с карты Visa и Мир(комиссия 0.75%, минимум 35 рублей)")
    println("3. Перевод с VK Pay(комиссия не взымается)")
    println("0. Завершить")
    println()
    while (true) {
        print("Введите номер операции:")
        val operationNumber: Int = scanner.nextInt()
        if (operationNumber == 0) break
        else if (operationNumber in 1..3) println(commissionCalculator(operationNumber))
        else println("Неверная операция")
    }
}

fun commissionCalculator(operationNumber: Int): Any {
    print("Введите сумму перевода:")
    val amount: Int = scanner.nextInt()
    return when (operationNumber) {
        1 -> masterMaestro(amount)
        2 -> visaMir(amount)
        3 -> println("Комиссия не взымается")
        else -> println("Неверная операция")
    }
}

fun masterMaestro(amount: Int): Any {
    val many: Double
    return when {
        (amount < 70000) -> "Перевод без комиссии"
        else -> {
            many = amount * 0.0006 + 20
            val rubles = many / 1
            val kopecks = many % 1 * 10
            println("Комиссия составит: ${"%.0f".format(rubles)} руб. ${"%.0f".format(kopecks)} коп.")
        }
    }
}

fun visaMir(amount: Int): Any {
    val many: Double = amount * 0.0075
    return when {
        (many > 35) -> {
            val rubles = many / 1
            val kopecks = many % 1 * 10
            println("Комиссия составит: ${"%.0f".format(rubles)} руб. ${"%.0f".format(kopecks)} коп.")
        }
        else -> {
            println("Комиссия составит: 35 руб. 0 коп.")
        }
    }
}
