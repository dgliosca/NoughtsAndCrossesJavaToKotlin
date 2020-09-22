package dojo

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import com.natpryce.hamkrest.throws
import dojo.Cell.*

import org.junit.jupiter.api.Test

class GameTests {

    @Test
    fun `initial state of the game`() {
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

    @Test fun `cross makes the first move`() {
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
    fun `player makes invalid move`() {
        val game = Game()
        assertThat({ game.makeMove(Move(100, 100), X) }, throws(has(Game.InvalidMove::message, equalTo("Invalid move: (100,100) it must be between 0 and 2"))))
    }

    @Test
    fun `player try to make a move in a location already taken`() {
        val game = Game()
        val firstMoveGame = game.makeMove(Move(0, 0), game.nextCellToPlace())
        assertThat({ firstMoveGame.makeMove(Move(0, 0), game.nextCellToPlace()) }, throws(has(Game.InvalidMove::message, equalTo("Invalid move: (0,0) position already taken."))))
    }

    @Test fun `game is over`() {
        val game = Game(Board(listOf(
            listOf(X, X, O),
            listOf(O, X, X),
            listOf(X, O, O))), X)

        assertThat(game.isGameOver, equalTo(true))
    }
}