package dojo

import java.util.*

class Board(private val grid: List<List<Cell>>) {

    constructor(board: Board) : this(board.grid)

    operator fun set(row: Int, column: Int, value: Cell): Board {
        val gridCopy = grid.map { ArrayList(it) }
        gridCopy[row][column] = value
        return Board(gridCopy)
    }

    operator fun get(row: Int, column: Int) = grid[row][column]

    fun size() = grid.size

    fun isFull(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun all(coordinates: List<Pair<Int, Int>>, cell: Cell): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
