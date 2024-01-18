class Notifier {
    var message = "message"
    var writer = Writer()

    @JvmName("new_notifier")
    fun notify() {
        writer.write(message)
    }
}