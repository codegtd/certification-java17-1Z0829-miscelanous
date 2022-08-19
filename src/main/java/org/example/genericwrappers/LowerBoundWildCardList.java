package org.example.genericwrappers;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
  /*╔═════════════════════════════════════════════════════════╗
    ║              LowerBound Wildcard - EXAMPLE              ║
    ╠═════════════════════════════════════════════════════════╣
    ║"String"/"StringBuilder" has "CharSequence" as SuperClass║
    ╚═════════════════════════════════════════════════════════╝*/
public class LowerBoundWildCardList<T> {       // 1) T: String
  List<? super T> myList;    // 2) Lower-Bound: T OR T-Superclasses

                             // 3)   Instatiation:
  LowerBoundWildCardList(List<? super T> list) {//3.1) list is a "CharSequence"(T-Superclass)
    this.myList = list;      }//3.2) HOWEVER, Loaded with StringBuilders-items

  public T myGet(int i) { //4) PROBLEM:
                          //4.1) Return List-CharSequence-Item(StringBuilder) from Inst-field
//   return myList.get(i);  //4.2) ERROR: Return Object(super-class), but T is necessary
return (T)myList.get(i);//4.3) FakeSolution: Casting Item with the T(String)
  }                       //4.4) RunTime-Error: "String" IS-NOT-A "StringBuilder"|Cast-Error

  public void myAdd(T item) {// 5) ACCEPTABLE:
    myList.add(item);        // 5.1) In "instance-variable myList(CharSequence|Father)"
  }                          // 5.2) you are adding a "T-item(String|Son)"

  public static void main(String[] args) {
    List<CharSequence> l = new ArrayList<>(List.of(new StringBuilder("bye")));
    LowerBoundWildCardList<String> g = new LowerBoundWildCardList<>(l);

    g.myAdd("hi");

    String o = g.myGet(0);
    System.out.println("[0]: " + o);
    System.out.println("List: " + g);
  }
}