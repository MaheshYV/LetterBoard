package letterboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterBoard {

	public static List<Move> solveLetterBoard(List<Character> board, String word) {

		List<Character> b = new ArrayList<>();
		b.addAll(board);

		List<Move> moveList = new ArrayList<>();

		if (word != null && !word.isEmpty()) {

			for (int i = 0; i < word.length(); i++) {

				char c = word.charAt(i);

				boolean cFound = false;

				while (!cFound) {

					List<Character> reverseBoard = new ArrayList<>(b);
					Collections.reverse(reverseBoard);

					int leftIndex = b.indexOf(c);

					int rightIndex = reverseBoard.indexOf(c);

					Move move = null;

					if (leftIndex <= rightIndex) {

						char fChar = b.get(0);

						if (fChar == c) {
							cFound = true;
							move = new Move(Direction.Left, c);
							b.remove(0);

						} else {
							move = new Move(Direction.Left);

							b.add(fChar);
							b.remove(0);

						}
					} else if (leftIndex > rightIndex) {
						char lastChar = b.get(b.size() - 1);

						if (lastChar == c) {
							cFound = true;
							move = new Move(Direction.Right, c);

							b.remove(b.size() - 1);

						} else {
							move = new Move(Direction.Right);

							b.add(0, lastChar);
							b.remove(b.size() - 1);

						}

					}

					moveList.add(move);

					if (cFound) {
						break;
					}

				}

			}

		}

		return moveList;

	}

}