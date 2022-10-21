package org.example;

class FatherClass {
  public int h = 4;

  public int getH() {

    System.out.println("FatherClass-Method " + h);
    return h;
  }
}

public class ChildClass extends FatherClass {
  public int h = 44;

  public int getH() {

    System.out.println("ChildClass-Method " + h);
    return h;
  }

  public static void main(String[] args) {

    FatherClass father = new ChildClass();
    System.out.println(
         "Field: " + father.h +
              "\n-> Not Casted/Using FatherClass <-\nMethod: " +
              father.getH() + "\n");

    ChildClass castedChildFromParent = (ChildClass) father;
    System.out.println(
         "Field: " +
              castedChildFromParent.h +
              "\n-> Casted/Using ChildClass <-\nMethod: " + castedChildFromParent.getH());

    Object obj =  new Object(), ob2 =  new String();
    Object obj1 = new Object(), ob22 = new FatherClass();
    FatherClass obj3 = new FatherClass(), ob222 = new ChildClass();

  }
}