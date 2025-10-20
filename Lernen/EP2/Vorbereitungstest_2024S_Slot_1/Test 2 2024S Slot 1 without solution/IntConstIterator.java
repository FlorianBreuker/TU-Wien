import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over 'IntConst' objects.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public interface IntConstIterator extends Iterator<IntConst> {

    /**
     * Returns 'true' if the iteration has more elements, otherwise 'false'.
     *
     * @return 'true' only if the iteration has more elements.
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration. Throws a 'java.util.NoSuchElementException' if
     * the iteration has no more elements. The detail massage of the exception is
     * "no element".
     *
     * @return the next element in the iteration.
     * @throws NoSuchElementException if the iteration has no more elements.
     * The detail massage of the exception is "no element!".
     */
    IntConst next();
}
