package ch.inftec.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Streams {
  public static void main(String[] args) {
    List<Integer> list = getList(100);

    list.stream().forEach(System.out::println);

    Optional<Integer> optionalSum = list.stream().reduce(Integer::sum);
    if(optionalSum.isPresent()) {
      Integer integer = optionalSum.get();
      System.out.println("\nsum: " + integer);
    }

//    list.stream().filter(i -> i > 90).forEach(System.out::println);
    list.parallelStream().filter(i -> i > 90).forEach(System.out::println);
    list.stream().filter(i -> i > 90).parallel().filter(i -> i % 2 == 0).parallel().forEach(System.out::println);

    long count = list.stream().count();
    System.out.println("size of list: " + count);
  }

  private static List<Integer> getList(int size) {
    List<Integer> myList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      myList.add(i);
    }
    return myList;
  }
}
