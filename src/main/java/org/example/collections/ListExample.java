package org.example.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListExample {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("Anne", "Barry", "Charles"));
    List<String> subList = list.subList(1, 2);

    list.add(2, "Brad1");
    list.add("Brad2");

    System.out.println("List: " + list);
    System.out.println("Sublist: " + subList);

  }

  private static void doSimpleListStuff(List<String> list) {

    // You'll note that add does not return a boolean.
    list.add(0, "Arnold");

    System.out.println("After adding Arnold at index 0 :" +
                            " : " + list);

    System.out.println("After adding others at index 0 : " +
                            list.addAll(0, List.of("Aaron", "Able")) + " : " + list);

    System.out.println("Setting name at index 2 : " +
                            list.set(2, "Annette") + " : " + list);

    System.out.println("Arnold can be found at : " +
                            list.indexOf("Arnold"));

    System.out.println("Annette can be found at : " +
                            list.indexOf("Annette"));

    list.add(0, "David");
    System.out.println("After adding David at index 0 :" +
                            " : " + list);

    System.out.println("The last David can be found at index : " +
                            list.lastIndexOf("David"));
  }
}