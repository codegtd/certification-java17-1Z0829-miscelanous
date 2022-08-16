package org.example.compare;

import java.util.Set;
import java.util.TreeSet;

class SmartDog implements Comparable<SmartDog> {

  private DogType dogType;

  public SmartDog(DogType t) {

    this.dogType = t;
  }

  public int compareTo(SmartDog o) {

    System.out.println(
         this +
              " Compare " + o +
              " = " +
              (this.dogType.smartLevel - o.dogType.smartLevel));

    return this.dogType.smartLevel - o.dogType.smartLevel;
  }

  public String toString() {

    return this.dogType.toString();
  }

  public enum DogType {
    POODLE(1),
    DOODLE(2),
    COLLIE(3),
    LABRADOR(4),
    PUG(5);

    // default dogs to dumbest level
    int smartLevel = 6;

    DogType(int smartLevel) {

      this.smartLevel = smartLevel;
    }

  }

}

class ComparableExample {
  public static void main(String[] args) {

    System.out.println("-----TreeSet start constructing -------");
    Set<SmartDog> dogs = new TreeSet<>(
         Set.of(
              new SmartDog(SmartDog.DogType.COLLIE),
              new SmartDog(SmartDog.DogType.DOODLE),
              new SmartDog(SmartDog.DogType.PUG),
              new SmartDog(SmartDog.DogType.POODLE),
              new SmartDog(SmartDog.DogType.LABRADOR)
         )
    );

    System.out.println("-----TreeSet constructed-------");
    System.out.println("Sorted Dogs " + dogs);
  }
}