package org.example;

class GenericsClass<T> {

  T aGenericField;

  GenericsClass(T aGenericField) {

    this.aGenericField = aGenericField;
    System.out.println("GenericsClass constructor: " +
                            aGenericField.getClass()
                                         .getName());
  }

  public T aGenericClassMethod() {

    return this.aGenericField;
  }
}

class NonGenericClass {

  <T> NonGenericClass(T aGenericParameter) {

    System.out.println("NonGenericClass: generic constructor: " +
                            aGenericParameter.getClass()
                                             .getName());
  }

  public static <T> void genericStaticMethod(T aGenericParameter) {

    System.out.println("NonGenericClass: static generic method: " +
                            aGenericParameter.getClass()
                                             .getName());
  }

  public <T> void genericInstanceMethod(T aGenericParameter) {

    System.out.println("NonGenericClass: instance generic method: " +
                            aGenericParameter.getClass()
                                             .getName());
  }
}