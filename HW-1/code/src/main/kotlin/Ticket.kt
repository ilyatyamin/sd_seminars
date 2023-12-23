import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class Ticket(var session: Int, var place : Pair<Int, Int>) {
    var id : Int = 0
    // Дата покупки билета
    var datePurchase = LocalDateTime.now().toString()

    init {
        id = ++stId
    }
}