import java.util.Objects;

// Represents a variable.
// Each variable is uniquely identified by its instance. Two variables are considered equal only
// if they have the same identity (regardless of their name). (Different variables can
// have the same name. In order to avoid confusion, in 'PraxisTest2' all 'Variable' objects have
// different names.)
//
public class Variable {
    private String name;

    // Initializes 'this' with its name.
    public Variable(String name) {
        this.name = name;
    }

    // Returns the name of this 'Variable'.
    public String getName() {
        return this.name;
    }

    @Override
    // Returns the name of this 'Variable'.
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }
}
