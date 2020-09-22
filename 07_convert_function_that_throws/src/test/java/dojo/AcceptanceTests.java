package dojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AcceptanceTests {

    private LinkedList<String> inputs;
    private LinkedList<String> outputs;
    private ConsoleUI ui;

    @BeforeEach
    public void setUp() {
        Game game = new Game();
        inputs = new LinkedList<>();
        outputs = new LinkedList<>();
        ui = new ConsoleUI(game, () -> {
            if (inputs.isEmpty()) return null;
            else return inputs.pop();
        }, outputs::push);
    }

    @Test
    public void aGameInWhichNoughtsWin() {
        ui.run();
        assertThat(outputs.pollFirst(), equalTo("" + "" +
                "\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player X please make a move: "
        ));

        inputs.add("0 0");
        ui.run();
        assertThat(outputs.pollFirst(), equalTo("" +
                "\n" +
                "X| | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player O please make a move: "
        ));

        inputs.add("1 1");
        ui.run();
        assertThat(ui.render(), equalTo("" +
                "\n" +
                "X| | \n" +
                "-----\n" +
                " |O| \n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player X please make a move: "
        ));

        inputs.add("1 2");
        ui.run();
        assertThat(ui.render(), equalTo("" +
                "\n" +
                "X| | \n" +
                "-----\n" +
                " |O|X\n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player O please make a move: "
        ));

        inputs.add("0 2");
        ui.run();
        assertThat(ui.render(), equalTo("" +
                "\n" +
                "X| |O\n" +
                "-----\n" +
                " |O|X\n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player X please make a move: "
        ));

        inputs.add("1 0");
        ui.run();
        assertThat(ui.render(), equalTo("" +
                "\n" +
                "X| |O\n" +
                "-----\n" +
                "X|O|X\n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player O please make a move: "
        ));

        inputs.add("2 0");
        ui.run();

//         TODO implement later
//	    assertThat(ui.render(), equalTo("" +
//              "\n" +
//	            "X| |O\n" +
//	            "-----\n" +
//	            "X|O|X\n" +
//	            "-----\n" +
//	            "O| | \n" +
//	            "\n" +
//	            "O is the winner!\n"
//	    ));
    }

    @Test
    public void gameIsADraw() {
        //TODO implement later
    }

    @Test
    public void handleInvalidInputString() {
        inputs.add("some string");
        ui.run();

        assertThat(outputs.pollFirst(), equalTo("" +
                "Invalid input 'some string', please make sure it's zero-indexed 'x y' coordinates\n" +
                "\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player X please make a move: "
        ));
    }

    @Test
    public void handleInvalidInputNumber() {
        inputs.add("123");
        ui.run();

        assertThat(outputs.pollFirst(), equalTo("" +
                "Invalid input '123', please make sure it's zero-indexed 'x y' coordinates\n" +
                "\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "\n" +
                "Player X please make a move: "
        ));
    }
}
