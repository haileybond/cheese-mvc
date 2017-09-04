package org.launchcode.models;

import java.util.ArrayList;

public class CheeseData {

    //store cheeses in an arraylist as cheese objects
    static ArrayList<Cheese> cheeses = new ArrayList();

    //get all cheeses
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    //add cheese
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    //remove cheese
    public static void remove(int cheeseId) {
        Cheese cheeseToRemove = getById(cheeseId);
        cheeses.remove(cheeseToRemove);
    }

    //getById
    public static Cheese getById(int cheeseId) {
        Cheese theCheese = null;
        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == cheeseId) {
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }
}
