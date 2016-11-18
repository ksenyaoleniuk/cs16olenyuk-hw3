package main.java.ua.edu.ucu.smartarr;
public class DistinctDecorator extends SmartArrayDecorator {
    private int size;
    private final SmartArray smartArray;
    public DistinctDecorator(SmartArray smartArray){
        super(smartArray);
        this.smartArray = smartArray;
    }
    @Override
    public Object[] toArray() {
        return this.arrayWithoutEqual();
    }
    @Override
    public String operationDescription() {
        return "Distinct decorator";
    }
    @Override
    public int size() {
        return arrayWithoutEqual().length;
    }

    public Object[] arrayWithoutEqual() {
        int newSize = smartArray.size();
        Object[] tmp = smartArray.toArray();
        for (int i = 0; i < tmp.length; i++) {
            for (int j = i; j < tmp.length; j++) {
                if (tmp[i].equals(tmp[j]) && (i != j) && (! tmp[i].equals(("equal")))) {
                    tmp[i] = "equal";
                    newSize--;
                }

            }
        }
        int j = 0;
        Object[] newList = new Object[newSize];
        for(int i = 0; i < tmp.length; i++){
            if(!tmp[i].equals("equal")){
                newList[j] = tmp[i];
                j++;
            }
        }
        return newList;
    }}