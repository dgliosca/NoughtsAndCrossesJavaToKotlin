package dojo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        ConsoleUI ui = new ConsoleUI(game, in::readLine, out::println);

        ui.run();
    }
}
