import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial // TODO: activate clause.
{
    private final HashMap<Variable, Integer> var;


    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {
        this.var = new HashMap<>();

        for (Variable v : variables
        ) {
            if (var.containsKey(v)) var.put(v, var.get(v) + 1);
            else var.put(v, 1);
        }
    }

    @Override
    public Polynomial evaluate(Variable v, int value) {
        ArrayList<Variable> newVars = new ArrayList<>();

        for (Variable cur : var.keySet()) {
            for (int i = 0; i < var.get(cur); i++) {
                if (!cur.equals(v)) newVars.add(cur);
            }
        }

        Monomial m = new Monomial(newVars.toArray(new Variable[0]));
        return new SimplePolynomial(m, var.get(v) * value);
    }

    @Override
    public VariableSet getVariableSetView() {
        return new MonomSet(this);
    }

    // Returns the coefficient of the specified monomial in this polynomial.
    // Precondition: m != null.
    public int getCoefficientOf(Monomial m) {
        return m.equals(this) ? 1 : 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        HashMap<Monomial, Integer> res = new HashMap<>();
        res.put(this, 1);
        return res;
    }

    // @Override
    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    public MonomialIterator iterator() {
        return new MonomialIter(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        Monomial that = (Monomial) o;
        for (Variable v : that.var.keySet()
        ) {
            if (!Objects.equals(that.var.get(v), this.var.get(v))) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Variable var : var.keySet()
        ) {
            hash += var.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        if (var.isEmpty()) return "1";
        StringBuilder res = new StringBuilder();
        Iterator<Variable> iter = var.keySet().iterator();

        while (iter.hasNext()) {
            Variable cur = iter.next();
            for (int i = 0; i < var.get(cur); i++) {
                res.append(cur);
                if (i < var.get(cur) - 1) res.append("*");
            }
            if (iter.hasNext()) res.append("*");
        }
        return res.toString();
    }

    public HashMap<Variable, Integer> getVariables() {
        return this.var;
    }
}
