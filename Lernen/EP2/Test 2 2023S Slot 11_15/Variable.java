import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// Represents a variable. 'Variable' implements 'Expression'.
// Each variable is uniquely identified by its
// instance. Two variables are considered equal only if they have the same identity (regardless
// of their name).
//
public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    // Evaluates this expression using the provided variable-value mapping.
    // If the map contains an entry for this variable, we return the associated value, else the variable itself (this)
    // is returned.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        if (map.containsKey(this)) return map.get(this);
        else return this;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. If the variable is equal to 'this', 1 is
    // returned, else 0,
    // Precondition: variable != null.s
    public Constant coefficientOf(Variable variable) {
        if (this.equals(variable)) return new Constant(1);
        else return new Constant(0);
    }

    @Override
    // Returns the sum of all constants in the expression. Since there are no constants in this expression, always 0
    // is returned.
    public Constant getConstant() {
        // TODO
        return new Constant(0);
    }

    @Override
    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    public Map<Variable, Constant> asMap() {
        HashMap<Variable, Constant> map = new HashMap<>(1);
        map.put(this, new Constant(1));
        return map;
    }

    @Override
    // Returns a 'VariableSet' view of 'this'.
    public VariableSet getSetView() {
        return new VariableView(this);
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class VariableView implements VariableSet {
    private Variable self;
    public VariableView(Variable self) {
        this.self = self;
    }

    @Override
    public boolean contains(Variable variable) {
        return self.equals(variable);
    }

    @Override
    public VariableIterator iterator() {
        return new VariableIter(self);
    }
}

class VariableIter implements VariableIterator {
    private Variable self;
    private boolean used = false;

    public VariableIter(Variable var) {
        this.self = var;
    }

    @Override
    public boolean hasNext() {
        return !used;
    }

    @Override
    public Variable next() {
        if (!hasNext()) throw new NoSuchElementException("no more variables!");
        used = true;
        return self;
    }
}
