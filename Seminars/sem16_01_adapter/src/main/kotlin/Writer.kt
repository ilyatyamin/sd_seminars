interface MethodsToWrite {
    fun write(message : String)
}

class Writer : MethodsToWrite {
    override fun write(message : String) {
        println(message)
    }
}