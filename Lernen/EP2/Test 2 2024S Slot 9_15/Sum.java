import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a polynomial corresponding to a sum of different monomials,
 * like 3*x*y + 4*x*x + 2*x*x*y + 3.
 * <p>
 * A sum has at least one monomial (the constant 0).
 */
//
// TODO: Complete the methods in 'Sum'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Sum implements Polynomial {
    ArrayList<Monomial> sum;

    /**
     * Initializes 'this' as the polynomial with the single monomial 0. Polynomials with
     * multiple terms can be constructed by calling 'add'.
     */
    public Sum() {
        this.sum = new ArrayList<>();
        sum.add(new IntConstNonNeg(0));
    }

    /**
     * Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
     * and 'other' to 1*x*y*y then 'this' becomes 4*x*y*y + 2*x.
     * The method leaves 'other' unchanged.
     *
     * @param other the other polynomial to add to this, other != null.
     *              Precondition: other != null.
     */
    public void add(Polynomial other) {
        for (Monomial m1 : other
        ) {
            boolean found = false;
            for (Monomial m : sum
            ) {
                if (m1.getVariablePart().equals(m.getVariablePart())) {
                    IntConstNonNeg factor = m1.getCoefficientPart().plus(m.getCoefficientPart());
                    sum.remove(m);
                    sum.add((Monomial) m1.getVariablePart().times(factor));
                    found = true;
                }
            }
            if (!found) sum.add(m1);
        }
        //TODO: implement method
    }

    @Override
    public IntVarSet getIntVarSetView() {
        return new sumView(this.sum);
    }

    @Override
    public Polynomial times(IntConstNonNeg c) {
        Sum sum = new Sum();
        for (Monomial m : this.sum
        ) {
            sum.add(m.times(c));
        }
        return sum;
    }

    @Override
    public MonomialIterator iterator() {
        return new sumIter(sum);
    }

    @Override
    public String toString() {
        if (this.sum.size() == 1) return "0";
        StringBuilder res = new StringBuilder();
        for (Monomial m : sum
        ) {
            if (!res.toString().isEmpty()) res.append(" + ");
            res.append(m.toString());
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Sum that = (Sum) o;
        if (that.sum.size() != this.sum.size()) return false;
        for (Monomial m : that.sum
        ) {
            if (!this.sum.contains(m)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (Monomial m : this.sum
        ) {
            hashCode += m.hashCode();
        }
        return hashCode * this.sum.size();
    }
}

//TODO: define further classes, if needed, either here or in a separate file.
class sumView implements IntVarSet {
    private ArrayList<Monomial> variables;

    public sumView(ArrayList<Monomial> sum) {
        this.variables = sum;
    }

    @Override
    public boolean contains(IntVar v) {
        for (Monomial m : variables
        ) {
            if (m.getIntVarSetView().contains(v)) return true;
        }
        return false;
    }
}

class sumIter implements MonomialIterator {
    Iterator<Monomial> iter;
    MonomialIterator cur;

    public sumIter(ArrayList<Monomial> var) {
        this.iter = var.iterator();
        cur = iter.next().iterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || cur.hasNext();
    }

    @Override
    public Monomial next() {
        if (!hasNext()) throw new NoSuchElementException("no monomial!");
        if (!cur.hasNext()) cur = iter.next().iterator();
        return cur.next();
    }
}