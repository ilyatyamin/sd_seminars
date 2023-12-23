// Здесь содержатся различные глобальные переменные,
// интерфейсы, нужные для работы программы

const val greenColor = "\u001b[32m"
const val resetColor = "\u001b[0m" // to reset color to the default

var sessionId = 0
var stId = 0
var filmId = 0
var pair = Pair(0, 0)

const val pathToFilms = "films.log"
const val pathToTickets = "tickets.log"
const val pathToSessions = "sessions.log"
const val pathToUsers = "users.log"

enum class AgeLimits {
    ZeroPlus, SixPlus, TwelvePlus, SixteenPlus, EighteenPlus, NotIdentified
}

interface ICinemable {
    fun addFilm()
    fun addSession()
    fun buyTicket()
    fun returnTicket()
    fun showCurrentSessions()
    fun enterHallParameters()

}

interface IEdditable {
    fun editFilm()
    fun editSession()
}

interface IMarkable {
    fun comeToSession()
}

interface IInputer {
    fun readAgeLimit(): AgeLimits
    fun readNonZeroLong(): Long
    fun readFilmData(): Film
    fun readSessionData(listFilms: MutableList<Film>): Session?
    fun readHallParameters(): Pair<Int, Int>
    fun readInfoForTicket(list: MutableList<Session>): Ticket?
    fun readInfoForReturn(listTicket: MutableList<Ticket>): Ticket?
    fun readFilmId(listFilms: MutableList<Film>): Film?
    fun readSessionId(listSessions: MutableList<Session>): Session?
}

fun makeTextGreen(str: String): String {
    return greenColor + str + resetColor
}
