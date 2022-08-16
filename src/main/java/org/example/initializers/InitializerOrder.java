package org.example.initializers;

class OrderedClass {
    static int statementOrder;

    int b = clarify("assigning b");

    {
        clarify("initializer 2");
    }
    int a = clarify("assigning a");

    {
        clarify("initializer 1");
    }

    OrderedClass() {
        clarify("constructor");
    }

    int c = clarify("assigning c");

    {
        clarify("initializer 3");
    }

    int clarify(String message) {
        statementOrder++;
        System.out.println(statementOrder + " " + message);
        return statementOrder;
    }
}

public class InitializerOrder {
    public static void main(String[] args) {
        // Instantiating the object should set off initialization code.
        OrderedClass o = new OrderedClass();
    }
}