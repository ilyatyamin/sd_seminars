import java.io.File

interface Writer {
    fun write(jsonStr : String, nameOfFile: String)
}

interface Reader {
    fun read(nameOfFile: String) : String?
}

/**
 * Класс для чтения и записи в файл JSON-строк
 */
class FileWriter : Writer, Reader {
    override fun write(jsonStr: String, nameOfFile : String) {
        try {
            File(nameOfFile).bufferedWriter().use { out ->
                out.write(jsonStr)
            }
        } catch (ex : Exception) {
            println("Oops! There was an error when you writing to file $nameOfFile.")
        }
    }

    override fun read(nameOfFile: String): String? {
        return try {
            File(nameOfFile).bufferedReader().use { out -> out.readText() }
        } catch (ex : Exception) {
            null
        }
    }

}