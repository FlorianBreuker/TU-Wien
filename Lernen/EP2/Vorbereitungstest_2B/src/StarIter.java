public class StarIter implements StarIterator {
    Star current;

    public StarIter(Star star) {
        this.current = star;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Star next() {
        Star temp = current;
        this.current = null;
        return temp;
    }
}
