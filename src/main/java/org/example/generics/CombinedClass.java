package org.example.generics;

import java.util.List;

class CombinedClass<T extends Comparable, U> {
    U instanceField;
    Number instanceNumberField;

    // Generic method's type is upper bound to Number
    <V extends Number> CombinedClass(U instanceField, V instanceNumber) {
        this.instanceField = instanceField;
        this.instanceNumberField = instanceNumber;
        System.out.println("CombinedClass: instanceField (" +
                instanceField.getClass().getName() + ") : " + instanceField);
        System.out.println("CombinedClass: instanceNumber (" +
                instanceNumber.getClass().getName() + ") : " + instanceNumber);
    }

    // Method 02 type parameters:
    //  * X no restriction(upperbound) - return type method
    //  * W List made up of 'X' items
    // Arguments (t, s, w):
    //  * t + s are T(Class Generic Type)
    //  * w is a List<W>.
    public <X, W extends List<X>> X getComparisonResult(T t, T s, W w) {
        int result = s.compareTo(t);
        if (result != 0) result = result < 0 ? -1 : 1;
        result++;
        return w.get(result);
    }
}