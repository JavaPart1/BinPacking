package BinClass;

import java.util.ArrayList;

public class BinContainer {
    private double maxWeight = 10.0;
    private double loadWeight;
    private ArrayList<BinObject> loadedbins = new ArrayList<>();

    public BinContainer() {
        this.loadWeight = 0;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getFreeWeight() {
        return maxWeight - loadWeight;
    }

    public boolean addBin(BinObject loadbin) {
        if (this.getLoadWeight()+loadbin.getWeight() <= this.getMaxWeight()){
            this.loadedbins.add(loadbin);
            this.loadWeight += loadbin.getWeight();
            loadbin.setPacked(true);
            return true;
        }
        return false;
    }

    public ArrayList<BinObject> getObjects() {
        return loadedbins;
    }

    @Override
    public String toString() {
        return "BinContainer{" +
                "maxWeight=" + maxWeight +
                ", loadWeight=" + loadWeight +
                ", loadedbins=" + loadedbins +
                '}';
    }
}
