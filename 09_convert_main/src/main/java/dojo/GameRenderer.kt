package dojo

class GameRenderer(private val game: Game) {

    fun render() =
        if (game.isGameADraw) {
            "Game is a draw!"
        } else {
            "\n" +
                BoardRenderer(game.board()).render() + "\n" +
                "Player " + game.nextCellToPlace() + " please make a move: "
        }
}
