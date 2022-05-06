package com.techelevator;

public class Elevator {
<<<<<<< HEAD
//name class and access level

    //    instance variables/attributes
    private int currentFloor = 1;
    // The current floor that the elevator is on.
    private int numberOfFloors;
    //The number of floors available to the elevator.
    private boolean doorOpen;
    // Whether the elevator door is open or not.

//    create constructor with 1 argument/parameter

    public Elevator(int numberOfLevels) {

        this.currentFloor = currentFloor;
        this.doorOpen = doorOpen;
        this.numberOfFloors = numberOfLevels;

    }

//    create getter(s)

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean getDoorOpen() {

        return doorOpen;
    }


//    create boolean for open door

    public boolean isDoorOpen() {
        return doorOpen;
    }

//    create method for to move elevator to desired floor

    public void openDoor() {

        doorOpen = true;
    }

    public void closeDoor() {
=======
>>>>>>> upstream/main

        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
//        - `goUp(int desiredFloor)` sends the elevator upward to the desired floor as long as the door isn't open. The elevator can't go past the last floor.
        int floorIncrementUp = (desiredFloor - getCurrentFloor());
        if (doorOpen) {
            closeDoor();
            currentFloor = getCurrentFloor();
        } else if (desiredFloor > getCurrentFloor() && desiredFloor <= getNumberOfFloors()) {
            currentFloor += floorIncrementUp;
        }

    }


//    if (doorOpen == false) {
//    if (desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
//    currentFloor = desiredFloor;
//    }
//    }
//    }

    public void goDown(int desiredFloor) {
        //- `goDown(int desiredFloor)` sends the elevator downward to the desired floor as long as the door isn't open. It can't go past floor one.

        int floorIncrementDown = getCurrentFloor() - desiredFloor;
        if (doorOpen) {
            closeDoor();
            currentFloor = getCurrentFloor();
        } else if (desiredFloor < getCurrentFloor() && desiredFloor > 0) {
            currentFloor -= floorIncrementDown;
        }
    }
}

// if (doorOpen == false) {
// if(desiredFloor <= numberOfFloors && desiredFloor < currentFloor && desiredFloor > 0) {
// currentFloor = desiredFloor;
//}
//}
//}
//}



