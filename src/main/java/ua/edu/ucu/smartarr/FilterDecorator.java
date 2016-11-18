package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private  MyPredicate myPred;
    private final SmartArray smartArray;
    private int size;
    public FilterDecorator(SmartArray smartArray, MyPredicate myPred){
        super(smartArray);
        this.myPred = myPred;
        this.smartArray = smartArray;
    }
    @Override
    public Object[] toArray() {
        return usingMyPredicate();
    }
    @Override
    public String operationDescription() {
        return "FilterDecorator";
    }
    @Override
    public int size() {
        return usingMyPredicate().length;
    }

    public Object[] usingMyPredicate(){
        Object[] tmp = smartArray.toArray();
        int newSize = tmp.length;
        for(int i = 0; i < tmp.length; i++){
            if(!myPred.test(tmp[i])){
                newSize--;
            }
        }
        int j = 0;
        Object[] newList = new Object[newSize];
        for(int i = 0; i < tmp.length; i++){
            if(myPred.test(tmp[i])){
                newList[j] = tmp[i];
                j++;

        }
    }
        return newList;

    }}
