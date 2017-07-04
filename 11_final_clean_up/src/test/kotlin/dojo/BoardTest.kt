package dojo

import dojo.Cell.Empty
import dojo.Cell.X
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class BoardTest {

    @Test
    fun setAValueOnTheBoard() {
        val lists = 0.until(3).map { List(3, { Empty }) }

        val board = Board(lists)
        val actual = board.set(0, 1, X)

        assertThat(actual[0, 1], equalTo(X))
    }
}