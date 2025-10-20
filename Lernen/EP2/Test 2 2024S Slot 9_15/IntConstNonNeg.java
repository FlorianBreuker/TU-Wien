/**
 * This class represents a constant integer value >= 0 (for simplicity no negative values
 * are allowed).
 * <p>
 * A constant is also a monomial with a coefficient that is 'this' and the
 * variable part is 1 (which corresponds to an "empty product" with no variables).
 * A constant term does not contain any variable.
 */
public class IntConstNonNeg implements Monomial {

    private final int value;

    /**
     * Initializes this constant with the specified value.
     *
     * @param value the value which 'this' represents, value >= 0.
     * @throws IllegalArgumentException if value < 0.
     */
    public IntConstNonNeg(int value) {
        this.value = value;
    }

    /**
     * Returns the sum of 'this' and 'c'.
     *
     * @param c the other summand, c != null.
     * @return the sum of 'this' and 'c'.
     */
    public IntConstNonNeg plus(IntConstNonNeg c) {
        return new IntConstNonNeg(this.value + c.value);
    }

    /**
     * Returns the product of 'this' and 'c'.
     *
     * @param c the other operand, c != null.
     * @return the product of 'this' and 'c'.
     */
    public IntConstNonNeg times(IntConstNonNeg c) {
        return new IntConstNonNeg(this.value * c.value);
    }

    /**
     * Returns 'true' if and only if 'this' represents 0.
     *
     * @return 'true' if and only if 'this' represents 0.
     */
    public boolean isZero() {
        return value == 0;
    }

    /**
     * Returns 'true' if and only if 'this' represents 1.
     *
     * @return 'true' if and only if 'this' represents 1.
     */
    public boolean isOne() {
        return value == 1;
    }

    /**
     * Returns the coefficient of 'this', which is the constant 'this' itself.
     *
     * @return the coefficient of 'this'.
     */
    //@Override
    public IntConstNonNeg getCoefficientPart() {
        return this;
    }

    /**
     * Returns the variable part of 'this'. Since a constant has no variable
     * this part corresponds to the factor of 1.
     *
     * @return the variable part of 'this'.
     */
    @Override
    public Monomial getVariablePart() {
        return new IntConstNonNeg(1);
    }

    /**
     * Returns a readable representation of 'this', i.e., the value as a string.
     *
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {
        if (this.isZero()) return "";
        else return this.value + "";
    }

    /**
     * Compares 'this' with 'o' for equality. Returns 'true' if 'o' is of class 'IntConstNonNeg'
     * and represents the same value as 'this' and 'false' otherwise.
     *
     * @param o the object to be compared with.
     * @return 'true' if and only if 'o' is of class 'IntConstNonNeg' and represents
     * the same value as 'this'.
     */
    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        IntConstNonNeg that = (IntConstNonNeg) o;
        return that.value == this.value;
    }

    /**
     * Returns the hash code of 'this'.
     *
     * @return the hash code of 'this'.
     */
    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public IntVarSet getIntVarSetView() {
        return new ConstView();
    }
}

class ConstView implements IntVarSet {

    @Override
    public boolean contains(IntVar v) {
        return false;
    }
}
