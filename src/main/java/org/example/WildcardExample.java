package org.example;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

  public static void printUpperList(List<? extends Exception> list) {
    // when using an upper bound: provide specific methods+attributes
    System.out.println("----- Upper bound ------");
    list.forEach((s) -> System.out.println(s.getLocalizedMessage()));
  }

  public static void printLowerList(List<? super Exception> list) {

    System.out.println("----- Lower bound ------");
    list.forEach((s) -> System.out.println(s));
  }

  public static void printOpenDoor(List<?> list) {

    System.out.println("----- No bounds ------");
    list.forEach((s) -> System.out.println(s));
  }

  public static void printObjectList(List<Object> list) {

    System.out.println("----- List Objects ------");
    list.forEach((object) -> System.out.println(object));
  }

  public static void main(String[] args) {

    // Create two lists typed slightly differently
    ArrayList<RuntimeException> runtimeExcList = new ArrayList<>();
    ArrayList<Exception> excepList = new ArrayList<>();

    // Populate with some forced exceptions
    for (int i = 0; i < 3; i++) {
      try {
        int j = i / 0;
      }
      catch (RuntimeException e) {
        runtimeExcList.add(e);
        excepList.add(e);
      }
    }

    // RuntimeException allowed by upper bounded <? extends Exception>
    printUpperList(runtimeExcList);
    // RuntimeException allowed by unbounded <?>
    printOpenDoor(runtimeExcList);

    // RuntimeException NOT allowed by lower bounded <? super Exception>
    //-- printLowerList(runtimeExcList);

    // RuntimeException NOT allowed by type arg <Object>
    //-- printObjectList(runtimeExcList);

    // Exception allowed by upper bounded <? extends Exception>
    printUpperList(excepList);
    // Exception allowed by lower bounded <? super Exception>
    printLowerList(excepList);
    // Exception allowed by unbounded <?>
    printOpenDoor(excepList);

    // Exception NOT allowed by type arg <Object>
    //-- printObjectList(excepList);

    List<Integer> integerList = List.<Integer>of(5, 10, 15);
    // Integer type allowed by unbounded wildcard <?>
    printOpenDoor(integerList);

    // Integer NOT allowed by upper bounded <? extends Exception>
    //-- printUpperList(integerList);
    // Integer NOT allowed by lower bounded <? super Exception>
    //-- printLowerList(integerList);
    // Integer NOT allowed by type arg <Object>
//    printObjectList(integerList);

    // Object meets requirement for all the methods, with the
    // exception of the upper bound method.
    List<Object> objectList = List.of("a", "B", "c");

    // Object allowed by <? super Exception>
    printLowerList(objectList);
    // Object allowed by <?>
    printOpenDoor(objectList);
    // Object allowed by <Object>
    printObjectList(objectList);

    // Object NOT allowed by upper bounded <? extends Exception>
    //--printUpperList(objectList);

    List rawList = integerList;
    printObjectList(rawList);
    printObjectList((List) integerList);


    List integerList2 = List.<Integer>of(5, 10, 15);
    printObjectList(integerList2);
  }
}