package ch.inftec.lambda;

@FunctionalInterface
public interface CheckPerson {
  public boolean test(Person p);

  default boolean test2() {
    return false;
  }
}
