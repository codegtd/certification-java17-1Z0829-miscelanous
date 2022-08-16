package org.example.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAnonymousArray {
  public static void main(String[] args) {

    Product[] products = {
         new Product("socks", 2.0),
         new Product("tshirt", 1.0),
         new Product("pants", 0.5)};

    System.out.println("Before: " + Arrays.toString(products));
    
    //POSITION: THIS -> OBJECT
    // THIS-CURRENT < OBJECT: -1 -> CURRENT POSITION - MOVE AHEAD
    // THIS-CURRENT > OBJECT: +1 -> CURRENT POSITION - MOVE BACK
    // THIS-CURRENT = OBJECT: NO MOVE
    Arrays.sort(products, new Comparator<Product>() {
      @Override
      public int compare(Product product1, Product product2) {

        if (product1.price < product2.price) return - 1;
        if (product1.price > product2.price) return + 1;
        return 0;
      }
    });
    System.out.println("After: " + Arrays.toString(products));
  }

  static class Product {
    String name;
    double price;

    public Product(String name, double price) {

      this.name = name;
      this.price = price;
    }

    @Override
    public String toString() {

      return this.name + " - " + this.price;
    }
  }
}