public class StarColl implements StarCollection {
    private Star self;

    public StarColl(Star star) {
        this.self = star;
    }

    @Override
    public boolean contains(Star s) {
        return self.equals(s);
    }

    @Override
    public StarIterator iterator() {
        return self.iterator();
    }
}
