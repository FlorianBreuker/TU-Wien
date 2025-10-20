import java.util.NoSuchElementException;

public class RangeIterator implements IntConstIterator {
    private IntConstRangeSet self;
    private IntConst cur;

    public RangeIterator(IntConstRangeSet set) {
        this.self = set;
        this.cur = self.getSmallest();
    }

    @Override
    public boolean hasNext() {
        return cur.lessThan(self.getLargest().plus(new IntConst(1)));
    }

    @Override
    public IntConst next() {
        if (!hasNext()) throw new NoSuchElementException("no element");
        IntConst res = cur;
        cur.plus(new IntConst(1));
        return res;
    }
}
