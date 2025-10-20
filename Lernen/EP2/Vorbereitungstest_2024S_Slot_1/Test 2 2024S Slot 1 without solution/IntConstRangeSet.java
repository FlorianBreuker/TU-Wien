/**
 * A set of consecutive IntConst numbers from 'smallest' to 'largest' (inclusive).
 */

public class IntConstRangeSet implements IntConstSet, IntConstRange {
    private IntConst[] range;

    /**
     * Initializes 'this' with the smallest and largest element of this range (inclusive).
     * Throws an IllegalLimitException with the detail message "illegal range limits"
     * if largest.lessThan(smallest) == true. If largest.equals(smallest) == true, this set
     * has only a single element.
     *
     * @param smallest the smallest number in this set.
     * @param largest  the largest number in this set.
     * @throws IllegalLimitException with the detail message "illegal range limits"
     *                               if largest.lessThan(smallest) == true.
     */
    public IntConstRangeSet(IntConst smallest, IntConst largest) {
        if (largest.lessThan(smallest)) throw new IllegalLimitException("illegal range limits");
        this.range = new IntConst[2];
        this.range[0] = smallest;
        this.range[1] = largest;
    }


    @Override
    public boolean contains(IntConst element) {
        return range[0].plus(new IntConst(-1)).lessThan(element) && element.lessThan(range[1].plus(new IntConst(1)));
    }

    /**
     * Returns the union of this set and the specified set (see specification in 'IntConstSet').
     * The method returns a new object of the most specific subtype of 'IntConstSet':
     * The returned object is of 'IntConstRangeSet' if the returned set can be represented by a
     * single range. Otherwise, the returned set is of 'CompactIntConstSet'.
     *
     * @param other the other set, other != null.
     * @return a new set representing the union of 'this' with 'other'.
     */
    //@Override
    public IntConstSet union(IntConstSet other) {
        IntConst otherS = other.getRangeView().getSmallest();
        IntConst otherL = other.getRangeView().getLargest();
        if (this.getSmallest().lessThan(otherS) && otherL.lessThan(this.getLargest()))
            return this;
        if (otherS.lessThan(this.getSmallest()) && this.getLargest().lessThan(otherL))
            return other;

        if (this.getLargest().equals(otherS.plus(new IntConst(-1))))
            return new IntConstRangeSet(this.getSmallest(), otherL);


        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        IntConstSet that = (IntConstSet) o;
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        IntConst current = range[0];
        while (current.lessThan(range[1].plus(new IntConst(1)))) {
            hashCode += current.hashCode();
            current.plus(new IntConst(1));
        }

        return hashCode * getSmallest().hashCode();
    }


    /**
     * Returns a readable representation of 'this' in the form smallest-largest,
     * for example "3-12". If smallest.equals(largest) the string consists of just the single
     * number (for example "12").
     *
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {
        // range nur smallest to largest
        return range[0] + "-" + range[1];
    }

    public void add(IntConst c) {
        if (c.lessThan(range[0])) range[0] = c;
        else if (range[1].lessThan(c)) range[1] = c;
    }

    @Override
    public IntConstRange getRangeView() {
        return new RangeView(this);
    }

    @Override
    public IntConstIterator iterator() {
        return new RangeIterator(this);
    }

    @Override
    public IntConst getSmallest() {
        return range[0];
    }

    @Override
    public IntConst getLargest() {
        return range[1];
    }
}


