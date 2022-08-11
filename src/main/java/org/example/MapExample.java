package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

  public static void main(String[] args) {
    // Create three maps with String keys and Integer values.
    Map<String, Integer> h = new HashMap<>();
    Map<String, Integer> t = new TreeMap<>();
    Map<String, Integer> l = new LinkedHashMap<>();

    String[] names = new String[]{"Barry", "George", "Harold", "Ida", "John"};

    // Fill the map with some data, using put.
    for (int i = 0; i < names.length; i++) {
      h.put(names[i], (i + 1));
      t.put(names[i], (i + 1));
      l.put(names[i], (i + 1));
    }

    // Test if null keys and null values are allowed
    Map<String, Integer> currentMap;
    for (int i = 0; i < 3; i++) {
      if (i == 0) currentMap = l;
      else if (i == 1) currentMap = h;
      else currentMap = t;
      try {
        // Insert map entry with a null value
        currentMap.put("NullValue", null);

        // Insert map entry with a null key
        currentMap.put(null, 12);

      }
      catch (Exception e) {
        System.out.println(currentMap.getClass()
                                     .toGenericString() +
                                " does not support null keys");
        System.out.println(e.toString());

      }
    }

    // Print out data, the entire set, then each element of set.
    System.out.println("--- HashMap: " + h);
    h.entrySet()
     .forEach((s) ->
                   System.out.println(s.getClass()
                                       .getName() + " : " + s));

    // Print out data, the entire set, then each element of set.
    System.out.println("--- TreeMap: " + t);
    t.entrySet()
     .forEach((s) ->
                   System.out.println(s.getClass()
                                       .getName() + " : " + s));

    // Print out data, the entire set, then each element of set.
    System.out.println("--- LinkedHashMap: " + l);
    l.entrySet()
     .forEach((s) ->
                   System.out.println(s.getClass()
                                       .getName() + " : " + s));

  }
}