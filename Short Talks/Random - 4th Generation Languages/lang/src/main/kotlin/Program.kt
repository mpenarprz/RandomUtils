import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import prz.lang.SimpleLexer
import prz.lang.SimpleParser

private fun eval(tree: SimpleParser.ExpressionContext) : Double{
    val value = tree.atom()?.text!!.toDouble()
    return when(tree.OP()?.text){
        "+" -> eval(tree.expression()) + value
        "-" -> eval(tree.expression()) - value
        "*" -> eval(tree.expression()) * value
        "/" -> eval(tree.expression()) / value
        else -> value
    }
}

fun eval(text: String): Number = text.let {
    val chars = CharStreams.fromString(text)
    val lexer = SimpleLexer(chars)
    val tokenStream = CommonTokenStream(lexer)
    val parser = SimpleParser(tokenStream)
    return eval(parser.expression())
}

fun main(){
    println(1)
    println(eval("1"))
    println(eval("99"))
    println(eval("99 + 1"))
    println(eval("9/3 * 10"))
}