import java.io.File

class FileWriter {
    val path = "/Users/mrshrimp.it/Desktop"

    fun saveToFile(str : String) {
        File(path).writeText(str, Charsets.UTF_8)
    }
}