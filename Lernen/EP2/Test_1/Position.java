/**
 * This class represents positions with integer coordinates in 2D. Two positions can be compared
 * for order using the method {@code compareTo}.
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructs a {@code Position} with the specified x and y coordinates.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public Position(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * Compares this position with the specified position for order.
     *
     * The natural order is defined by first comparing the x-coordinates.
     * If these are equal, the y-coordinates are compared. This corresponds to column-major order.
     * A positive return value indicates that this position is greater than the specified one,
     * a negative value indicates it is less, and 0 indicates equality.
     *
     * Note: This implementation returns 1 if p.x < this.x and -1 if p.x > this.x.
     * Similarly, when x-coordinates are equal, it returns 1 if p.y < this.y
     * and -1 if p.y > this.y. Otherwise, it returns 0.
     *
     * @param p the position to be compared; {@code p != null}.
     * @return a negative integer, zero, or a positive integer as this position is
     *         less than, equal to, or greater than the specified position.
     */
    public int compareTo(Position p) {

        if (p.x < this.x) {
            return 1;
        } else if (p.x > this.x) {
            return -1;
        }
        return p.y < this.y ? 1 : p.y > this.y ? -1 : 0;
    }

    /**
     * Returns the x-coordinate of this position.
     *
     * @return the x-coordinate.
     */
    public int getX() {

        return x;
    }

    /**
     * Returns the y-coordinate of this position.
     *
     * @return the y-coordinate.
     */
    public int getY() {

        return y;
    }

    /**
     * Returns the coordinates of this position in brackets as a string
     * in the form "[x, y]", e.g., "[4, 9]".
     * @return {@code this} represented as a string.
     */
    public String toString() {

        return "[" + x + ", " + y + "]";
    }
}

