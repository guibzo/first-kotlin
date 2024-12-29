data class Document(val text: String)

interface Printer {
    fun print(text: String): Document

    val printerType: String
}

interface TextConverter {
    fun convert(text: String, printerType: String): String
}

class PdfPrinter: Printer, TextConverter {
    override val printerType: String
        get() = "PDF"

    override fun convert(text: String, printerType: String): String {
        println("Converting text '$text' to type '$printerType'")
        return text
    }

    override fun print(text: String): Document {
        convert(text, printerType)
        println("Printing $text")
        return Document(text)
    }
}

fun main() {
    val PDF = PdfPrinter()

    println(PDF.print("hello"))
}