import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class PolyIter implements MonomialIterator {
    Iterator<Monomial> iter;
    MonomialIterator monIter;

    public PolyIter(LinkedHashMap<Monomial, Integer> monomials) {
        iter = monomials.keySet().iterator();
        monIter = iter.next().iterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || monIter.hasNext();
    }

    @Override
    public Monomial next() {
        if (!hasNext()) throw new NoSuchElementException("no more monomials!");
        while (!monIter.hasNext() && iter.hasNext()) {
            monIter = iter.next().iterator();
        }
        if (!hasNext()) throw new NoSuchElementException("no more monomials!");
        return monIter.next();
    }
}
