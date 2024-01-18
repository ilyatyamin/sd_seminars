class Logger {
    fun writeMessageGet(id : Int) {
        println("user try to get message with id ${id} ")
    }

    fun writeMessageAdd(id : String, success : Boolean ) {
        println("user try to add message - ${id}. success: ${success} ")
    }

    fun writeMessageRemove(id : String, success : Boolean) {
        println("user try to remove message - ${id}. success: ${success} ")
    }
}