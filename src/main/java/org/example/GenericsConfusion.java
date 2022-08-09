package org.example;

public class GenericsConfusion {
  public static void main(String[] args) {
    Container<String> n1 = new Container<String>("Hello");
    Container<String> n2 = new Container<String>(3);
    Container<String> n3 = new <Integer>Container<String>(3);
    Container<String> n22 = new Container<>(3);
    Container<String> n33 = new <Integer>Container<String>(3);
  }  }

class Container<T> {
  T myField;

  Container(T myField) {
    System.out.println("In T constructor");
    this.myField = myField;   }

//  <T> Container(T myField) {
//  <T extends Number> Container(T myField) {
  <V extends Number> Container(V myField) {
    System.out.println("In T2 constructor");
    //this.myField != myField -> not allowed
    //this.myField = myField; //this.myField != myField -> not allowed
  }  }