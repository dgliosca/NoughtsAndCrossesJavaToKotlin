package dojo

import dojo.Cell.O
import dojo.Cell.X
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

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

    @Test(expected = Game.InvalidMove::class)
    @Throws(Game.InvalidMove::class)
    fun playerMakesInvalidMove() {
        val game = Game()
        game.makeMove(Move(100, 100), X)
    }
}