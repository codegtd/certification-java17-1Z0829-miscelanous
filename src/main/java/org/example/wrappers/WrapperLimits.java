package org.example.wrappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapperLimits {
  public static void main(String[] args) {

    double d = 32.0f;

    double[] doubleArray = new double[]{32.0f};

    System.out.println("Primitive assignment, float to double: " + d);
    System.out.println("Primitive array initialization assignment," +
                            " float to double: " + Arrays.toString(doubleArray));

    //    Double wrapper= 32.0f;
    //    Double[] wrappedArray = new Double[]{32.0f};

    // A List of float literals cannot be passed to constructor of Double
    //    List<Double> doubleList = new ArrayList<Double>(List.of(32.2f));

    // Cannot add a literal float to a List of Double
    //    List<Double> doubleList2 = new ArrayList<Double>();
    //    doubleList2.add(32.2f);

    // Typing only on the assignment side does not place compiler error
    // restrictions on elements added.
    //    List numberList = new ArrayList<Integer>();

    //    List<Number> integerList = new ArrayList<Integer>();
    //    List integerList = new ArrayList<Integer>();
//    List<? extends Number> integerList = new ArrayList<Integer>();
    List<? super Integer> integerList = new ArrayList<Integer>();
    integerList.add(5);

  }
}