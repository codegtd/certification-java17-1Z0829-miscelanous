package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenericsInheritance {
  private static void methodNumber(ArrayList<Number> numberList) {
    System.out.println(
         "ArrayList<Number>: " + numberList.getClass().getName());   }

  private static void methodWildcard(ArrayList<? extends Number> numberList) {
    System.out.println(
         "ArrayList<? extends Number>: " + numberList.getClass().getName()); }

  private static void methodList(List<Integer> integerList) {
    System.out.println("List<Integer>: " + integerList.getClass().getName()); }

  public static void main(String[] args) {
    ArrayList<Integer> integerArrayList = new ArrayList<>();

//    ArrayList<Number> numberArrayList = integerArrayList;
//    methodNumber(integerArrayList);

    ArrayList<? extends Number> numberList = integerArrayList;
    methodWildcard(integerArrayList);

    List<Integer> integerList = integerArrayList;
    ArrayList<Integer> intList2 = (ArrayList<Integer>) integerList;
    methodList(integerArrayList);
  }
}