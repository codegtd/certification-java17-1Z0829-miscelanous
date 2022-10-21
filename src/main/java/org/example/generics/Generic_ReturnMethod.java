package org.example.generics;

public class Generic_ReturnMethod {

  <T> T genericReturnMethodShowElement(T element) {

    return element;

  }

  <T extends Number> T genericReturnMethodNumber(T number) {

    System.out.println("\n Showing my Number: " + number.getClass()
                                                        .toGenericString() + " - " + number);

    return number;
  }


  public static void main(String args[]) {

    Generic_ReturnMethod genMet = new Generic_ReturnMethod();

    String myWord = "myWord";
    final String s = genMet.genericReturnMethodShowElement(myWord);
    System.out.println(s+ s.getClass()
                                   .toGenericString());

    int myInt = 5;
    final int sInt = genMet.genericReturnMethodShowElement(myInt);
    System.out.println(sInt);

    int myWrapperInt = 55;
    final Integer myWrapper = genMet.genericReturnMethodShowElement(myWrapperInt);
    System.out.println(
         myWrapper + myWrapper.getClass()
                              .toGenericString());

    Double myDob = 45.0;
    genMet.genericReturnMethodNumber(myDob);

    long myLong = 45L;
    genMet.genericReturnMethodNumber(myLong);
  }
}