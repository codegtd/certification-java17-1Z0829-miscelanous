package org.example;

import java.util.*;

public class CollectionTests {
  public static <T> void useCollect(Collection<T> h, T value1, T value2, String david) {
    System.out.println("Add: "    + value1   + h.add(value1));
    System.out.println("Remove: " + value2 + h.remove(value2));            }

  private static void bulkFunctions(Collection<Integer> h) {
    System.out.println("AddAll: "     + h.addAll     (List.of(5, 10, 15)));
    System.out.println("containAll: " + h.containsAll(List.of(10, 20, 90)));
    System.out.println("removeAll: "  + h.removeAll  (List.of(20, 30)));
    System.out.println("retainAll: "  + h.retainAll  (List.of(10, 20, 30))); } }

class SetExample {
  public static void main(String[] args) {
    List<Integer> data = List.of(10, 20, 50, 40, 30);

    Set<Integer> h = new HashSet<>(data);
    Set<Integer> t = new TreeSet<>(data);
    Set<Integer> l = new LinkedHashSet<>(data);   }   }