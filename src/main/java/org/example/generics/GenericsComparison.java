package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsComparison {
  public static void main(String[] args) {

    GenericsClass<Number> a1 = new GenericsClass<>(Double.valueOf("10"));
    GenericsClass<ArrayList<String>> a2 = new GenericsClass<>(new ArrayList(List.of("A", "B", "C")));

    NonGenericClass b1 = new NonGenericClass(Double.valueOf("10"));

    NonGenericClass b2 = new <ArrayList<String>>NonGenericClass(new ArrayList(List.of("A", "B", "C")));

    NonGenericClass.<Exception>genericStaticMethod(new RuntimeException("Just Testing"));

    b1.genericInstanceMethod("Hello");
  }
}