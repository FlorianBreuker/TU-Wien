/**
 * Represents a position (x, y) in a 2D raster.
 *
 * x and y must be non-negative integers.
 */
//
// TODO: Complete the methods in 'Point'.
//       No Java-Collection framework.
//
public class Point {

    private int x;
    private int y;

    /**
     * Initializes this point with the given coordinates.
     *
     * @param x x-coordinate, x >= 0.
     * @param y y-coordinate, y >= 0.
     */
    public Point(int x, int y) {
    }

    /**
     * Returns the x-coordinate.
     *
     * @return x-coordinate.
     */
    public int getX() {
        return 0;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return y-coordinate.
     */
    public int getY() {
        return 0;
    }

    /**
     * Checks whether this point is equal to another point.
     * Two points are equal if their x and y coordinates are equal.
     *
     * @param o the other object.
     * @return 'true' if equal, otherwise 'false'.
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /**
     * Returns a hash code based on x and y.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
