class Person(
    private var name: String,
    private var age: Int,
    private var heightInCentimeters: Int
) {
    // o companion object cria membros estáticos - associados á própria classe, e não ás suas instâncias
    // substitui o conceito de "static"
    companion object {
        private const val NUMBER_TWO: Int = 0

        fun increment() {
            var mirror: Int = NUMBER_TWO
            mirror++
            println(mirror)
        }
    }

    fun getHeight(): Int {
        return heightInCentimeters
    }

    fun getName(): String {
        return name.uppercase()
    }

    fun getAge(): Int {
        return age
    }


    // a diferença de usar getters e setters via funções (como acima) pra usar get() e set() é que por funções, usa-se por exemplo Person.getHeight(),
    // enquanto por getters, seria apenas Person.heightInMeters
    // no setter, o parâmetro que ele recebe é o param enviado por quem usa o setter.
    // pode-se usar o valor especial "field", que se refere ao próprio item (nesse caso, heightInMeters)
    val heightInMeters: Float
        get() = (heightInCentimeters / 100).toFloat()
}

open class Animal(private val name: String) {
    open val age: Int = 0

    fun printAge() {
        println("age: $age")
    }

    fun printName() {
        println("name: $name")
    }
}

class Dog(override val age: Int = 10): Animal(name = "dogdog") {
    fun printDog() {
        println(this.printName())
        this.printAge()
    }
}

abstract class Vehicle(val color: String) {
    abstract val maxSpeed: Int
    abstract val wheelsAmount: Int

    abstract fun startEngine()
}

class Car(color: String): Vehicle(color = color) {
    override val maxSpeed: Int
        get() = 40
    override val wheelsAmount: Int
        get() = 4

    override fun startEngine() {
        println("Ligando motor de carro")
    }
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(private val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun getRgb(): Int {
        return rgb
    }
}

enum class Buttons(private val className: String, private val textClassName: String, private val containerClassName: String) {
    DEFAULT(
        className = "text-xl",
        containerClassName = "pb-1",
        textClassName = "text-white",
    ),
    OUTLINE(
        className = "text-xl text-blue-500",
        containerClassName = "pb-1",
        textClassName = "text-white",
    ),
    GHOST(
        className = "text-xl border-none",
        containerClassName = "pb-1",
        textClassName = "text-white",
    );

    data class Classname(val className: String, val textClassName: String, val containerClassName: String)

    fun getClassName(): Classname {
        return Classname(
            className,
            textClassName,
            containerClassName
        )
    }
}

fun main() {
    Person.increment()
    val person = Person(name = "bozo", age = 30, heightInCentimeters = 150)

    println(person.getName())
}