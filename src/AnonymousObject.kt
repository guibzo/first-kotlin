interface ClickListener {
    fun onClickFn()
}

interface OnClickCallback {
    fun onClick()
}

fun main() {
    // objeto comum; Singleton
    // útil pra criar helpers, configurações globais ou gerenciadores de estado
    val objectTemp = object {
        val property = 1
        val property2= 2

        fun method() {
            println("Temp. object method")
        }
    }
    objectTemp.method()

    //  objeto anônimo é declarado como um objeto que implementa uma interface ou [...]
    //  [...] uma classe abstrata no momento em que são necessários, sem declarar uma classe concreta separada
    // implementa OnClickCallback
    val buttonCallback = object : OnClickCallback {
        override fun onClick() {
            println("Button callback!")
        }
    }

    buttonCallback.onClick()

    // exemplo 2 com objeto anônimo
    fun setClickListener(listener: ClickListener) {
        listener.onClickFn()
    }

    setClickListener(object : ClickListener {
        override fun onClickFn() {
            println("Botão clicado!")
        }
    })
}