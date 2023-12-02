fun main(args: Array<String>) {
    //val setElements = setOf(*args)
    //println(setElements.size)

    var counter = 0
    for (i in args.indices) {
        var isFounded = false
        for (j in 0..<i) {
            if (args[i] == args[j]) {
                isFounded = true
                break
            }
        }
        if (!isFounded) {
            counter += 1
        }
    }
    println(counter)
}