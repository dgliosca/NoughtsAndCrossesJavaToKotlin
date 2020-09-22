package dojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static dojo.Cell.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTests {

    @Test
    public void initialStateOfTheGame() {
        Game game = new Game();

        assertThat(game.nextCellToPlace(), equalTo(X));
        assertThat(new BoardRenderer(game.board()).render(), equalTo("" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n"
        ));
    }

    @Test
    public void crossMakesTheFirstMove() {
        Game game = new Game();
        Game gameAfterMove = game.makeMove(new Move(1, 1), X);

        assertThat(gameAfterMove.nextCellToPlace(), equalTo(O));
        assertThat(new BoardRenderer(gameAfterMove.board()).render(), equalTo("" +
                " | | \n" +
                "-----\n" +
                " |X| \n" +
                "-----\n" +
                " | | \n"
        ));
    }

    @Test
    public void playerMakesInvalidMove() {
        Game game = new Game();
        assertThrows(Game.InvalidMove.class, () -> {
            game.makeMove(new Move(100, 100), X);
        });
    }
}