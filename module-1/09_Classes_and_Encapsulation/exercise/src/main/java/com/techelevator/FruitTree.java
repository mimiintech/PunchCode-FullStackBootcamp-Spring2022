package com.techelevator;

public class FruitTree {
<<<<<<< HEAD


//    instance variables/attributes

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Private means the


    //    create a constructor with 2 arguments/parameters
    public FruitTree(String typeOfFruit, int piecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruit;

    }

//    create getter(s)

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruit() {
        return piecesOfFruitLeft;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    //    create method - return a boolean
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft - numberOfPiecesToRemove >= 0) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }
        return false;
    }
=======

>>>>>>> upstream/main
}
