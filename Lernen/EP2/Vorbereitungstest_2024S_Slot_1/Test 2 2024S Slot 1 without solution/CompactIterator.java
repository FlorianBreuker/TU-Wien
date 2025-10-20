import java.util.Iterator;
import java.util.NoSuchElementException;

public class CompactIterator implements IntConstIterator {
    private Iterator<IntConst> iter;

    public CompactIterator(Iterator<IntConst> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public IntConst next() {
        if (!iter.hasNext()) throw new NoSuchElementException("no element!");
        else return iter.next();
    }
}
