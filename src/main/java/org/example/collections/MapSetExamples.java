package org.example.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapSetExamples {
  public static void main(String[] args) {

    // Use Map.of to populate a Map, with comma delimited viewValues
    // representing key1, value1, key2, value2 etc.
    Map<String, Integer> originMap = new TreeMap<>(Map.of(
         "Mary", 30,
         "John", 35,
         "Ralph", 23,
         "George", 15,
         "Kate", 50
    ));
    System.out.println("0) Initial Values: " + originMap);

    // This returns a modifiable View of the Map, however, you
    // cannot add entries.
    Set viewSet = originMap.entrySet();
    viewSet.remove("John");
    System.out.println("1) "+originMap);

    viewSet.remove(Map.entry("John", 25));
    System.out.println("2) "+originMap);

    viewSet.remove(Map.entry("John", 35));
//    originMap.remove("Kate");
    System.out.println("3) "+originMap);
    System.out.println("3.1) "+viewSet);

    // Collection of just the viewValues...
    Collection<Integer> viewValues = originMap.values();
    System.out.println("4) "+viewValues);
    System.out.println("4.1) "+originMap);
    viewValues.remove(23);
    System.out.println("4.2) "+originMap);
    System.out.println("4.3) "+viewValues);

    // Collection of just the keys
    Collection<String> viewKeys = originMap.keySet();
    System.out.println("5) "+originMap);
    System.out.println("5.1) "+viewKeys);
    viewKeys.remove("Mary");
    System.out.println("5.2) "+originMap);
    System.out.println("5.3) "+viewKeys);

    // Add some more viewValues to original Map.
    originMap.putAll(Map.of(
         "Carol", 5,
         "Martha", 46,
         "Mark", 33));
    System.out.println(originMap);
    System.out.println("viewKeys Size: " + viewKeys.size());
    System.out.println("viewValues Size: " + viewValues.size());
    System.out.println("viewSet Size: " + viewSet.size());

    Map<String, Integer> tCopyMutable = new TreeMap<>(Map.copyOf(originMap));
    tCopyMutable.put("Tom", 30);
    System.out.println(tCopyMutable);

    Map<String, Integer> tCopyImmutable = Map.copyOf(originMap);
//    tCopyImmutable.put("Tom", 30);
    System.out.println(tCopyImmutable);

    tCopyMutable.put("Ralph", 25);
    System.out.println(tCopyMutable);
    tCopyMutable.entrySet().add(Map.entry("John", 35));
    System.out.println(tCopyMutable);

  }
}