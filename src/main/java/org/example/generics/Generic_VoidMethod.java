package org.example.generics;

public class Generic_VoidMethod {

  <T extends Number> void genericVoidMethodNumber(T number) {

    System.out.println(
         "\n Showing my Number: " + number.getClass()
                                          .toGenericString() + " - " + number);
  }

  <T> void genericVoidMethodShowElement(T element) {

    System.out.println(
         "\n Showing my Element: " + element.getClass()
                                            .toGenericString() + " - " +  element);
  }

  <T> void genericVoidMethodForArrays(T[] array) {

    for (int i = 0; i < array.length; i++) {
      System.out.println
                     ("\n Array Item: " +
                           array[i].getClass()
                                   .toGenericString() + " - " +  array[i]);
    }
    System.out.println("\n");
  }

  public static void main(String args[]) {

    Generic_VoidMethod genMet = new Generic_VoidMethod();

    Integer integerArray[] = {45, 26, 89};
    genMet.genericVoidMethodForArrays(integerArray);

    String stringArray[] = {"Krishna", "Raju", "Seema"};
    genMet.genericVoidMethodForArrays(stringArray);

    Integer myInteger = 45;
    genMet.genericVoidMethodShowElement(myInteger);

    String myWord = "myWord";
    genMet.genericVoidMethodShowElement(myWord);

    Double myDob = 45.0;
    genMet.genericVoidMethodNumber(myDob);

    long myLong = 45L;
    genMet.genericVoidMethodNumber(myLong);
  }
}