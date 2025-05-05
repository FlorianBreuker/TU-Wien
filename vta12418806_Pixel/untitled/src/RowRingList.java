/**
 * A circular linked list of row numbers.
 *
 * Each node stores the y-coordinate of a row in the image.
 *
 * Useful for cyclic row traversals (e.g., scrolling through rows).
 */
//
// TODO: Complete the methods in 'RowRingList'.
//       Implement the ring list manually.
//       Do NOT use Java-Collection framework.
//
public class RowRingList {

    /**
     * Initializes 'this' as an empty ring.
     */
    public RowRingList() {
    }

    /**
     * Adds a new row with coordinate 'y' to the ring.
     *
     * @param y the y-coordinate of the row, y >= 0.
     */
    public void addRow(int y) {
    }

    /**
     * Moves to the next row and returns its y-coordinate.
     *
     * @return the next y-coordinate.
     * @throws IllegalStateException if the ring is empty.
     */
    public int nextRow() {
        throw new IllegalStateException();
    }

    /**
     * Returns 'true' if the ring is empty.
     *
     * @return 'true' if empty, otherwise 'false'.
     */
    public boolean isEmpty() {
        return true;
    }
}