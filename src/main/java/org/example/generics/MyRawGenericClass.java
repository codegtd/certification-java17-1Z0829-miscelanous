package org.example.generics;

public class MyRawGenericClass<T> {

  public <T> String transform(T t) {
    return t.toString() + "-" + t.hashCode();
  }

  public static void main(String[] args) {

    MyRawGenericClass gc = new MyRawGenericClass();
    System.out.println(gc.transform(1));
    System.out.println(gc.transform("hello"));


    MyRawGenericClass<String> gcStr = new MyRawGenericClass<String>();
    System.out.println(gcStr.transform(1.1));
  }
}