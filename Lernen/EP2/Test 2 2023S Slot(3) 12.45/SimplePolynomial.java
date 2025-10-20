import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial implements Polynomial //TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).
    LinkedHashMap<Monomial, Integer> monomials;


    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {
        monomials = new LinkedHashMap<>();
        monomials.put(m, coefficient);
    }

    private SimplePolynomial() {
        monomials = new LinkedHashMap<>();
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {
        for (Monomial m : other
        ) {
            if (monomials.containsKey(m)) monomials.put(m, monomials.get(m) + other.getCoefficientOf(m));
            else monomials.put(m, other.getCoefficientOf(m));
        }
    }

    @Override
    public Polynomial evaluate(Variable v, int value) {
        Iterator<Monomial> iter = monomials.keySet().iterator();
        SimplePolynomial polynomial = new SimplePolynomial();

        while (iter.hasNext()) {
            Monomial cur = iter.next();
            Polynomial curP = cur.evaluate(v, value);
            polynomial.add(curP);
        }
        return polynomial;
    }

    @Override
    public VariableSet getVariableSetView() {
        return new PolyView(this);
    }

    public LinkedHashMap<Monomial, Integer> getMonomials() {
        return this.monomials;
    }

    @Override
    public int getCoefficientOf(Monomial m) {
        return monomials.get(m) == null ? 0 : monomials.get(m);
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        return monomials;
    }

    @Override
    public MonomialIterator iterator() {
        return new PolyIter(monomials);
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        SimplePolynomial that = (SimplePolynomial) o;
        if (that.monomials.size() != this.monomials.size()) return false;

        for (Monomial monomial : that.monomials.keySet()) {
            if (!this.monomials.containsKey(monomial)) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (Monomial monomial : this.monomials.keySet()) {
            if (!this.monomials.containsKey(monomial)) hashCode += monomial.hashCode();
        }
        return hashCode * this.monomials.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Iterator<Monomial> iter = monomials.keySet().iterator();

        while (iter.hasNext()) {
            Monomial mon = iter.next();
            if (monomials.get(mon) != 1) res.append(monomials.get(mon)).append("*");
            if (monomials.get(mon) != 0) res.append(mon);
            if (iter.hasNext()) res.append(" + ");
        }
        return res.toString();
    }
}
