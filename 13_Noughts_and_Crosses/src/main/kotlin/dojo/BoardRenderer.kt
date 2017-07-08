package dojo

import dojo.Cell.*

class BoardRenderer(private val board: Board) {

    fun render() = 0.until(board.size).joinToString("-----\n") { renderRow(it) }

    private fun renderRow(row: Int) =
            0.until(board.size).joinToString("", postfix = "\n") { column ->
                renderCell(row, column) + squareSeparator(column)
            }

    private fun renderCell(row: Int, column: Int) =
            when (board[row, column]) {
                X -> "X"
                O -> "O"
                Empty -> " "
            }

    private fun squareSeparator(column: Int) = if (column < board.size - 1) "|" else ""
}
