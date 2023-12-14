import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
/**
 * Класс "Товар"
 * @constructor имя товара, его цена и количество на складе
 */
class Good(var name: String, var price: Int, var count: Int) {
    fun isEnoughGoods(counter: Int): Boolean {
        if (counter < 0) {
            return counter + count >= 0
        } else {
            return true
        }
    }

    fun changeNumOfGoods(adder: Int) {
        count += adder
        writer.write(Json.encodeToString(listOfUsers), "goods.txt")
    }

    override fun toString(): String {
        return greenColor + "Name: $name.\tPrice: $price.\tCount: $count. \n" + reset
    }
}