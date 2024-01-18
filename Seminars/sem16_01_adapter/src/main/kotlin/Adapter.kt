class Adapter(private var fileWriter : FileWriter) : MethodsToWrite {
    override fun write(message: String) {
        fileWriter.saveToFile(message)
    }
}