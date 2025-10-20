/**
 * A set of 'IntConst' numbers.
 */
public interface IntConstSet extends IntConstIterable {

    /**
     * Returns 'true' if the specified element is contained in this set and 'false' otherwise.
     *
     * @return 'true' if the specified element is contained in this set and 'false' otherwise.
     */
    boolean contains(IntConst element);

    /**
     * Returns the union of this set and the specified set.
     * The union of two sets is the set containing the elements of 'this' and 'other'.
     *
     * @param other the other set, other != null.
     * @return a new set representing the union of 'this' with 'other'.
     */
    IntConstSet union(IntConstSet other);

    /**
     * Returns a readable representation of the set giving information about which elements are
     * in the set.
     *
     * @return a readable representation of the set.
     */
    String toString();

    /**
     * Returns an 'IntConstRange' view of 'this'. The returned object represents the
     * range from the smallest element to the largest element of this set (inclusive).
     * For example, if 'this' is the set of elements 1,2,5,9 the returned range is 1 to 9.
     * Later changes in 'this' will be reflected in the returned view.
     *
     * @return an 'IntConstRange' view of 'this'.
     */
    IntConstRange getRangeView();

    /**
     * Returns -1 if all elements of 'this' are less than the smallest element of 'other' and
     * returns 1 if all elements of 'this' are greater than the largest element of 'other'.
     * Returns 0 otherwise.
     *
     * @param other the other set to compare with, other != null.
     * @return return -1, 1 or 0, depending on whether
     *      all elements of 'this' are less than the smallest element of 'other',
     *      all elements of 'this' are greater than the largest element of 'other'
     *      or the ranges of the sets overlap.
     */
    default int compare(IntConstSet other) {
        if (this.getRangeView().getLargest().lessThan(other.getRangeView().getSmallest())) {
            return -1;
        }

        if (other.getRangeView().getLargest().lessThan(this.getRangeView().getSmallest())) {
            return 1;
        }

        return 0;
    }

    /**
     * Returns 'true' if 'this' and 'o' are equal.
     *
     * @param o the object to be compared with.
     * @return true if 'this' and 'o' are equal, false otherwise.
     */
    boolean equals(Object o);

    /**
     * Returns the hash code of 'this'.
     * The implementation must ensure that not all instances of IntConst return the same value.
     *
     * @return the hash code of 'this'.
     */
    int hashCode();

    /**
     * Returns an iterator over all 'IntConst' objects in 'this' set in ascending order according
     * to the order relation defined by the method 'lessThan' of 'IntConst'.
     *
     * @return an iterator over all 'IntConst' objects in 'this' set.
     */
    IntConstIterator iterator();
}
