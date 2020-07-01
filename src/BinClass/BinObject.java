package BinClass;

public class BinObject {
    private double weight;
    private boolean packed;

    public BinObject(double weight,boolean packed) {
        this.weight = weight;
        this.packed = packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    public boolean isPacked() {
        return packed;
    }

    public double getWeight() {
        return weight;
    }
}
