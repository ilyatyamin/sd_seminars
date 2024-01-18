import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Регистрирует нового пользователя и сериализует его
 */
fun registerNewUser(login: String, password: String) {
    listOfUsers.add(User(login, password))
    writer.write(Json.encodeToString(listOfUsers), "users.txt")
    println(greenColor + "Пользователь с логином $login был зарегистрирован!" + reset)
}

/**
 * Печатает меню программы
 */
fun writeMenu(inSystem: Boolean) {
    println("Введите номер операции: ")
    if (inSystem) {
        println("1. Посмотреть доступный в магазине список товаров")
        println("2. Купить какой-то товар. Вам необходимо будет ввести его название и количество.")
        println("3. Выйти из аккаунта.")
        println("Введите -1, если хотите выйти из программы ")
        print("Ваш ввод: ")
    } else {
        println("1. Войти в аккаунт. Вам будет необходимо ввести логин и пароль.")
        println("2. Зарегистрироваться.")
        println("3. Выйти из программы. ")
        println("Введите -1, если хотите выйти из программы ")
        print("Ваш ввод: ")
    }
}

/**
 * Метод выполняется при запуске программы
 * Добавляет в список товаров некоторые тестовые товары
 */
fun initialiseGoods() {
    // Заполним каким-то списком товаров
    listOfGoods.add(Good("Сникерс", 50, 100))
    listOfGoods.add(Good("Мука", 100, 10))
    listOfGoods.add(Good("Самосвал", 1000000, 1))
    listOfGoods.add(Good("Вода", 40, 1000))
}

/**
 * Метод выполняется при старте работы main()
 * Пытается инициализировать списки пользователей, товаров, если они уже были до этого запуска программы
 * Если их не было, то ничего не происходит
 */
fun ReadDataFromFile() {
    try {
        listOfGoods = Json.decodeFromString(writer.read("goods.txt")!!)
    } catch (_: Exception) {
        println("Error in first read")
    }
    try {
        listOfUsers = Json.decodeFromString(writer.read("users.txt")!!)
    } catch (_ : Exception) {

    }
    try {
        listOfTransactions = Json.decodeFromString(writer.read("transactions.txt")!!)
    } catch (_ : Exception) {

    }
}