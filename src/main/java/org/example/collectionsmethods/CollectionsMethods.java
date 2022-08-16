package org.example.collectionsmethods;


import java.util.*;

public class CollectionsMethods {
  // Set up some test data
  static List<String> list = new ArrayList<String>(
       List.of("Anne", "Barry", "Charles", "David", "Edward")
  );

  public static void main(String[] args) {


    //----------------------------------------------------
    list.sort(Comparator.reverseOrder());                     show();
    Collections.swap(list, 0, list.size() - 1);           show();
    for (int i = 0; i < 3; i++) {  Collections.shuffle(list); show();}
    Collections.sort(list);                                   show();
    Collections.reverse(list);                                show();
    System.out.println(Collections.min(list));
    System.out.println(Collections.max(list));
    Collections.fill(list, "Unknown");                     show();

    //------------------------------------------------------------

    // IMMUTABLE-LISTS CREATED FROM COLLECTIONS
    // Similar to List.copyOf(namesList)
    List<String> newList = Collections.unmodifiableList(list);   show2(newList);
    List<String> copiedList = List.copyOf(list);   show2(newList);

    // Singleton{Type} methods return sets of one-element (Immutable).
    // EX: singletonList, singletonMap
    List oneElement = Collections.singletonList(list.get(2));
    Collections.sort(oneElement);//Sort single element|ACTUALLY not sort|no error

  //--------------------------------------------------------------------
  // ArrayList with "singletonList"/"List.of"/"nCopies" RESULTS "mutable"
  List<String> l2 = new ArrayList<>(Collections.singletonList("One"));show2(l2);
  List<String> l3 = new ArrayList<>(Collections.nCopies(4, "xxx"));show2(l3);
  List<String> l1 = new ArrayList<>(List.of("Two", "Three"));
  l2.add("Two");

  //copy L1 replacing L2|Source must be Equals-greater destiny - or exception
  Collections.copy(l2, l1);

  l2.add("Five");      show2(l2);

}

  private static void show2(List<String> newList) {

    System.out.println(newList);
  }

  private static void show() {

    show2(list);
  }
}