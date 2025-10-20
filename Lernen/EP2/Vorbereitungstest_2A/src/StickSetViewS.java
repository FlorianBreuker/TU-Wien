import java.util.ArrayList;

public class StickSetViewS implements StickSet {
    private ArrayList<Mobile> attachments;
    private Stick self;

    public StickSetViewS(ArrayList<Mobile> mobiles, Stick self) {
        attachments = mobiles;
        this.self = self;
    }

    @Override
    public int size() {
        if (attachments == null || self == null) return 0;
        int count = 1;
        for (Mobile mobile : this.attachments) {
            count += mobile.getStickSetView().size();
        }
        return count;
    }

    @Override
    public boolean contains(Stick element) {
        if (attachments == null || self == null) return false;
        if (self.equals(element)) return true;

        for (Mobile mobile : this.attachments) {
            if (mobile.getStickSetView().contains(element)) return true;
        }

        return false;
    }
}
