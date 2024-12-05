/*13.	Сортировка с нестандартным порядком: Создайте программу,
которая сортирует массив чисел по нестандартному порядку
(например, сначала все отрицательные числа по убыванию, затем все
положительные по возрастанию).*/

fun sort(numbers: IntArray, n: Int): Pair<IntArray, IntArray> {
    //создаем два массива
    val negative = mutableListOf<Int>()
    val positive = mutableListOf<Int>()

    for (i in 0 until n) {
        if (numbers[i] >= 0) positive.add(numbers[i])
        else negative.add(numbers[i])
    }

    //сортировка отриц по убыванию
    negative.sortDescending()

    //сортировка положит по возрастанию
    positive.sort()

    return Pair(negative.toIntArray(), positive.toIntArray())
}

fun main() {
    print("Введите кол-во элементов для массива n:")
    val n = readLine()!!.toInt()

    val numbers = IntArray(n)

    println("Теперь необходимо заполнить массив числами:")
    for (i in 0..< n) {
        println("[" + (i+1) + "]")
        numbers[i] = readLine()!!.toInt()
    }
    println(numbers.joinToString(", "))

    val (negativeArray, positiveArray) = sort(numbers, n)
    println("Отрицательные числа по убыванию: " + negativeArray.joinToString(", "))
    println("Положительные числа по возрастанию: " + positiveArray.joinToString(", "))
    val arr = negativeArray + positiveArray
    println(arr.joinToString(", "))

}