import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

var listOfGoods: MutableList<Good> = mutableListOf()
var listOfTransactions: MutableList<Transaction> = mutableListOf()
var listOfUsers: MutableList<User> = mutableListOf()
val writer = FileWriter()
var idTransaction = 0

const val greenColor = "\u001b[32m"
const val reset = "\u001b[0m" // to reset color to the default

fun main() {
    ReadDataFromFile()

    if (listOfGoods.isEmpty()) {
        initialiseGoods()
        writer.write(Json.encodeToString(listOfGoods), "goods.txt")
        writer.write(Json.encodeToString(listOfTransactions), "transactions.txt")
        writer.write(Json.encodeToString(listOfUsers), "users.txt")
    }

    var inSystem = false
    var userInSystem: User? = null

    var inputCommand : Int
    do {
        writeMenu(inSystem)
        inputCommand = readln().toInt()
        if (!inSystem) {
            when (inputCommand) {
                1 -> {
                    print("Введите логин: ")
                    val potentialLogin = readln()
                    print("Введите пароль: ")
                    val potentialPassw = readln()
                    val user = loginToUser(potentialLogin, potentialPassw)
                    if (user != null) {
                        inSystem = true
                        userInSystem = user
                    }
                }

                2 -> {
                    print("Введите логин: ")
                    val potentialLogin = readln()
                    print("Введите пароль: ")
                    val potentialPassw = readln()
                    registerNewUser(potentialLogin, potentialPassw)
                }

                3 -> {
                    break
                }
            }
        } else {
            when (inputCommand) {
                1 -> {
                    userInSystem?.viewProductList()
                }

                2 -> {
                    print("Введите название товара: ")
                    val nameGood = readln()
                    print("Введите количество, которое хотите купить: ")
                    val counter = readln().toInt()
                    print("Введите номер своей карточки :)) ")
                    val cardNum = readln()
                    userInSystem?.buyProduct(nameGood, counter, cardNum)
                }

                3 -> {
                    userInSystem?.exit()
                    inSystem = false
                }
            }
        }
    } while (inputCommand != -1)
}