package dojo

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.function.Consumer

fun main(args: Array<String>) {
    val game = Game()

    val `in` = BufferedReader(InputStreamReader(System.`in`))
    val out = System.out
    val ui = ConsoleUI(game, object : FunctionThatThrows<String?> {
        override fun apply() = `in`.readLine()
    }, Consumer<String> { out.println(it) })

    ui.run()
}