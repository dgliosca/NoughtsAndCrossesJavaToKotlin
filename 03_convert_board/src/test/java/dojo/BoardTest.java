package dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static dojo.Cell.Empty;
import static dojo.Cell.X;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void setAValueOnTheBoard() {
        List<List<Cell>> lists = IntStream.range(0, 3)
                .mapToObj(index -> new ArrayList<>(asList(Empty, Empty, Empty)))
                .collect(toList());
        Board board = new Board(lists);
        Board updatedBoard = board.set(0, 1, X);

        assertThat(updatedBoard.get(0, 1), equalTo(X));
    }
}