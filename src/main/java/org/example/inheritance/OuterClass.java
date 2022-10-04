package org.example.inheritance;

public class OuterClass {
  
  public class InstanceClass {
  }

  public static class StaticClass {
  }

  public void useClasses() {
    new            InstanceClass();
    this.new       InstanceClass();

    OuterClass.InstanceClass inst = new OuterClass.InstanceClass();
    new OuterClass().new InstanceClass();
    new OuterClass.      InstanceClass();


    new OuterClass.      StaticClass();
    new                  StaticClass();
  }

  public static void main(String[] args) {
    new OuterClass.      StaticClass();
  }

}