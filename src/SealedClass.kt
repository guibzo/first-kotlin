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