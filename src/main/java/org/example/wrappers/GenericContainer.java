package org.example.wrappers;

import java.util.ArrayList;
import java.util.List;

public class GenericContainer<T> {

  List<T> wrappedList; // Objects must be typed: T-Superclass OR T

  GenericContainer(List<T> wrappedList) {
    this.wrappedList = wrappedList;
  }

  public Object myGet(int index) {
    return wrappedList.get(index);
  }

  public void myAdd(T o) {
    wrappedList.add(o);
  }


  public String toString() {

    return wrappedList.toString();
  }

  public static void main(String[] args) {

    List<CharSequence> l = new ArrayList<CharSequence>();
    GenericContainer<CharSequence> g = new GenericContainer<>(l);

    g.myAdd("hi");

    Object o = g.myGet(0);
    System.out.println("Element 0 = " + o);

    System.out.println("Wrapped List = " + g);
  }

}