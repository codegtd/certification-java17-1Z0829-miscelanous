package org.example.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapSetExamplesV2 {
  public static void main(String[] args) {

    Map<String, Integer> map = new TreeMap<>(
         Map.of("M", 30, "J", 35,
                "R", 23, "G", 15
         ));

    Set viewSet = map.entrySet();
    Collection<Integer> viewValues = map.values();
    Collection<String> viewKeys = map.keySet();

    showMapsAndViews(map, viewSet, viewValues, viewKeys, "Before Remove");

    viewSet.remove(Map.entry("M", 30));
    viewValues.remove(35);
    viewKeys.remove("R");

    showMapsAndViews(map, viewSet, viewValues, viewKeys, "After Remove");


    Map<String, Integer> mutable1 = new TreeMap<>(Map.copyOf(map));
    mutable1.putAll(Map.ofEntries(Map.entry("S", 15)));

    Map<String, Integer> immutable1 = Map.copyOf(map);
    Map<String, Integer> immutable2 = Map.ofEntries(Map.entry("J", 5));
    mutable1.put("K", 25);

    /*╔════════════════════════════════════════════════╗
      ║                   Add/AddAll                   ║
      ╠════════════════════════════════════════════════╣
      ║ not support, keySet/entrySet/values            ║
      ║ even in mutable1 map                           ║
      ║ mutable1.entrySet().add(Map.entry("John", 35));║
      ╚════════════════════════════════════════════════╝*/
    System.out.println(immutable2);

  }

  private static void showMutability(
       Map<String, Integer> mutable,
       Map<String, Integer> immutable) {

    System.out.println(mutable);
    System.out.println(immutable);
  }

  private static void showMapsAndViews(
       Map<String, Integer> map,
       Set set,
       Collection<Integer> values,
       Collection<String> keys,
       String txt) {

    System.out.println("\n" + txt + "-------------------------");
    System.out.println(" originMap: " + map);
    System.out.println("   viewSet: " + set);
    System.out.println("viewValues: " + values);
    System.out.println("  viewKeys: " + keys);
  }
}