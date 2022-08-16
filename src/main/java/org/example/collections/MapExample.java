package org.example.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

  public static void main(String[] args) {

    Map<String, Integer> h = new HashMap<>();
    Map<String, Integer> t = new TreeMap<>();
    Map<String, Integer> l = new LinkedHashMap<>();

    //    String[] names = new String[]{"Barry", "George", "Harold", "Ida", "John"};
    String[] names = new String[]{"Barry", "George"};

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
        currentMap.put("NullValue", null);
        currentMap.put(null, 12);
      }
      catch (Exception e) {
        System.out.println(currentMap.getClass()
                                     .toGenericString() + "no accept null keys");
        System.out.println(e);
      }
    }

    // Print out data, the entire set, then each element of set.
    System.out.println("\n--- HashMap: " + h);
    h.entrySet()
     .forEach((s) -> System.out.println(s.getClass()
                                         .getName()
                                         .replace("java.util.", "") + " : " + s));

    // Print out data, the entire set, then each element of set.
    System.out.println("\n--- TreeMap: " + t);
    t.entrySet()
     .forEach((s) -> System.out.println(s.getClass()
                                         .getName()
                                         .replace("java.util.", "") + " : " + s));

    // Print out data, the entire set, then each element of set.
    System.out.println("\n--- LinkedHashMap: " + l);
    l.entrySet()
     .forEach((s) -> System.out.println(s.getClass()
                                         .getName()
                                         .replace("java.util.", "") + " : " + s));

    System.out.println("\n---- LinkedHashMap: do Simple Stuff -------");
    //    doSimpleMapStuff(l);

    System.out.println("\n--- LinkedHashMap: Compute methods ---");
    // Simplify map
    l.remove("NullValue");
    l.remove(null);
    l.remove("Maggie");
    //    testComputes(l);

    System.out.println("\n--- LinkedHashMap: test merge methods ---");
    testMerges(l);
  }

  private static void doSimpleMapStuff(Map<String, Integer> m) {
    // Get: if KEY exists 1(found) - null-not-found
    System.out.println("Value of m.get(Jane)) = " + m.get("Barry") + "|" + m);
    System.out.println("Contains a key 'Barry'?: " + m.containsKey("Barry") + " : " + m);
    System.out.println("Contains a value '7'?: " + m.containsValue(7) + "|" + m);

    // Replace: if KEY exists - null-not-found
    System.out.println("replace(NullValue, 77): " + m.replace("NullValue", 77) + "|" + m);

    // Replace: if KEY+VALUE exists - return TRUE/FALSE
    System.out.println("replace(Barry, 1, 10): " + m.replace("Barry", 1, 10) + "|" + m);

    // Remove: if KEY exists - null-not-found
    System.out.println("remove(Ida): " + m.remove("Ida") + "|" + m);

    // Remove: if KEY+VALUE exists - return TRUE/FALSE
    System.out.println("remove(Harold, 3) : " + m.remove("Harold", 3) + "|" + m);

    // Update/put: if VALUE exists - null-not-found
    System.out.println("put(Harold, 100) : " + m.put("Harold", 100) + "|" + m);

    // Insert: if KEY not-exist | Return: a) null: if-inserted; b) VALUE: if-key-found
    System.out.println("putIfAbsent(Maggie, 200) : " + m.putIfAbsent("Maggie", 200) + "|" + m);
  }

  private static void testComputes(Map<String, Integer> m) {

/*╔══════════════════════════════════════════════╗
  ║ Key found + Value-NotNull: Update;           ║
  ║ Key found + Value-Null: NullPointerException ║
  ║ Key not-found: Add                           ║
  ╚══════════════════════════════════════════════╝*/
    m.compute("John", (key, value) -> {
      return (value == null) ? 0 : value * 100;
    });

/*╔═══════════════════════╗
  ║ Key found: Do-Nothing ║
  ║ Key not-found: Add    ║
  ╚═══════════════════════╝*/
    m.computeIfAbsent("Mary", (value) -> {
      return 30 * 3;
    });

/*╔════════════════════════════╗
  ║ Key found: Update          ║
  ║ Key not-found: Return-Null ║
  ╚════════════════════════════╝*/
    m.computeIfPresent("Mary", (key, value) -> {
      return value * 3;
    });

  }

  private static void testMerges(Map<String, Integer> m) {
    System.out.println("\nState: " + m + "\n");

    /*╔═════════════════════════════╗
      ║       KEY: Not-Exist        ║
      ╠═════════════════════════════╣
      ║ Add(KEY+VALUE)/Return Value ║
      ╚═════════════════════════════╝*/
    System.out.println(
         "KEY: Not-Exist -> Add(KEY+VALUE)/Return Value " +
              m.merge("Mary", 100, (key, val) -> {
                return val / 3;    }) +
              "\nState: " + m + "\n"                         );

    /*╔═══════════════════════════════╗
      ║    KEY: Exist + VALUE: Null   ║
      ╠═══════════════════════════════╣
      ║     Update+Return(VALUE)      ║
      ╚═══════════════════════════════╝*/
    m.put("Mary", null);
    System.out.println(
         "KEY: Exist + VALUE: Null -> Update/Return(VALUE) " +
              m.merge("Mary", 100, (key, val) -> {
                return val / 3;      }) +
              "\nState: " + m + "\n"                         );

    /*╔═══════════════════════════════╗
      ║  KEY: Exist + VALUE: Not-Null ║
      ╠═══════════════════════════════╣
      ║     Apply/Return function     ║
      ╚═══════════════════════════════╝*/
    System.out.println(
         "KEY: Exist + VALUE: Not-Null -> Apply/Return function  " +
              m.merge("Mary", 100, (key, val) -> {
                return val / 3;     }) +
              "\nState: " + m + "\n"                               );

    m.replaceAll((key, val) -> {return key.equals("Barry") ? 0 : val + 1;});
    System.out.println("\nState: " + m + "\n");
  }
}