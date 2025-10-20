public class PixelNode {
    private PixelNode next;
    private Position key;
    private GreyLevel val;

    public PixelNode(PixelNode next, Position pos, GreyLevel val) {
        this.next = next;
        this.key = pos;
        this.val = val;
    }

    public PixelNode getNext() {
        return next;
    }

    public void setNext(PixelNode next) {
        this.next = next;
    }

    public Position getKey() {
        return key;
    }

    public GreyLevel getVal() {
        return val;
    }

    public void setVal(GreyLevel val) {
        this.val = val;
    }
}
