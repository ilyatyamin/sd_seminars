import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
/**
 * Класс "Пользователь"
 * Характеризируется логином, паролем и находится в системе или нет
 */
class User(var login: String, var password: String) {
    var isLogged: Boolean = false

    fun buyProduct(nameOfProduct: String, num: Int, cardNum_: String) {
        val good = listOfGoods.find { it.name == nameOfProduct }
        if (good != null && good.isEnoughGoods(-num)) {
            good.changeNumOfGoods(-num)
            payForProduct(nameOfProduct, cardNum_)
            if (good.count <= 0) {
                listOfGoods.remove(good)
            }
        } else if (good != null && !good.isEnoughGoods(-num)) {
            println(greenColor + "Попытка купить $nameOfProduct. Количество товаров недопустимо (столько просто нет)." + reset)
        } else {
            println(greenColor + "Такого товара нет в базе данных." + reset)
        }
        writer.write(Json.encodeToString(listOfGoods), "goods.txt")
    }

    private fun payForProduct(nameOfProduct: String, cardNum_: String) {
        listOfTransactions.add(Transaction(cardNum_, nameOfProduct))
        writer.write(Json.encodeToString(listOfTransactions), "transactions.txt")
        println(
            greenColor + "Товар был успешно оплачен. Название: $nameOfProduct. Номер карты (последние 4): ${
                cardNum_.toString().takeLast(4)
            }" + reset
        )
    }

    fun viewProductList() {
        for (good in listOfGoods) {
            print(good)
        }
    }

    fun exit() {
        isLogged = false
        writer.write(Json.encodeToString(listOfUsers), "users.txt")
    }
}

fun loginToUser(inputedLogin: String, inputedPasword: String): User? {
    val potentialUser: User? = listOfUsers.find { it.login == inputedLogin && it.password == inputedPasword }
    if (potentialUser != null) {
        potentialUser.isLogged = true
        println(greenColor + "Вход выполнен верно. Login: $inputedLogin" + reset)
        writer.write(Json.encodeToString(listOfUsers), "users.txt")
        return potentialUser
    }
    println(greenColor + "Ошибка входа! Введите повторно данные!" + reset)
    writer.write(Json.encodeToString(listOfUsers), "users.txt")
    return null
}