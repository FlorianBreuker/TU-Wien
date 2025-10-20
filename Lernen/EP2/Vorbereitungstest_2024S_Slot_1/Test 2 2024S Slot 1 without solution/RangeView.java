public class RangeView implements IntConstRange {
    private IntConstRangeSet self;

    public RangeView(IntConstRangeSet set) {
        this.self = set;
    }

    @Override
    public IntConst getSmallest() {
        return self.getSmallest();
    }

    @Override
    public IntConst getLargest() {
        return self.getLargest();
    }

    @Override
    public IntConstIterator iterator() {
        return self.iterator();
    }
}
