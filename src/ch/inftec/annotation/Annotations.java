package ch.inftec.annotation;

import java.io.FileNotFoundException;

@Custom
public class Annotations implements @Custom MyInterface<@Custom String> {
  @Custom
  private String foo;

  private Annotations(String foo) {
    this.foo = foo;
  }

  @Custom
  public static void test() throws @Custom FileNotFoundException {
    MyInterface myInt = new @Custom Annotations("bar");
    Annotations annotations = (@Custom Annotations) myInt;
    annotations.doit();

    throw new FileNotFoundException(annotations.getFoo());
  }

  private String getFoo() {
    return foo;
  }
}
