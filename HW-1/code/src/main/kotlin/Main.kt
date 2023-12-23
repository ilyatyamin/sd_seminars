fun main() {
    println("--- Приложение для работников кинотеатра ---")

    // Инициализируем работы систему
    val inputer = ConsoleInputer()
    val cinema = System(inputer)

    // Предусматриваем вход администраторов в систему
    while (!cinema.isEntered) {
        println("Вы не авторизованы. " + makeTextGreen("Введите 1, если вы зарегистрированы в системе или 2, если хотите зарегистрироваться"))
        var choice = readln().toIntOrNull()
        while (choice == null || choice < 1 || choice > 2) {
            println("Неверный ввод. Повторите ввод. ")
        }
        // Пользователь или входит в систему, или регистрируется в ней
        when (choice) {
            1 -> {
                print("Введите логин -> ")
                val login = readln()
                print("Введите пароль -> ")
                val passw = readln()

                var user = cinema.isCorrectUser(login, passw)
                // Если попытка входа успешна, то мы авторизировались
                if (user != null) {
                    println("${user.login}, вы успешно авторизованы!")
                }
            }

            2 -> {
                println("Введите логин для входа в аккаунт -> ")
                val login = readln()
                println("Введите пароль для входа в аккаунт -> ")
                val passw = readln()
                cinema.addNewUser(login, passw)
            }
        }
    }

    // В зависимости от ввода пользователя, система производит определенные действия
    var choice = cinema.printMenu()
    do {
        when (choice) {
            1 -> {
                cinema.addFilm()
                println()
            }

            2 -> {
                cinema.addSession()
                println()
            }

            3 -> {
                cinema.buyTicket()
                println()
            }

            4 -> {
                cinema.returnTicket()
                println()
            }

            5 -> {
                cinema.showCurrentSessions()
                println()
            }

            6 -> {
                cinema.editFilm()
                println()
            }

            7 -> {
                cinema.editSession()
                println()
            }

            8 -> {
                cinema.comeToSession()
                println()
            }
        }
        choice = cinema.printMenu()
    } while (choice != 9)
    // команда "9" является выходом из программы
}