package dojo

import org.junit.Test

import java.util.ArrayList
import java.util.stream.IntStream

import dojo.Cell.Empty
import dojo.Cell.X
import java.util.Arrays.asList
import java.util.stream.Collectors.toList
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat

class BoardTest {

    @Test
    fun setAValueOnTheBoard() {
        val board = Board(List(3, { List(3, { Empty }) }))
        val updatedBoard = board.set(0, 1, X)

        assertThat(updatedBoard[0, 1], equalTo(X))
    }
}