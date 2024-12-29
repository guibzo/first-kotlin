object Dbutils {
    val url: String = "fodase"
    val user: String = "hello"
    val password: String = "fodase2"

    fun connect() {
        println("fodase55")
    }
}

fun main() {
    data class Values(val test: String, val world: String, val name: String, val age: Int, val heightInCm: Int)

    fun getValues(): Values {
        val test = "Hello"
        val world = "World"
        val name = "bozo"
        val age = 30
        val heightInCm = 50

        return Values(
            test = test,
            name = name,
            age = age,
            heightInCm = heightInCm,
            world = world
        )
    }

    fun getValues2(): Pair<String, String> {
        val test: String = "Hello2"
        val world: String = "World2"

        return Pair(test, world)
    }

    fun getValues3(): Triple<String, String, Int> {
        val test: String = "Hello3"
        val world: String = "World3"
        val myInt: Int = 55

        return Triple(test, world, myInt)
    }



    val values = getValues()
    val (test2, world2) = getValues2()
    val (test3, world3, myInt) = getValues3()

    Dbutils.connect()

    println(values)
    println("$test2 $world2")
    println("$test3 $world3, $myInt")
}