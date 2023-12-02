fun main(args: Array<String>) {
    val str = readln()

    println(str)
    val words = str.split(" ")
    repeat(3) {
        println(words[words.size - 1])
    }
}