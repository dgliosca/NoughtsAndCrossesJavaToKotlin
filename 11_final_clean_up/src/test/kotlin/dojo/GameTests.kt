package dojo

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import dojo.Cell.O
import dojo.Cell.X
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class GameTests {

    @Test
    fun initialStateOfTheGame() {
        val game = Game()

        assertThat(game.nextCellToPlace(), equalTo(X))
        assertThat(BoardRenderer(game.board()).render(), equalTo("" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n"
        ))
    }

    @Test
    @Throws(Game.InvalidMove::class)
    fun crossMakesTheFirstMove() {
        val game = Game()
        val gameAfterMove = game.makeMove(Move(1, 1), X)

        assertThat(gameAfterMove.nextCellToPlace(), equalTo(O))
        assertThat(BoardRenderer(gameAfterMove.board()).render(), equalTo("" +
                " | | \n" +
                "-----\n" +
                " |X| \n" +
                "-----\n" +
                " | | \n"
        ))
    }

    @Test
    fun playerMakesInvalidMove() {
        val game = Game()
        assertThrows(Game.InvalidMove::class.java) { game.makeMove(Move(100, 100), X) }
    }
}