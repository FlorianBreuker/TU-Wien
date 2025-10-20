import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a product with one constant and at least one variable,
 * like 5*x*y or 3*x.
 */
public class Product implements Monomial // TODO: activate clause.
{

    IntConstNonNeg coefficient;
    HashMap<IntVar, Integer> variables;

    /**
     * Initializes 'this' as a product of the specified coefficient and variables.
     * Variables can occur more often than once in the specified array.
     * (The number of occurrences corresponds to the exponent of the variable.)
     * <p>
     * This class must be used only for non-trivial products:
     * The preconditions given below ensure that this class is not used for representing
     * objects that can be represented by 'IntConstNonNeg' or 'IntVar', like for example: 1*x or 0*x*y.
     * <p>
     * The method throws an 'IllegalArgumentException' if the preconditions are not met.
     *
     * @param coeff the coefficient in this product,
     *              coeff != null && !coeff.isZero().
     * @param vars  an array with the variables of this product.
     *              coeff.isOne() && vars.length >= 2 || !coeff.isOne() && vars.length >= 1,
     *              vars[i] != null for all valid i.
     * @throws IllegalArgumentException if the preconditions are not fulfilled (no detail message).
     */
    public Product(IntConstNonNeg coeff, IntVar... vars) {
        //TODO: implement constructor.
        this.coefficient = coeff;
        this.variables = new HashMap<>();
        for (IntVar v : vars
        ) {
            if (variables.containsKey(v)) variables.put(v, variables.get(v) + 1);
            else variables.put(v, 1);
        }
    }

    @Override
    public IntConstNonNeg getCoefficientPart() {
        return this.coefficient;
    }

    @Override
    public Monomial getVariablePart() {
        ArrayList<IntVar> var = new ArrayList<>();
        for (IntVar v : variables.keySet()
        ) {
            for (int i = 0; i < variables.get(v); i++) {
                var.add(v);
            }
        }

        return new Product(new IntConstNonNeg(1), var.toArray(new IntVar[0]));
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        boolean first = true;
        if (this.coefficient.hashCode() > 1) {
            res.append(this.coefficient);
            first = false;
        }
        for (IntVar v : variables.keySet()
        ) {
            for (int i = 0; i < this.variables.get(v); i++) {
                if (!first) res.append("*");
                first = false;
                res.append(v.toString());
            }
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        Product that = (Product) o;
        if (that.variables.size() != this.variables.size()) return false;
        if (!this.coefficient.equals(that.coefficient)) return false;
        return this.variables.equals(that.variables);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (IntVar v : this.variables.keySet()
        ) {
            hashCode += v.hashCode();
        }
        return hashCode * this.coefficient.hashCode();
    }

    @Override
    public IntVarSet getIntVarSetView() {
        return new productView(this.variables);
    }

    @Override
    public Polynomial times(IntConstNonNeg c) {
        ArrayList<IntVar> vars = new ArrayList<>();
        for (IntVar v : this.variables.keySet()
        ) {
            for (int i = 0; i < variables.get(v); i++) {
                vars.add(v);
            }
        }
        return new Product(this.coefficient.times(c), vars.toArray(new IntVar[0]));
    }
}

//TODO: define further classes, if needed, either here or in a separate file.
class productView implements IntVarSet {
    HashMap<IntVar, Integer> variables;

    public productView(HashMap<IntVar, Integer> var) {
        this.variables = var;
    }

    @Override
    public boolean contains(IntVar v) {
        return variables.containsKey(v);
    }
}
