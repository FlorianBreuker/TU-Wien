/**
 * This class represents a constant integer value.
 */
public class IntConst {

    private final int value;

    /**
     * Initializes this constant with the specified value.
     *
     * @param value the value which 'this' represents.
     */
    public IntConst(int value) {
        this.value = value;
    }

    /**
     * Compares 'this' with 'o' for equality. Returns 'true' if 'o' is of class 'IntConst'
     * and represents the same value as 'this' and 'false' otherwise.
     *
     * @param o the object to be compared with.
     * @return 'true' if and only if 'o' is of class 'IntConst' and represents
     * the same value as 'this'.
     */
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        IntConst that = (IntConst) o;
        return that.value == this.value;
    }

    /**
     * Returns the hash code of 'this'.
     * The implementation must ensure that not all instances of IntConst return the same value.
     *
     * @return the hash code of 'this'.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    /**
     * Returns the sum of 'this' and 'c'.
     *
     * @param c the other summand, c != null.
     * @return the sum of 'this' and 'c'.
     */
    public IntConst plus(IntConst c) {
        return new IntConst(this.value + c.value);
    }

    /**
     * Returns the product of 'this' and 'c'.
     *
     * @param c the other operand, c != null.
     * @return the product of 'this' and 'c'.
     */
    public IntConst times(IntConst c) {
        return new IntConst(this.value * c.value);
    }

    /**
     * Returns 'true' if and only if 'this' is less than 'c'.
     *
     * @param c the other constant to compare with, c != null.
     * @return 'true' if 'this' is less than 'c', otherwise 'false'.
     */
    public boolean lessThan(IntConst c) {
        return this.value < c.value;
    }

    /**
     * Returns a readable representation of 'this', i.e., the value as a string.
     *
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }


}

