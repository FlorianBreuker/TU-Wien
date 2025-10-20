/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A {@code Star} has a specified weight, that can not be changed after
 * initialisation. {@code Star} implements {@link Decoration}.
 */

public class Star implements Decoration // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.
    private int weight;

    /**
     * Initializes {@code this} with its weight.
     *
     * @param weight the weight of this star, {@code weight > 0}.
     */
    public Star(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    /**
     * Returns a readable representation of {@code this} with the
     * symbol '*' followed by the weight of this star.
     *
     * @return a readable representation of {@code this}.
     */
    @Override
    public String toString() {
        // TODO: implement method.
        return "*" + this.weight;
    }

    @Override
    public StickSet getStickSetView() {
        return new StickSetViewS(null, null);
    }

    @Override
    public StarIterator iterator() {
        return new LonelyStarIter(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public int hashCode() {
        return this.weight;
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
