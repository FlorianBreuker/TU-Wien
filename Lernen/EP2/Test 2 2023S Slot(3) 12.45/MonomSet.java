import java.util.HashMap;

public class MonomSet implements VariableSet {
    private Monomial self;

    public MonomSet(Monomial self) {
        this.self = self;
    }

    @Override
    public boolean contains(Variable variable) {
        HashMap<Variable, Integer> map = self.getVariables();
        return map.get(variable) != null;
    }
}
