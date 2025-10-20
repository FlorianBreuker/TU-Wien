/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A {@code Star} has a specified weight, that can not be changed after
 * initialisation. {@code Star} implements {@link Decoration}.
 */
//
// TODO: Complete the methods in 'Star'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Star implements Decoration //TODO: activate clause.
{

    //TODO: define missing parts of the class.
    private int weight;

    /**
     * Initializes {@code this} with its weight.
     *
     * @param weight the weight of this star.
     */
    public Star(int weight) {
        // TODO: implement constructor.
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    /**
     * Returns a readable representation of {@code this} with the
     * symbol {@code *} followed by the weight of this star.
     */
    @Override
    public String toString() {
        // TODO: implement method.
        return "*" + this.weight;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return this.weight;
    }

    @Override
    public StarIterator iterator() {
        return new StarIter(this);
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarColl(this);
    }
}