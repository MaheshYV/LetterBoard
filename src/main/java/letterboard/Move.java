package letterboard;

import java.util.Objects;

public class Move {

    public static final char EMPTY_LETTER = 0;

    private Direction direction;
    private char letter; // use constant EMPTY_LETTER to represent nothing captured

    public Move(Direction direction, char letter) {
        this.direction = direction;
        this.letter = letter;
    }

    public Move(Direction direction) {
        this(direction, EMPTY_LETTER);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        if (letter == EMPTY_LETTER) {
            return direction.toString();
        } else {
            return direction.toString() + ':' + letter;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return letter == move.letter &&
                direction == move.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, letter);
    }
}

