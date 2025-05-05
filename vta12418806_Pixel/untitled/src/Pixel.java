/**
 * Represents a pixel with a position and a grey level.
 *
 * Grey level must be between 0 and 9.
 */
//
// TODO: Complete the methods in 'Pixel'.
//       No Java-Collection framework.
//
public class Pixel {

    private Point position;
    private int greyLevel;

    /**
     * Initializes this pixel with the given position and grey level.
     *
     * @param position the position, position != null.
     * @param greyLevel the grey level, 0 <= greyLevel <= 9.
     */
    public Pixel(Point position, int greyLevel) {
    }

    /**
     * Returns the position.
     *
     * @return the position.
     */
    public Point getPosition() {
        return null;
    }

    /**
     * Returns the grey level.
     *
     * @return the grey level.
     */
    public int getGreyLevel() {
        return 0;
    }

    /**
     * Checks whether this pixel is equal to another pixel.
     * Two pixels are equal if their positions and grey levels are equal.
     *
     * @param o the other object.
     * @return 'true' if equal, otherwise 'false'.
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /**
     * Returns a hash code based on position and grey level.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return 0;
    }
}