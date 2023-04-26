package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = validatePosition(position);
    }

    private int validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 음수 입력 불가");
        }
        return position;
    }

    public boolean equalPosition(int otherPosition) {
        return position == otherPosition;
    }

    public int getMaxPosition(int otherPosition) {
        if (position <= otherPosition) {
            return otherPosition;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public Position move()
    {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}