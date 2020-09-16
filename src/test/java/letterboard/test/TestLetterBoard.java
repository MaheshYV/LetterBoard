package letterboard.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import deem.internal.tests.BaseTest;
import letterboard.Direction;
import letterboard.LetterBoard;
import letterboard.Move;

public class TestLetterBoard extends BaseTest {

	// TODO: add additional test cases here of other patterns that concern you, all
	// test cases you add must pass

	@Test
	public void testLetterBoardWithCat() {
		List<Character> testBoard = Stream.of('a', 'z', 'c', 't', 'v', 'a').collect(Collectors.toList());
		String word = "cat";

		List<Move> moves = LetterBoard.solveLetterBoard(testBoard, word);
		List<Move> expected = Arrays.asList(/* c */ new Move(Direction.Left), new Move(Direction.Left),
				new Move(Direction.Left, 'c'), /* a */ new Move(Direction.Right), new Move(Direction.Right, 'a'),
				/* t */ new Move(Direction.Left), new Move(Direction.Left, 't'));

		assertMovesEqual(expected, moves);
	}

	@Test
	public void testLetterBoardWithTV() {
		List<Character> testBoard = Stream.of('a', 'z', 'c', 't', 'v', 'a').collect(Collectors.toList());
		String word = "tv";

		List<Move> moves = LetterBoard.solveLetterBoard(testBoard, word);
		List<Move> expected = Arrays.asList(/* t */ new Move(Direction.Right), new Move(Direction.Right),
				new Move(Direction.Right, 't'), /* v */ new Move(Direction.Left, 'v'));

		assertMovesEqual(expected, moves);
	}

	private void assertMovesEqual(List<Move> expected, List<Move> actual) {
		Assert.assertArrayEquals(expected.toArray(new Move[0]), actual.toArray(new Move[0]));
	}

}
