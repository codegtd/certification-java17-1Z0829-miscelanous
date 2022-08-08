package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenericsComparison {
    public static void main(String[] args) {

        // Create instances of generic class using type arguments
        GenericsClass<Number> a1 =
                new GenericsClass<>(Double.valueOf("10"));
        GenericsClass<ArrayList<String>> a2 =
                new GenericsClass<>(new ArrayList(List.of("A", "B", "C")));

        // Create instances of non-generic class with a generic
        // constructor same as any other non-generic - compiler uses type
        // inference
        NonGenericClass b1 = new NonGenericClass(Double.valueOf("10"));

        //  Alternately, you can specify the type for clarity if desired
        NonGenericClass b2 = new <ArrayList<String>>NonGenericClass(
                new ArrayList(List.of("A", "B", "C")));

        // Invoking static generic method specifying type (optional)
        NonGenericClass.<Exception>genericStaticMethod(
                new RuntimeException("Just Testing"));

        // Invoking instance generic method
        b1.genericInstanceMethod("Hello");    
    }
}