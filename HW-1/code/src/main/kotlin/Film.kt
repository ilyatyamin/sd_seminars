import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
class Film(var name: String, var duration: Duration, var director: String, var ageLimits: AgeLimits) {
    var id : Int = 0
    init {
        id = ++filmId
    }

    override fun toString(): String {
        return "Film id = $id. Name = $name. Duration = $duration. Director = $director AgeLimit = $ageLimits"
    }

}