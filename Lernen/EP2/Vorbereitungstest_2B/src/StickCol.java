public class StickCol implements StarCollection {
    private Mobile[] attached;
    private BalancedStick stick;

    public StickCol(Mobile[] att, BalancedStick self) {
        this.attached = att;
        this.stick = self;
    }

    @Override
    public boolean contains(Star s) {
        for (Mobile mob : attached) {
            if (mob.getStarCollection().contains(s)) return true;
        }
        return false;
    }

    @Override
    public StarIterator iterator() {
        return stick.iterator();
    }
}
