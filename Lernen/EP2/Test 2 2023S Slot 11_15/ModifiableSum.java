import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class ModifiableSum implements Expression {

    private ArrayList<Expression> sum;

    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public ModifiableSum(Expression e1, Expression e2) throws DuplicateNameException {
        for (Variable x : e1.getSetView()) {
            if (e2.getSetView().contains(x)) throw new DuplicateNameException(x);
        }

        for (Variable x : e2.getSetView()) {
            if (e1.getSetView().contains(x)) throw new DuplicateNameException(x);
        }
        sum = new ArrayList<>();
        sum.add(e1);
        sum.add(e2);
    }

    private ModifiableSum() {
        this.sum = new ArrayList<>();
    }


    // This method adds 'expression' to 'this'.
    // If 'expression' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown.
    // Precondition: other != null.
    public void add(Expression e) throws DuplicateNameException {
        for (Expression x : sum) {
            for (Variable v : x.getSetView()) {
                for (Variable y : e.getSetView()) {
                    if (!v.equals(y) && v.toString().equals(y.toString())) throw new DuplicateNameException(y);
                }
            }
        }
        sum.add(e);
    }

    @Override
    // Evaluates this expression using the provided variable-value mapping. For example,
    // if 'map' associates variable x with constant 2 and variable y with constant 3, the
    // expression x + y is evaluated to the expression 2 + 3. If 'map' contains the mapping
    // for y, but no mapping for x, then x + y is evaluated to x + 3. If there is neither
    // a mapping for x nor for y, then x + y is evaluated to x + y.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        ModifiableSum newSum = new ModifiableSum();
        for (Expression x : sum) {
            for (Variable v : x.getSetView()
            ) {
                newSum.add(v.evaluate(map));
            }
        }
        newSum.add(getConstant());
        return newSum;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. For example,
    // in the expression x + y + x + 3 the variable 'x' has a coefficient of 2, while 'y'
    // has the coefficient 1 (and variables that are not occurring in the expression have a
    // coefficient of 0).
    // Precondition: variable != null.
    public Constant coefficientOf(Variable variable) {
        int co = 0;
        for (Expression x : sum) {
            co += x.coefficientOf(variable).intValue();
        }
        return new Constant(co);
    }

    @Override
    // Returns the sum of all constants in the expression. For example,
    // for the expression x + y + x + 3 the method returns 3. For the expression 3 + x + 4
    // the method returns 7.
    public Constant getConstant() {
        Constant c = new Constant(0);
        for (Expression x : sum) {
            c = c.sumWith(x.getConstant());
        }
        return c;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ArrayList<Expression> used = new ArrayList<>();
        boolean first = true;
        for (Expression x : sum) {
            for (Variable y : x.getSetView()) {
                if (used.contains(y)) continue;
                if (!first) res.append(" + ");
                else first = false;
                int coe = coefficientOf(y).intValue();
                String coff = "";
                if (coe >= 2) coff += coe;
                res.append(coff).append(y.toString());
                used.add(y);
            }
        }
        if (!first) res.append(" + ");
        res.append(this.getConstant());
        return res.toString();
    }

    @Override
    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    public Map<Variable, Constant> asMap() {
        Map<Variable, Constant> map = new HashMap<>();
        for (Expression x : sum
        ) {
            for (Variable v : x.getSetView()
            ) {
                map.put(v, coefficientOf(v));
            }
        }
        return map;
    }

    @Override
    // Returns a 'VariableSet' view of 'this'.
    public VariableSet getSetView() {
        // TODO
        return new sumView(sum);
    }
}

//TODO: define additional classes as needed, either here or in a separate file.

class sumView implements VariableSet {
    ArrayList<Expression> sum;

    public sumView(ArrayList<Expression> sum) {
        this.sum = sum;
    }

    @Override
    public boolean contains(Variable variable) {
        for (Expression ex : sum) {
            if (ex.getSetView().contains(variable)) return true;
        }
        return false;
    }

    @Override
    public VariableIterator iterator() {
        return new sumIter(sum);
    }
}

class sumIter implements VariableIterator {
    private Iterator<Expression> iter;
    private VariableIterator cur;
    private ArrayList<Variable> used;

    public sumIter(ArrayList<Expression> sum) {
        this.iter = sum.iterator();
        this.cur = iter.next().getSetView().iterator();
        this.used = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || cur.hasNext();
    }

    @Override
    public Variable next() {
        if (!hasNext()) throw new NoSuchElementException("no more variables!");

        while (!cur.hasNext()) {
            cur = iter.next().getSetView().iterator();
        }
        if (!hasNext()) throw new NoSuchElementException("no more variables!");
        Variable res = cur.next();
        if (used.contains(res)) {
            cur = iter.next().getSetView().iterator();
            res = cur.next();
        } else used.add(res);
        return res;
    }
}

