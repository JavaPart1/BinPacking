package BinApp;

import BinClass.BinContainer;
import BinClass.BinObject;
import BinClass.WareHouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Pack {
    public static void main(String[] args) {
        // declarations & initializations
        Scanner input = new Scanner(System.in);
        WareHouse wareHouse = new WareHouse();
        BinContainer binContainer = new BinContainer();
        wareHouse.addContainer(binContainer);// Push container in warehouse
        BinObject binObject;
        ArrayList<BinObject> tempObjects = new ArrayList<>();// Create temp arraylist for objects

        // input how many objects
        System.out.print("How many objects to store in containers ? ");
        int nbrOffObjects  = input.nextInt();

        // input weight of objects
        Double inWeight;
        for (int i = 0; i < nbrOffObjects; i++) {
            do {
                System.out.print("Weight (must be < " +
                        binContainer.getMaxWeight() + ") for object " + i + " : ");
                inWeight = input.nextDouble();

            } while (inWeight > binContainer.getMaxWeight());// weight has to be < max
            binObject = new BinObject();
            binObject.setWeight(inWeight);
            tempObjects.add(binObject);// Put each object in temp arraylist
        }
        // Process objects in arraylist to best suit in containers
        int bestsuit;
        int lastContainer = 0;
        for (int i = 0; i < tempObjects.size() ; i++) {
            if (!tempObjects.get(i).isPacked()){// Objects already in container can be skipped
                if (lastContainer >= wareHouse.getStoredContainers().size()){// need a new container
                    binContainer = new BinContainer();
                    wareHouse.getStoredContainers().add(binContainer);
                    lastContainer = wareHouse.getStoredContainers().size() - 1;
                }
                // Put object in container
                wareHouse.getStoredContainers().get(lastContainer).addBin(tempObjects.get(i));
                // Try to add more objects in container
                bestsuit = tempObjects.size();
                // While there is still room in container and while there are still objects to be packed
                while (wareHouse.getStoredContainers().get(lastContainer).getFreeWeight() > 0 & bestsuit > 0){
                    // What is the best suitable object for the container
                    bestsuit = wareHouse.getStoredContainers().get(lastContainer).bestsuitable(tempObjects);
                    if (bestsuit > 0){
                        // Put the best object in the container
                        wareHouse.getStoredContainers().get(lastContainer).addBin(tempObjects.get(bestsuit));
                    }
                }
                lastContainer++;
            }
        }
        // print containers
        System.out.println(" ");//cr
        for (int i = 0; i < wareHouse.getStoredContainers().size() ; i++) {
            System.out.print("Container " + i + " contains objects with weight : ");
            for (int j = 0; j < wareHouse.getStoredContainers().get(i).getObjects().size(); j++) {
                System.out.print(wareHouse.getStoredContainers().get(i).getObjects().get(j).getWeight() +
                        " ");
            }
            System.out.print(" ; total weight: " +
                    wareHouse.getStoredContainers().get(i).getLoadWeight() +
                    " pounds");
            System.out.println(" ; marge: " +
                     wareHouse.getStoredContainers().get(i).getFreeWeight() + " pounds");
        }
    }

}
