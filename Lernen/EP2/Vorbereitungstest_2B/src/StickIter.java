import java.util.NoSuchElementException;

public class StickIter implements StarIterator {
    private Mobile[] attached;
    int currAtt = 0;
    StarIterator iter;

    public StickIter(Mobile[] attached) {
        this.attached = attached;
        getNextIter();
    }

    private boolean getNextIter() {
        if (currAtt >= attached.length) return false;
        this.iter = attached[currAtt].iterator();
        if (!this.iter.hasNext()) {
            currAtt++;
            getNextIter();
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        if (currAtt >= attached.length) return false;
        if (this.iter.hasNext()) return true;
        else {
            currAtt++;
            return getNextIter();
        }
    }

    @Override
    public Star next() {
        if (!this.iter.hasNext()) throw new NoSuchElementException("no star element!");
        else return iter.next();
    }
}
