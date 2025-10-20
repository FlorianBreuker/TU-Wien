import java.util.NoSuchElementException;

public class MonomialIter implements MonomialIterator {
    private Monomial self;

    public MonomialIter(Monomial mon) {
        this.self = mon;
    }

    @Override
    public boolean hasNext() {
        return self != null;
    }

    @Override
    public Monomial next() {
        if (!hasNext()) throw new NoSuchElementException("no more monomials!");
        Monomial temp = self;
        self = null;
        return temp;
    }
}
