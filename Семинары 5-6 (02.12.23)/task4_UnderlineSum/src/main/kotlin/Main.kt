fun main(args: Array<String>) {
    val n = readln().toInt()
    val table = Array(n, { Array(n, {0}) })

    for (i in 0..<n) {
        for (j in 0..<n) {
            table[i][j] = (0..10).random()
            print("${table[i][j]} ")
        }
        println()
    }

    var sum = 0
    for (row in 1..<n) {
        for (elem in (n-row)..<n) {
            sum += table[row][elem]
        }
    }
    println("sum is $sum")


}