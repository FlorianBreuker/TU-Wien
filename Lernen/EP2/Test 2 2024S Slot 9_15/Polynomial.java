/**
 * An object that represents a polynomial.
 *
 * While monomials (see definition of 'Monomial') are single terms (either a single variable
 * or a single constant or a product of a coefficient and variables), this interface 'Polynomial'
 * represents a sum of an arbitrary number of monomials.
 *
 * For example, 3*x*y*y + 2*y is a polynomial consisting of two monomials 3*x*y*y and 2*y.
 * A single monomial is itself also a 'Polynomial' object.
 *
 * For simplicity all terms are non-negative (see class 'IntConstNonNeg').
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public interface Polynomial extends MonomialIterable {

    /**
     * Returns a string representation of 'this' where each monomial with its coefficient is shown
     * as a summand. The order of the terms is not specified. The leftmost term is shown without
     * preceding sign '+'. Coefficients of 1 are not shown in the representation. A term of 0 is
     * not shown unless the entire polynomial is mathematically 0 in which case the string is "0".
     *
     * For example, the returned string can be as follows:
     *
     * "3*x*y*y + x*y + 5*x + 1"
     *
     * @return a string representation of 'this'.
     */
    String toString();

    /**
     * Returns a 'IntVarSet' view of 'this' containing all variables occurring in this polynomial.
     * The 'IntVarSet' view is backed by 'this' such that later changes of 'this' will be
     * reflected in the returned view.
     *
     * For example, if this polynomial is 3*x*y*y + 2*x*y + 5*x + 3 the set view contains x and y.
     * If the polynomial is the single monomial x then the set view contains only x itself.
     * If the polynomial is a constant, like 5, then the set view is empty and contains no variable.
     *
     * @return a set view containing all variables occurring in this polynomial.
     */
    IntVarSet getIntVarSetView();

    /**
     * Returns a new monomial which corresponds to 'this' times 'c', i.e. in the resulting
     * polynomial each term has a new coefficient corresponding to the product of his
     * previous coefficient times 'c'.
     *
     * @param c the multiplier, c != null.
     * @return a new monomial which corresponds mathematically to 'this' times 'c'.
     */
    Polynomial times(IntConstNonNeg c);

    /**
     * Checks if 'this' and 'o' are equal polynomials. Two objects of type 'Polynomial' are
     * considered to be equal if they are of the same class and are mathematically equivalent.
     * For example, the monomials 2*x*y*y and 2*y*y*x are equal and
     * the polynomials 3*x*y*y + 2*y and 2*y + 3*y*x*y are equal.
     *
     * @return 'true' if 'this' and 'o' are equal, otherwise 'false'.
     */
    boolean equals(Object o);

    /**
     * Returns the hash code of 'this'.
     *
     * @return the hash code of 'this'.
     */
    int hashCode();

    /**
     * Returns an iterator over all 'Monomial' objects of this polynomial. For example,
     * if 'this' corresponds to 3*x*y*y + 2*x*y + 5*x, the iterations return 3*x*y*y, 2*x*y and 5*x.
     * The order of the iterations is not specified.
     *
     *  @return an iterator over all 'Monomial' objects of this polynomial.
     */
    MonomialIterator iterator();
}
