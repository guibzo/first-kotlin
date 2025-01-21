// "sealed" apenas pode ser usado dentro do mesmo módulo
// permite que o compilador saiba todas as subclasses disponíveis no "when"
// sealed class tem 2 subclasses 1 objeto. uma função que receber um parâmetro do tipo daquela sealed class, poderá usar o when e acessar as subclasses
// sealed interfaces permitem herança multipla e não armazenam estado (propriedades).
// sealed classes não permitem herança múltipla e sim única, além de permitirem o armazenamento de estado (propriedades).
sealed interface Animal2 {
    fun sound(): String

    data class Cat(val color: String): Animal2 {
        override fun sound(): String {
            return "miau"
        }
    }

    data class Dog(val breed: String) : Animal2 {
        override fun sound(): String {
            return "au"
        }
    }
}

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()
}

fun handleResult(result: Result) {
    val data = when(result) {
        is Result.Error -> "Deu erro. ${result.exception.message}"
        is Result.Loading -> "Carregando..."
        is Result.Success -> "Sucesso! ${result.data}"
    }

    println(data)
}

// data object é um singleton
// data objects combinam os conceitos de data class e object. um data object tem os métodos toString, equals e hashCode de forma automática (tal como data class)
// altamente recomendado imutabilidade (val)
// representa configurações globais ou valores únicos
data object Database {
    fun getContacts(): Result {
        val contacts = listOf("João", "Maria", "Marcos").joinToString()
        return Result.Success(data = contacts)
    }

    fun insertContact(contact: String): Result {
        return Result.Error(exception = IllegalArgumentException("Caracteres mínimos insuficientes."))
    }

    fun update(id: Int, newContact: String): Result {
        return Result.Loading
    }
}

fun main() {
    val contacts = Database.getContacts()
    val insertContact = Database.insertContact(contact = "Fernando")
    val updateContact = Database.update(id = 10, newContact = "Novo contato")

    handleResult(updateContact)
    handleResult(contacts)
    handleResult(insertContact)
}