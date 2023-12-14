abstract class Figure {
    abstract fun GetVolume(): Double;
    abstract fun GetProjectionBase(): Double;
    abstract fun GetProjectionScanner(): Double;
}

class Cone(val height: Double, val diametr: Double) : Figure() {
    override fun GetVolume(): Double {
        return (Math.PI * diametr * diametr * height) / 12
    }

    override fun GetProjectionBase(): Double {
        return Math.PI * diametr * diametr / 4
    }

    override fun GetProjectionScanner(): Double {
        return (height * diametr) / 2
    }
}

class Cube(val side: Double) : Figure() {
    override fun GetVolume(): Double {
        return Math.pow(side, 3.0)
    }

    override fun GetProjectionBase(): Double {
        return Math.pow(side, 2.0)
    }

    override fun GetProjectionScanner(): Double {
        return Math.pow(side, 2.0)
    }
}

class Pyramid(val height: Double, val side: Double) : Figure() {
    override fun GetVolume(): Double {
        return (side * side * height) / 3.0
    }

    override fun GetProjectionBase(): Double {
        return Math.pow(side, 2.0)
    }

    override fun GetProjectionScanner(): Double {
        return (side * height / 2).toDouble();
    }

}

fun main(args: Array<String>) {
    print("Введите тип фигуры: ")
    val typeFigure = readln()
    print("Введите высоту фигуры: ")
    val heightFig = readln().toDouble()
    print("Введите основание/диаметр фигуры: ")
    val sideFig = readln().toDouble()

    if (typeFigure.lowercase() == "конус") {
        var fig = Cone(heightFig, sideFig)
        println("Объем $typeFigure: ${fig.GetVolume()}")
        println("Площадь боковой проекции: ${fig.GetProjectionScanner()}")
        println("Площадь проекции сверху: ${fig.GetProjectionBase()}")
    }
    else if (typeFigure.lowercase() == "куб") {
        var fig = Cube(heightFig)
        println("Объем $typeFigure: ${fig.GetVolume()}")
        println("Площадь боковой проекции: ${fig.GetProjectionScanner()}")
        println("Площадь проекции сверху: ${fig.GetProjectionBase()}")
    }
    else if (typeFigure.lowercase() == "пирамида") {
        var fig = Pyramid(heightFig, sideFig)
        println("Объем $typeFigure: ${fig.GetVolume()}")
        println("Площадь боковой проекции: ${fig.GetProjectionScanner()}")
        println("Площадь проекции сверху: ${fig.GetProjectionBase()}")
    }

}