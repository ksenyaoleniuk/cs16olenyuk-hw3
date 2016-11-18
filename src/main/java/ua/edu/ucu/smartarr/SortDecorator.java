package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{

    private final MyComparator myComparator;
    private final SmartArray smartArray;
    private int size;
    public SortDecorator(SmartArray smartArray, MyComparator myComparator){
        super(smartArray);
        this.myComparator = myComparator;
        this.smartArray = smartArray;}
    public Object[] toArray() {
        return usingMyComparatorSort();
    }

    public String operationDescription() {
        return "SortDecorator";
    }

    public int size() {
        return usingMyComparatorSort().length;
    }
    public Object[] usingMyComparatorSort(){
        Object[] newList = smartArray.toArray();
        Arrays.sort(newList, myComparator);
        return newList;
        }

    }

