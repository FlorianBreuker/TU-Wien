import java.util.ArrayList;

public class CompactView implements IntConstRange {
    private CompactIntConstSet self;
    private ArrayList<IntConst>[] elements;

    public CompactView(CompactIntConstSet self, ArrayList<IntConst>[] set) {
        this.self = self;
        this.elements = set;
    }

    @Override
    public IntConst getSmallest() {
        IntConst min = new IntConst(Integer.MAX_VALUE);
        for (IntConst ic : elements[0]) {
            if (ic.lessThan(min)) min = ic;
        }
        return min;
    }

    @Override
    public IntConst getLargest() {
        IntConst max = new IntConst(Integer.MIN_VALUE);
        for (IntConst ic : elements[0]) {
            if (max.lessThan(ic)) max = ic;
        }
        return max;
    }

    @Override
    public IntConstIterator iterator() {
        return self.iterator();
    }
}
