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
        wareHouse.addContainer(binContainer);
        BinObject zomerdekbed;
        ArrayList<BinObject> contObjects = new ArrayList<>();

        // input hoeveel objecten
        System.out.print("How many objects to store in containers ? ");
        int nbrOffObjects  = input.nextInt();

        // input weight vn elk object en zet in arraylist
        Double inWeight;
        for (int i = 0; i < nbrOffObjects; i++) {
            do {
                System.out.print("Weight (must be < " +
                        binContainer.getMaxWeight() + ") for object " + i + " : ");
                inWeight = input.nextDouble();

            } while (inWeight > binContainer.getMaxWeight());
            zomerdekbed = new BinObject();
            zomerdekbed.setWeight(inWeight);
            contObjects.add(zomerdekbed);

        }
        int bestsuit;
        int lastContainer = 0;
        for (int i = 0; i < contObjects.size() ; i++) {
            System.out.println("bin " + i + " packed? "+ contObjects.get(i).isPacked());
            if (!contObjects.get(i).isPacked()){
                if (lastContainer >= wareHouse.getStoredContainers().size()){
                    System.out.println("container bijmaken...");
                    binContainer = new BinContainer();
                    wareHouse.getStoredContainers().add(binContainer);
                    lastContainer = wareHouse.getStoredContainers().size() - 1;
                }
                wareHouse.getStoredContainers().get(lastContainer).addBin(contObjects.get(i));
                System.out.println("zet bin " + i + " in container " + lastContainer);
                bestsuit = contObjects.size();
                while (wareHouse.getStoredContainers().get(lastContainer).getFreeWeight() > 0 & bestsuit > 0){
                    System.out.println("best passende zoeken...");
                    // bepaal best passende
                    bestsuit = bestsuitable(wareHouse.getStoredContainers().get(lastContainer),contObjects);
                    // indien gevonden
                    if (bestsuit > 0){
                        System.out.println("best passende gevonden");
                        wareHouse.getStoredContainers().get(lastContainer).addBin(contObjects.get(bestsuit));
                    }
                }
                lastContainer++;
            }
        }
        System.out.println("Aantal containers : " + wareHouse.getStoredContainers().size());

        // afprinten vn containers
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
    public static int bestsuitable(BinContainer targetContainer,ArrayList<BinObject> sourceBins){
        int bestSuitable = 0;
        double restMarge = targetContainer.getMaxWeight();

        for (int i = 0; i < sourceBins.size() ; i++) {
            if (sourceBins.get(i).getWeight() <= targetContainer.getFreeWeight() &
                    !sourceBins.get(i).isPacked()){
                if (restMarge > targetContainer.getFreeWeight() - sourceBins.get(i).getWeight()){
                    restMarge = targetContainer.getFreeWeight() - sourceBins.get(i).getWeight();
                    bestSuitable = i;
                }
            }
        }
        return bestSuitable;
    }
}
