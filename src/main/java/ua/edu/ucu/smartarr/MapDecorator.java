package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction func;
    private final SmartArray smartArray;
    private int size;
    public MapDecorator(SmartArray smartArray, MyFunction func){
        super(smartArray);
        this.func = func;
        this.smartArray = smartArray;
    }
    @Override
    public Object[] toArray() {
        return usingMyFunction();
    }
    @Override
    public String operationDescription() {
        return "MapDecorator";
    }
    @Override
    public int size() {
        return usingMyFunction().length;
    }

    public  Object[] usingMyFunction(){
        Object[] newList = smartArray.toArray();
        for(int i = 0; i < smartArray.size(); i++){
            newList[i] = func.apply(newList[i]);
        }
        return newList;
    }
}
