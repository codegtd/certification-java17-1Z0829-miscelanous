package org.example;

import java.util.List;

class MyWildcardTests<T> {
  private int val;

  public MyWildcardTests() {

  }

  public MyWildcardTests(int val) {

    this.val = val;
  }

  public static <U> void doSomething(U u) {

    System.out.println(u);
  }
}

public class WildcardUsage {
  List<?> instanceList;

  List<MyWildcardTests<?>> tests;

  static List<?> staticList;

  private void setList(List<?> list) {    instanceList = list;    }

  private static List<?> getList(List<?> list) {    return list;    }

  public static void main(String[] args) {
    List<?> unboundedList = List.of(1, 1.2f, true, 50, false, "Yes", new Exception());

    WildcardUsage swu = new WildcardUsage();
    List<MyWildcardTests> wildList = List.of(new MyWildcardTests(1), new MyWildcardTests(2));
    swu.setList(wildList);
    staticList = getList(wildList);
    System.out.println(staticList);
    System.out.println(swu.instanceList);
    System.out.println(unboundedList);
  }
}