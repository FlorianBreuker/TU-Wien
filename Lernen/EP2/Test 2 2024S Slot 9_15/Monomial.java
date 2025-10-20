import java.util.NoSuchElementException;

/**
 * A monomial is polynomial which has only one term.
 *
 * For example, 3*x*x*y is a monomial. A monomial is a product of two parts:
 * The first part is the coefficient (class 'IntConstNonNeg'), in this example the coefficient is 3.
 * The second part are the variables, more precisely a product of variables (class 'IntVar'), in
 * this example it is x*x*y.
 *
 * A single variable (of class 'IntVar') is also a monomial.
 * For example, a variable 'x' can be regarded as 1*x. The coefficient is 1 and the
 * variable part is x.
 *
 * Constants (of class 'IntConstNonNeg') are also monomials.
 * For example, the constant 3 is 3*1, in which the
 * coefficient is 3 and the variable part is empty which corresponds to 1.
 */
public interface Monomial extends Polynomial {

    /**
     * Returns the coefficient of this monomial.
     *
     * @return the coefficient of this monomial.
     */
    IntConstNonNeg getCoefficientPart();

    /**
     * Returns the variable part of 'this' as a new monomial.
     * with the same product of variables as in 'this' but a
     * coefficient of 1. For example, calling the method on the monomial 3*x*y*y will
     * return the monomial 1*x*y*y.
     *
     * @return a new monomial resulting from dividing 'this' by its coefficient.
     */
    Monomial getVariablePart();

    /**
     * The iterator of a monomial iterates over only one element 'this'.
     */
    default MonomialIterator iterator() {

        return new DefaultMonomialIterator(this);
    }
}

/**
 * The iterator class for monomials.
 */
class DefaultMonomialIterator implements MonomialIterator {

    private Monomial m;
    private boolean consumed = false;

    public DefaultMonomialIterator(Monomial m) {

        this.m = m;
    }

    @Override
    public boolean hasNext() {

        return !consumed;
    }

    @Override
    public Monomial next() {

        if (consumed) {
            throw new NoSuchElementException("no monomial!");
        }
        consumed = true;
        return m;
    }
}
