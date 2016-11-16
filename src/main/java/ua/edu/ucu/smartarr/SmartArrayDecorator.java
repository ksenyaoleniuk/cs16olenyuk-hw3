package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.smartarr.SmartArray;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

}
