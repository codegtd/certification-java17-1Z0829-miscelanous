package org.example.generics;

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

  public static <T> T aGenericClassStaticMethod(T t) {
    System.out.println("Now this is a generic method");
    return t;
  }
}

class NonGenericClass {
  <Z> NonGenericClass(Z parameter) {
    System.out.println("Gen-constructor: " + parameter.getClass().getName());
  }

  public static <U> void genericStaticMethod(U parameter) {
    System.out.println("Static gen-method: " + parameter.getClass().getName());
  }

  public <T> void genericInstanceMethod(T parameter) {
    System.out.println("Instance gen-method: " + parameter.getClass().getName());
  }
}