package org.example.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Create a Custom Comparator
class LastNameComparator implements Comparator<String> {

  // Do not want natural order
  // I want to sort by the last name
  public int compare(String o1, String o2) {

    if (o1 == null || o2 == null) return - 1;

    // Split names on whitespace
    String[] names1 = o1.split("\\s");
    String[] names2 = o2.split("\\s");

    // Assumption is last String is the last name, leverage
    // compareTo method of String which implements Comparable
    return names1[names1.length - 1].compareTo(names2[names2.length - 1]);
  }
}

public class ComparatorExample {
  public static void main(String[] args) {
    String[] names = {"Ralph Smith", "Martha Jones", "Anne Green"};
//
//    System.out.println("------ Unsorted initial List ------");
//    for (String name : names) {   System.out.println(name);   }
//
//    Arrays.sort(names);
//
//    System.out.println("------ Arrays.sort(String[]) ------");
//    for (String name : names) {   System.out.println(name);   }

    //---------------------------------------------------------
    // Use collections class, ArrayList
    List<String> list = new ArrayList<>(List.of(names)); show(list);

    list.sort(Comparator.reverseOrder());    show(list);
    list.sort(Comparator.naturalOrder());    show(list);

    LastNameComparator l = new LastNameComparator();
    list.sort(l);              show(list);
    list.sort(l.reversed());   show(list);

    list.add(null);
    list.sort(Comparator.nullsFirst(l.reversed()));   show(list);
    list.sort(Comparator.nullsLast(l.reversed()));    show(list);
  }

  private static void show(List<String> list) {
    list.forEach(System.out::println);
  }
}