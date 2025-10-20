import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StarIteratorF implements StarIterator {
    private ArrayList<Mobile> mobiles;
    private StarIterator iter;
    private int curMobile = 0;

    public StarIteratorF(ArrayList<Mobile> mobiles) {
        this.mobiles = mobiles;
        getNextIter();
    }

    private boolean getNextIter() {
        if (curMobile >= mobiles.size()) return false;
        iter = mobiles.get(curMobile).iterator();
        if (!iter.hasNext()) {
            curMobile++;
            return getNextIter();
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        if (curMobile >= mobiles.size()) return false;
        if (iter == null) return false;
        if (iter.hasNext()) return true;
        curMobile++;
        return getNextIter();
    }

    @Override
    public Star next() {
        if (!iter.hasNext()) throw new NoSuchElementException("no star element!");
        else return iter.next();
    }
}
