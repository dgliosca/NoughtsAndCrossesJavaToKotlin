package dojo;

import java.io.IOException;
import java.util.function.Consumer;

public class ConsoleUI {
	private final FunctionThatThrows<String> in;
	private final Consumer<String> out;
	private Game game;

	public ConsoleUI(Game game, FunctionThatThrows<String> in, Consumer<String> out) {
		this.game = game;
		this.in = in;
		this.out = out;
	}

	public void run() {
		out.accept(render());

		while (!game.isGameOver()) {
			try {
				String input = in.apply();
				if (input == null)
					break;
				Move move = parseInput(input);
				game = game.makeMove(move, game.nextCellToPlace());
				out.accept(render());
			} catch (Game.InvalidMove invalidMove) {
				out.accept(invalidMove.getMessage() + "\n" + render());
			} catch (IOException e) {
				out.accept("Unrecoverable error");
			}
		}
	}

	public String render() {
        return new GameRenderer(game).render();
    }

	private Move parseInput(String input) throws Game.InvalidMove {
		try {
			String[] split = input.split(" ");
			if (split.length < 2) {
                throw new Game.InvalidMove(invalidInputMessage(input));
			}
			int row = Integer.parseInt(split[0]);
			int column = Integer.parseInt(split[1]);
			return new Move(row, column);
		} catch (NumberFormatException e) {
			throw new Game.InvalidMove(invalidInputMessage(input));
		}
	}

	private String invalidInputMessage(String s) {
		return "Invalid input '" + s + "', please make sure it's zero-indexed 'x y' coordinates";
	}
}
