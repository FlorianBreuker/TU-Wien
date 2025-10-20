/**
 * Represents a range of consecutive 'IntConst' numbers
 * from this.getSmallest() to this.getLargest() (for example from 3 to 7).
 * The iterator iterates over all numbers in ascending order (for example 3,4,5,6,7).
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public interface IntConstRange extends IntConstIterable {

    /**
     * Returns the smallest number of this range.
     * @return the smallest number of this range.
     */
    IntConst getSmallest();

    /**
     * Returns the largest number of this range.
     * @return the largest number of this range.
     */
    IntConst getLargest();
}
