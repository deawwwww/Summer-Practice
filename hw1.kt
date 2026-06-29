fun main() {
    analyzeIntList(listOf(0,1,2,3,4,5,6,7,8,9))
    println("======================")
    analyzePassword("someTestPassword")
}
fun analyzeIntList(input: List<Int>) {
    println("Минимальное число: ${input.minOrNull()}")
    println("Максимальное число: ${input.maxOrNull()}")
    println("Сумма: ${input.sum()}")
    var chet = 0
    var nechet = 0
    for (num in input) {
        if (num % 2 == 0) chet++
        else nechet++
    }
    println("Четных $chet")
    println("Нечетных $nechet")
}
fun analyzePassword(input: String) {
    var result = 0
    if (input.length >= 8) result++
    if (input.any{it.isDigit()}) result++
    if (input.any{it.isUpperCase()}) result++
    if (input.any{it.isLowerCase()}) result++
    if (input.any{it in ".-_"}) result++

    if (result == 5) println("Надежный пароль")
    if (result == 4) println("Хороший пароль")
    if (result == 2 || result == 3) println("Средний пароль")
    if (result < 2) println("Ненадеждый пароль")
}
