package org.example.compare;

import java.util.*;

public class ComparableComparatorClassArray {
  public static void main(String[] args) {
    Product[] products = getArrayProducts();

    System.out.println("Before: " + Arrays.toString(products));
    Arrays.sort(products);

    // COMPARATOR ORDER: NOT use Comparable in entity(Product)
    Arrays.sort(products, new ProductNameComparator());
    System.out.println("After: " + Arrays.toString(products));
  }
  private static Product[] getArrayProducts() {

    Product[] products = {
         new Product("socks", 2.0),
         new Product("tshirt", 1.0),
         new Product("pants", 0.5)};
    return products;
  }

  static class ProductNameComparator implements Comparator<Product> {
  // POSITION: THIS -> OBJECT
  // THIS-CURRENT < OBJECT: -1 -> CURRENT POSITION - MOVE AHEAD
  // THIS-CURRENT > OBJECT: +1 -> CURRENT POSITION - MOVE BACK
  // THIS-CURRENT = OBJECT: NO MOVE
    @Override
    public int compare(Product product1, Product product2) {
      if (product1.price < product2.price) return -1;
      if (product1.price > product2.price) return +1;
      return 0;        }
  }
  //  static class Product {
  //    String name;
  //    double price;
  //
  //    public Product(String name, double price) {
  //
  //      this.name = name;
  //      this.price = price;
  //    }
  //
  //    @Override
  //    public String toString() {
  //
  //      return this.name + " - " + this.price;
  //    }
  //  }
    public static class Product implements Comparable<Product>{
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

    @Override
    public int compareTo(Product product) {
      if(this.price < product.price) return -1;
      if(this.price > product.price) return 1;
      return 0;
    }
  }



}