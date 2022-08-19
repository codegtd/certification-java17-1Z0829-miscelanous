package org.example.genericwrappers;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
  /*╔═════════════════════════════════════════╗
    ║      UpperBound Wildcard - EXAMPLE      ║
    ╠═════════════════════════════════════════╣
    ║ "CharSequence" has "String" as SubClass ║
    ╚═════════════════════════════════════════╝*/
public class UpperBoundWildCardList_Solution<T> {       // 1) T: CharSequence

  List<T> myList;            // 2) NO-Upper-Bound

                             // 3) Instaciation: list is a "CharSequence"(T)
  UpperBoundWildCardList_Solution(List<T> list) {
    this.myList = list;
  }

  public T myGet(int index) {// 4) ACCEPTABLE:
    return myList.get(index);// 4.1) Return List-String-Item(son) from Instance-field
                             // 4.2) Using CharSequence-Type(Father)
  }

  public void myAdd(T item) {// 5) PROBLEM - incompatible:
    myList.add(item);        // 5.1) In "instance-variable myList(String)"
  }                          // 5.2) you are adding a "T-item(CharSequence)"

  public static void main(String[] args) {
    List<CharSequence> l = new ArrayList<>();
    UpperBoundWildCardList_Solution<CharSequence> g = new UpperBoundWildCardList_Solution<>(l);

    g.myAdd("hi");
//    g.myAdd(10);

    CharSequence o = g.myGet(0);

    System.out.println("[0]: " + o);

    System.out.println("List: " + g);
  }
}