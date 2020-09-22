package dojo

import java.io.IOException
import java.util.function.Consumer

class ConsoleUI(private var game: Game, private val `in`: FunctionThatThrows<String?>, private val out: Consumer<String>) {

    fun run() {
        out.accept(render())

        while (!game.isGameOver) {
            try {
                val input = `in`.apply() ?: break
                val move = parseInput(input)
                game = game.makeMove(move, game.nextCellToPlace())
                out.accept(render())
            } catch (invalidMove: Game.InvalidMove) {
                out.accept(invalidMove.message + "\n" + render())
            } catch (e: IOException) {
                out.accept("Unrecoverable error")
            }

        }
    }

    fun render() = GameRenderer(game).render()

    private fun parseInput(input: String): Move {
        try {
            val split = input.split(" ")
            if (split.size < 2) {
                throw Game.InvalidMove(invalidInputMessage(input))
            }
            val row = Integer.parseInt(split[0])
            val column = Integer.parseInt(split[1])
            return Move(row, column)
        } catch (e: NumberFormatException) {
            throw Game.InvalidMove(invalidInputMessage(input))
        }

    }

    private fun invalidInputMessage(s: String) = "Invalid input '$s', please make sure it's zero-indexed 'x y' coordinates"
}
