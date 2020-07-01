package BinApp;

import BinClass.BinContainer;
import BinClass.BinObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Pack {
    public static void main(String[] args) {
        // declarations & initializations
        Scanner input = new Scanner(System.in);
        BinContainer container = new BinContainer();
        ArrayList<BinContainer> mainContainers = new ArrayList<>();

        // input hoeveel objecten
        System.out.print("How many objects to store in containers ?");
        int nbrOffObjects  = input.nextInt();

        // input weight vn elk object en zet in arraylist
        ArrayList<BinObject> mainObjects = new ArrayList<>();
        BinObject bob;
        Double userInput;
        for (int i = 0; i < nbrOffObjects; i++) {
            do {
                System.out.println("Weight of object (must be < " +
                        container.getMaxWeight() + " for object " + i + " : ");
                userInput = input.nextDouble();

            } while (userInput > container.getMaxWeight());
            bob = new BinObject(userInput,false);
            mainObjects.add(bob);
        }

        // sorteer arraylist op weight groot nr klein
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
        }
        // zet de objecten in containers
        for (int i = 0; i < mainObjects.size() ; i++) {


        }
    }
}
