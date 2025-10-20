public class LonelyStarIter implements StarIterator {
    private Star star;
    private boolean used;

    public LonelyStarIter(Star star) {
        this.star = star;
        used = false;
    }

    @Override
    public boolean hasNext() {
        return !used;
    }

    @Override
    public Star next() {
        used = true;
        return star;
    }
}
