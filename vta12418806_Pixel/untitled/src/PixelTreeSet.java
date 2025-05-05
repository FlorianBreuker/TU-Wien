/**
 * A set of 'Pixel' objects implemented as a binary search tree.
 * Pixels are ordered according to their position: first by 'y' coordinate (row),
 * and if equal, by 'x' coordinate (column).
 * Pixels with the same coordinates (x,y) but different grey levels are treated as different.
 *
 * The set allows multiple pixels at the same position if their grey levels differ.
 *
 * No 'null' entries are allowed. The number of elements is not limited.
 */
//
// TODO: Complete the methods in 'PixelTreeSet'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'PixelTreeSet' or any other class.
//
public class PixelTreeSet {

    /**
     * Initializes 'this' as an empty tree.
     */
    public PixelTreeSet() {
    }

    /**
     * Initializes 'this' as an independent copy of 'set'. Later changes of 'this'
     * will not affect 'set' and vice versa.
     *
     * @param set the set from which the elements are copied to 'this', set != null.
     */
    public PixelTreeSet(PixelTreeSet set) {
    }

    /**
     * Adds the specified pixel 'p' to this set.
     * If 'p' is already contained, the method has no effect.
     *
     * @param p the pixel to add, p != null.
     */
    public void add(Pixel p) {
    }

    /**
     * Returns 'true' if and only if 'p' is contained in this set.
     *
     * @param p the pixel to check, p != null.
     * @return 'true' if and only if 'p' is contained in this set.
     */
    public boolean contains(Pixel p) {
        return false;
    }

    /**
     * Adds all pixels of this set into the given queue, ordered by y and then x coordinate.
     * The pixel at the top-left corner (smallest y, smallest x) is added first.
     *
     * @param q the queue where the pixels are added, q != null.
     */
    public void addAllToQueue(PixelQueue q) {
    }
}