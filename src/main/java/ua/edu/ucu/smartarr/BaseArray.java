package main.java.ua.edu.ucu.smartarr;


import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] array;
    public BaseArray(Object[] array) {
        this.array = array;
    }
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, array.length);
    }
    @Override
    public String operationDescription() {
        return null;
    }
    @Override
    public int size() {
        return this.array.length;
    }
}
