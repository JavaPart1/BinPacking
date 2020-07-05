package BinClass;

import java.util.ArrayList;

public class WareHouse {
    private ArrayList<BinContainer> storedContainers = new ArrayList<>();
    private static int nbrOffContainers;

    public WareHouse() {
        nbrOffContainers = 0;
    }

    public boolean addContainer(BinContainer binContainer){
        this.storedContainers.add(binContainer);
        nbrOffContainers++;
        return true; // voorlopig geen restricties
    }

    public ArrayList<BinContainer> getStoredContainers() {
        return storedContainers;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "storedContainers=" + storedContainers +
                '}';
    }
}
