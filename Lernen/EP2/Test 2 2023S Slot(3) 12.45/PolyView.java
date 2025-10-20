import java.util.LinkedHashMap;

public class PolyView implements VariableSet {
    private SimplePolynomial self;

    public PolyView(SimplePolynomial self) {
        this.self = self;
    }

    @Override
    public boolean contains(Variable variable) {
        LinkedHashMap<Monomial, Integer> map = self.getMonomials();

        for (Monomial mon : map.keySet()) {
            if (mon.getVariableSetView().contains(variable)) return true;
        }

        return false;
    }
}
