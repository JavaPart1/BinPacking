package BinClass;

public class BinObject {
    private double weight;
    private boolean packed;

    public BinObject(double weight,boolean packed) {
        this.weight = weight;
        this.packed = packed;
    }

    public double getWeight() {
        return weight;
    }
}
