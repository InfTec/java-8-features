package ch.inftec.typeinference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeInference {
  public static void foo() {
    List<String> list = new ArrayList<>();
    list.add("A");
    list.addAll(Arrays.asList("a", "b"));
  }
}
