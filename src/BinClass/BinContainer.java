package BinClass;

import java.util.ArrayList;

public class BinContainer {
    private double maxWeight = 10.0;
    private double loadWeight;
    private ArrayList<BinObject> objects = new ArrayList<>();

    public BinContainer() {
        this.loadWeight = 0;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void addBins(BinObject loadbin) {
        this.objects.add(loadbin);
        this.loadWeight += loadbin.getWeight();
    }

    public ArrayList<BinObject> getObjects() {
        return objects;
    }
}
