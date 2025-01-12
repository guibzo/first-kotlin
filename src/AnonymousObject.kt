interface OnClickCallback {
    fun onClick()
}

fun main() {
    val objectTemp = object {
        val property = 1
        val property2= 2

        fun method() {
            println("Temp. object method")
        }
    }

    // implements OnClickCallback
    val buttonCallback = object : OnClickCallback {
        override fun onClick() {
            println("Button callback!")
        }
    }

    objectTemp.method()
    buttonCallback.onClick()
}