/**
 * A simple set of 'IntVar' elements providing only a 'contains' method.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public interface IntVarSet {

    /**
     * Returns 'true' if 'this' has an element equal to the specified object and 'false' otherwise.
     *
     * @param v the element to check for containment in 'this'.
     * @return 'true' if 'this' has an element equal to the specified object and 'false' otherwise.
     */
    boolean contains(IntVar v);
}
