/*13.	Расчет сложных процентов с изменяющейся ставкой: Напишите программу,
которая принимает начальную сумму вклада, процентную ставку, количество лет и
ежегодное изменение ставки, и вычисляет итоговую сумму с учетом сложных процентов.*/

fun calculating(startSum:Double, percent:Double, numOfYears:Int,percentageChange:Double) : Double {
    var finalSum = startSum

    for (year in 1..numOfYears) {
        val currentRate = percent + (year - 1) * percentageChange
        finalSum *= (1 + currentRate / 100)
    }

    return finalSum
}

fun main() {
    println("Давайте рассчитаем сложный процент с изменяющеся ставкой!")

    println("Для начала необходимо ввести начальную сумму вклада:")
    val startSum = readln().toDouble()

    println("Введите процентную ставку:")
    val percent = readln().toDouble()

    println("Введите количество лет:")
    val numOfYears = readln().toInt()

    println("Введите ежегодное изменение ставки:")
    val percentageChange = readln().toDouble()

    val result = calculating(startSum, percent, numOfYears, percentageChange)
    val res = String.format("%.3f", result)
    println("Итоговая сумма вклада: $res")
    val arr = intArrayOf(1,2,3,4,5)
}

/*
1000.0  5.0% 3 0.5%

1: 5.0% 1000.0  1000.0 * (1 + 0.05) = 1050.0

2: 5.5%  1050.0 1050.0 * (1 + 0.055) = 1107.75

3: 6.0%  1107.75 1107.75 * (1 + 0.06) = 1174.215
*/