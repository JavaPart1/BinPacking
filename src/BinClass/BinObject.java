package BinClass;

public class BinObject {
    private double weight;
    private boolean packed;

    public BinObject() {
        packed = false;
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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BinObject{" +
                "weight=" + weight +
                '}';
    }
}
