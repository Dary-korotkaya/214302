fun inputMatrix(name: String): Array<IntArray> {
    print("Введите количество строк $name матрицы:")
    val r = readLine()!!.toInt()
    print("Введите количество столбцов $name матрицы:")
    val c = readLine()!!.toInt()

    val matrix = Array(r) { IntArray(c) }
    println("Введите элементы $name матрицы:")
    for (i in 0 until r) {
        for (j in 0 until  c) {
            print("Элемент [$i][$j]:")
            matrix[i][j] = readLine()!!.toInt()
        }
    }
    return matrix
}


fun printMatrix(matrix: Array<DoubleArray>) {
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}

fun main() {
    // универс функц для заполнения двух матриц
    val matrix1 = inputMatrix("первой")
    val matrix2 = inputMatrix("второй")



    val transpose: (Array<IntArray>) -> Array<IntArray> = { matrix ->
        Array(matrix[0].size) { col ->
            IntArray(matrix.size) { row -> matrix[row][col] }
        }
    }
    val transposedMatrix = transpose(matrix1)
    println("Транспонирование:")
    printMatrix(transposedMatrix)



    val merge = fun(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
        return Array(mat1.size) { i -> mat1[i] + mat2[i] }
    }
    val mergedMatrix = merge(matrix1, matrix2)
    println("Слияние:")
    printMatrix(mergedMatrix)




    val normalizedMatrix = normalize(matrix1)
    println("Нормализация:")
    printMatrix(normalizedMatrix)
}

fun normalize(matrix: Array<IntArray>): Array<DoubleArray> {
    val max = matrix.flatMap { it.asList() }.maxOrNull()?.toDouble() ?: 1.0
    return Array(matrix.size) { i ->
        DoubleArray(matrix[i].size) { j -> matrix[i][j] / max }
    }
}
