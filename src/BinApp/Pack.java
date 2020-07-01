package BinApp;

import BinClass.BinContainer;
import BinClass.BinObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Pack {
    public static void main(String[] args) {
        // declarations & initializations
        Scanner input = new Scanner(System.in);
        BinContainer container = new BinContainer(); // temp container
        ArrayList<BinContainer> mainContainers = new ArrayList<>();

        // input hoeveel objecten
        System.out.print("How many objects to store in containers ? ");
        int nbrOffObjects  = input.nextInt();

        // input weight vn elk object en zet in arraylist
        ArrayList<BinObject> mainObjects = new ArrayList<>();
        BinObject bob;
        Double userInput;
        for (int i = 0; i < nbrOffObjects; i++) {
            do {
                System.out.print("Weight (must be < " +
                        container.getMaxWeight() + ") for object " + i + " : ");
                userInput = input.nextDouble();

            } while (userInput > container.getMaxWeight());
            bob = new BinObject(userInput,false);
            mainObjects.add(bob);
        }

        /* sorteer arraylist op weight groot nr klein
        BinObject temp1 = new BinObject(0,false);
        BinObject temp2 = new BinObject(0,false);
        for (int i = 1; i < (mainObjects.size()-1) ; i++) {
            for (int j = 0; j < (mainObjects.size()-i) ; j++) {
                if (mainObjects.get(j).getWeight() < mainObjects.get(j+1).getWeight()){
                    temp1 = mainObjects.get(j);
                    temp2 = mainObjects.get(j+1);
                    mainObjects.remove(j);
                    mainObjects.remove(j+1);
                    mainObjects.add(j,temp2);
                    mainObjects.add(j+1,temp1);
                }

            }
        }*/
        // zet de objecten in containers
        int gepacked = 0;
        do {
            container = new BinContainer(); // eerste te gebruiken container
            for (int i = 0; i < mainObjects.size() ; i++) {
                if (!mainObjects.get(i).isPacked()){
                    if ((container.getLoadWeight()+mainObjects.get(i).getWeight())
                            <= container.getMaxWeight()){
                        container.addBins(mainObjects.get(i));
                        mainObjects.get(i).setPacked(true);
                        gepacked++;
                    }
                }
            }
            mainContainers.add(container);
        } while (gepacked < mainObjects.size());

        // afprinten vn containers
        System.out.println(" ");//cr
        for (int i = 0; i < mainContainers.size() ; i++) {
            System.out.print("Container " + i + " contains objects with weight : ");
            for (int j = 0; j < mainContainers.get(i).getObjects().size(); j++) {
                System.out.print(mainContainers.get(i).getObjects().get(j).getWeight() +
                        " ");
            }
            System.out.print(" ; total weight: " +
                    mainContainers.get(i).getLoadWeight() +
                    " pounds");
            System.out.println(" ; marge: " +
                    (mainContainers.get(i).getMaxWeight() -
                            mainContainers.get(i).getLoadWeight()) +
                    " pounds");
        }
    }
}
