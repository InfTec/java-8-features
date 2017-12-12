package ch.inftec.streams;

import java.util.ArrayList;
import java.util.List;

public class Streams {
  public static void main(String[] args) {
    List<Integer> list = getList(100);
  }

  private static List<Integer> getList(int size) {
    List<Integer> myList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      myList.add(i);
    }
    return myList;
  }
}
