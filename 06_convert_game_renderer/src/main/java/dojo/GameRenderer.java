package dojo;

public class GameRenderer {
    private Game game;

    public GameRenderer(Game game) {
        this.game = game;
    }

    public String render() {
        String message;
        if (game.isGameADraw()) {
            message = "Game is a draw!";
        } else {
            message = "\n" +
                    new BoardRenderer(game.board()).render() + "\n" +
                    "Player " + game.nextCellToPlace() + " please make a move: ";
        }
        return message;
    }
}
