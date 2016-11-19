package main.java.ua.edu.ucu;

import java.util.Arrays;

import main.java.ua.edu.ucu.functions.MyComparator;
import main.java.ua.edu.ucu.functions.MyFunction;
import main.java.ua.edu.ucu.functions.MyPredicate;
import main.java.ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

//         Hint: to convert Object[] to String[] - use the following code
//        Object[] result = studentSmartArray.toArray();
//        return Arrays.copyOf(result, result.length, String[].class);
//        SmartArray studentSmartArray = new BaseArray(students);
        MyPredicate myPred = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2;
            }
        };
        MyPredicate myPred1 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student )t).getGPA() >= 4;
            }
        };
         MyComparator myComparator = new MyComparator() {
             @Override
             public int compare(Object o1, Object o2) {
                 int result = (((Student) o1).getSurname().compareTo(((Student) o2).getSurname()));
                 return result;
             }
         };
         MyFunction myfunc = new MyFunction() {
             @Override
             public Object apply(Object t) {
                 return ((Student)t).getSurname() + " "+ ((Student)t).getName();
             }
         };
        SmartArray studentSmartArray = new BaseArray(students);

        studentSmartArray = new DistinctDecorator(studentSmartArray); // Result: [2, 1, 3];
        studentSmartArray = new FilterDecorator(studentSmartArray, myPred); // Result: [1, 2, 3]
        studentSmartArray = new FilterDecorator(studentSmartArray, myPred1);
        studentSmartArray = new SortDecorator(studentSmartArray, myComparator);
        studentSmartArray = new MapDecorator(studentSmartArray, myfunc);

        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);

    }}
