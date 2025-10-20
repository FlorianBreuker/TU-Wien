import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// This class represents an integer constant (no objects of class 'Variable' are contained
// in this expression).
//
public class Constant implements Expression {

    private int value;

    // Initializes 'this' with the specified value.
    public Constant(int value) {
        this.value = value;
    }

    @Override
    // Evaluates the constant with the provided variable-value mapping.
    // Since a constant does not depend on variables, it returns itself.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        return this;
    }

    // Returns a new 'Constant' object representing the sum of this constant and another constant.
    public Constant sumWith(Constant c) {
        return new Constant(this.value + c.value);
    }

    @Override
    // Since a constant does not depend on variables, the coefficient of the
    // specified variable is always 0.
    public Constant coefficientOf(Variable variable) {
        return new Constant(0);
    }

    @Override
    // Returns the sum of all constants in the constant expression.
    // Since 'this' is a constant itself, it returns itself.
    public Constant getConstant() {
        return this;
    }

    @Override
    // Since a constant does not depend on variables, an empty map is returned.
    public Map<Variable, Constant> asMap() {
        return new HashMap<>();
    }


    // Returns the value of this constant.
    public int intValue() {
        // TODO
        return this.value;
    }

    @Override
    // Returns 'true' only if this constant is equal to the given object.
    // Two constants are considered equal if they have the same value.
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Constant that = (Constant) o;
        return that.value == this.value;
    }

    @Override
    public VariableSet getSetView() {
        // TODO
        return new ConstView();

    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}

class ConstView implements VariableSet {

    @Override
    public boolean contains(Variable variable) {
        return false;
    }

    @Override
    public VariableIterator iterator() {
        return new ConstIter();
    }
}

class ConstIter implements VariableIterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Variable next() {
        if (!hasNext()) throw new NoSuchElementException("no more variables!");
        else return null;
    }
}
