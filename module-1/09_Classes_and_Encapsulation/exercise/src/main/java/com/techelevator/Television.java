package com.techelevator;

public class Television {

<<<<<<< HEAD
    //    instance variables/attributes
    private boolean isOn; //Default TV is off
    //    Whether or not the TV is turned on.
    private int currentChannel = 3; //Default channel set to 3
    //    The value for the current channel. Channel levels go between 3 and 18.
    private int currentVolume = 2; //Default volume set to 2
//    The current volume level.


//    declare boolean condition and return (method)

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public boolean isOn() {
        return isOn;
    }


    //    create method
    public void turnOff()
    //- `turnOff()` turns off the TV.
    {isOn = false;}


    public void turnOn() {
        //  - `turnOn()` turns the TV on and also resets the channel to three and the volume level to two.
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
//    create method to change channel from default
//  - `changeChannel(int newChannel)` changes the current channel—only if it's on—to the value of `newChannel` as long as it's between 3 and 18.
        if (isOn && newChannel > 3 && newChannel < 18) {
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
//   - `channelUp()` increases the current channel by one, only if it's on. If the value goes past 18, then the current channel must be set to three.
        if (isOn) {
            if (currentChannel == 18) {
                currentChannel = 3;
            } else {
                currentChannel++;
            }
        }
    }
        //    The value for the current channel. Channel levels go between 3 and 18.

        public void channelDown () {
//  - `channelDown()` decreases the current channel by one, only if it's on. If the value goes below three, then the current channel must be set to 18.
            if (isOn) {
                if (currentChannel == 3) {
                    currentChannel = 18;
                } else {
                    currentChannel--;
                }

            }
        }
            public void raiseVolume () {
//    create method to increase volume
//  - `raiseVolume()` increases the volume by one, only if it's on. The limit is 10.
                if (isOn && currentVolume < 10) {
                    currentVolume++;
                }
            }
            //Default volume set to 2
            public void lowerVolume () {
//    create method to lower volume
//  - `lowerVolume()` decreases the volume by one, only if it's on. The limit is zero.
                if (isOn && currentVolume > 0) {
                    currentVolume--;
                }
            }

        }
=======
}
>>>>>>> upstream/main
