package App;

import BinClass.BinContainer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pack {
    public static void main(String[] args) {
        // declarations & initializations
        Scanner input = new Scanner(System.in);
        BinContainer container = new BinContainer();

        // input hoeveel objecten
        System.out.print("How many objects to store in containers ?");
        int nbrOffObjects  = input.nextInt();

        // input weight vn elk object
        ArrayList<Double> mainObjects = new ArrayList<>();
        for (int i = 0; i < nbrOffObjects; i++) {
            System.out.println("Weight of object (must be < " +
                    container.getMaxWeight() + " for object " + i + " : ");
            mainObjects.add(input.nextDouble());

        }

        // zet de objecten in containers
        for (int i = 0; i < mainObjects.size() ; i++) {

        }
    }
}
