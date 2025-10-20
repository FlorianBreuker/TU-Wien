/**
 * An object providing an iterator over its 'Monomial' elements.
 */
public interface MonomialIterable extends Iterable<Monomial> {

    /**
     * Returns an iterator over elements of type 'IntVar'.
     * @return an iterator over elements of type 'IntVar'.
     */
    MonomialIterator iterator();
}
