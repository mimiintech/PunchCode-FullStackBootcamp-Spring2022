package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {


    public static void main(String[] args) {

        // Step One: Declare a Map

        Map<String, String> projects = new HashMap<String, String>();

        // Step Two: Add items to a Map

        projects.remove("Grace");


        projects.put("Ada", "Inventing Computer Programming");
        projects.put("Grace", "COBOL");
        projects.put("Margaret", "Apollo Guidance Computer");
        projects.put("Adele", "Graphical User Interfaces");


        // Step Three: Loop through a Map

        for (Map.Entry<String, String> project : projects.entrySet()) {
            System.out.println("The key " + project.getKey() + " is linked to the value " + project.getValue());

//            you can assign each element to a temporary `Map.Entry<String, String>` variable, and use
//        the `getKey()` and `getValue()` methods to access the key and value:

//            Your `Map.Entry` must have the same types as the `Map` that you're looping through.
//`Map`s, the `remove()` method removes an item from the collection

//
//            you added items to the `Map`, you had to provide both the key and value, but to remove
//            an item, you only need the key.

//
//            `Map` is an unordered data structure, the order of the items displayed may not be
//            in the same order as the example.

        }

    }

}