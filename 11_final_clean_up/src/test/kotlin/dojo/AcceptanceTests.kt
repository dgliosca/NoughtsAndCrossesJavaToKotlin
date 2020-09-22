package dojo

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class AcceptanceTests {

    private var game: Game? = null
    private var inputs: LinkedList<String>? = null
    private var outputs: LinkedList<String>? = null
    private var ui: ConsoleUI? = null

    @BeforeEach
    fun setUp() {
        game = Game()
        inputs = LinkedList<String>()
        outputs = LinkedList<String>()
        ui = ConsoleUI(game!!, object : FunctionThatThrows<String?> {
            override fun apply() =
                if (inputs!!.isEmpty())
                    null
                else
                    inputs!!.pop()

        }) { outputs!!.push(it) }
    }

    @Test
    @Throws(Exception::class)
    fun aGameInWhichNoughtsWin() {
        ui!!.run()
        assertThat(outputs!!.pollFirst(), equalTo("" +
            "\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player X please make a move: "
        ))

        inputs!!.add("0 0")
        ui!!.run()
        assertThat(outputs!!.pollFirst(), equalTo("" +
            "\n" +
            "X| | \n" +
            "-----\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player O please make a move: "
        ))

        inputs!!.add("1 1")
        ui!!.run()
        assertThat(ui!!.render(), equalTo("" +
            "\n" +
            "X| | \n" +
            "-----\n" +
            " |O| \n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player X please make a move: "
        ))

        inputs!!.add("1 2")
        ui!!.run()
        assertThat(ui!!.render(), equalTo("" +
            "\n" +
            "X| | \n" +
            "-----\n" +
            " |O|X\n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player O please make a move: "
        ))

        inputs!!.add("0 2")
        ui!!.run()
        assertThat(ui!!.render(), equalTo("" +
            "\n" +
            "X| |O\n" +
            "-----\n" +
            " |O|X\n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player X please make a move: "
        ))

        inputs!!.add("1 0")
        ui!!.run()
        assertThat(ui!!.render(), equalTo("" +
            "\n" +
            "X| |O\n" +
            "-----\n" +
            "X|O|X\n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player O please make a move: "
        ))

        inputs!!.add("2 0")
        ui!!.run()

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
    @Throws(Exception::class)
    fun gameIsADraw() {
        //TODO implement later
    }

    @Test
    @Throws(Exception::class)
    fun handleInvalidInputString() {
        inputs!!.add("some string")
        ui!!.run()

        assertThat(outputs!!.pollFirst(), equalTo("" +
            "Invalid input 'some string', please make sure it's zero-indexed 'x y' coordinates\n" +
            "\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player X please make a move: "
        ))
    }

    @Test
    @Throws(Exception::class)
    fun handleInvalidInputNumber() {
        inputs!!.add("123")
        ui!!.run()

        assertThat(outputs!!.pollFirst(), equalTo("" +
            "Invalid input '123', please make sure it's zero-indexed 'x y' coordinates\n" +
            "\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "\n" +
            "Player X please make a move: "
        ))
    }
}
