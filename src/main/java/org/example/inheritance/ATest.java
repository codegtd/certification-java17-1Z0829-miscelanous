package org.example.inheritance;

public class ATest {
  public ATest(){}
  public ATest(String name) {
    System.out.println(" I am the super" + name);
  }
}

class BTest extends ATest {
  public BTest(String name) {
//    super(name);
    System.out.println(" I am the super" + name);
  }
}