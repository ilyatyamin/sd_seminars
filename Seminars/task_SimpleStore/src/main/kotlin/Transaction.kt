import kotlinx.serialization.Serializable

@Serializable
/**
 * Класс "Транзакция"
 * @constructor номер карты и название товара
 */
class Transaction(var cardNum: String, var nameOfGood: String) {
    private var id: Int = ++idTransaction

    override fun toString(): String {
        return greenColor + "Transaction with num $id. Name of good: $nameOfGood. Card num: ${
            cardNum.takeLast(4)
        }" + reset
    }
}
