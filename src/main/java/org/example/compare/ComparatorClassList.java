package org.example.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorClassList {

  public static void main(String[] args) {
    List<Product> products = getProducts();
    System.out.println(products);

    Collections.sort(products,new NameComparator());
    System.out.println("Ordered: " + products);
  }

  private static List<Product> getProducts() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("socks", 2.0));
    products.add(new Product("tshirt", 1.0));
    products.add(new Product("pants", 0.5));

    return products;
  }

  public static class Product {
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

  //POSITION: THIS -> OBJECT
  // THIS-CURRENT < OBJECT: -1 -> CURRENT POSITION - MOVE AHEAD
  // THIS-CURRENT > OBJECT: +1 -> CURRENT POSITION - MOVE BACK
  // THIS-CURRENT = OBJECT: NO MOVE
  static class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
      if(product1.price < product2.price) return -1;
      if(product1.price > product2.price) return +1;
      return 0;    }
  }
}