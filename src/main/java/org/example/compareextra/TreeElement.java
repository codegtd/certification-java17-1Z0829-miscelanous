package org.example.compareextra;

import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter  @ToString
class TreeElement implements Comparable<TreeElement>, Comparator<TreeElement> {
  private int id;
  private String value;

  public TreeElement(int id, String value) {

    this.id = id;
    this.value = value;
  }

  @Override
  public int compareTo(TreeElement o) {
    // "Natural Order" = sorted by id ascending
    return this.id - o.id;
  }

  @Override
  public int compare(TreeElement o1, TreeElement o2) {
    // Order by value - descending, assume for now value is not null
    return o2.value.compareToIgnoreCase(o1.value);
  }
}

class TreeExamples {
  public static void main(String[] args) {
    List<TreeElement> list = List.of(
         new TreeElement(2, "Sam"),
         new TreeElement(5, "Carol"),
         new TreeElement(1, "Mary"),
         new TreeElement(10, "Tim"));

//    TreeSet<TreeElement> treeSet = new TreeSet<>(list);

    TreeSet<TreeElement> treeSet = new TreeSet<>(
         Comparator.comparing(TreeElement::getId).reversed() );
    treeSet.addAll(list);

    treeSet.forEach(x -> show(String.valueOf(x)));// LIST
    show(treeSet.lower(list.get(0)).toString());  // Lower
  }

  private static void show(String text) {

    System.out.println(text);
  }
}