import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over elements of type 'Monomial'.
 */
public interface MonomialIterator extends Iterator<Monomial> {


    /**
     * Returns 'true' if the iteration has more elements, 'false' otherwise.
     *
     * @return 'true' if the iteration has more elements, 'false' otherwise.
     */
    boolean hasNext();

    /**
     * Returns the next element of the iteration. Throws a 'java.util.NoSuchElementException'
     * with the detail message "no monomial!" if the iteration has no more elements.
     *
     * @return the next element of the iteration.
     * @throws NoSuchElementException if the iteration has no more elements. The detail message
     * is "no monomial!".
     */
    Monomial next();
}
