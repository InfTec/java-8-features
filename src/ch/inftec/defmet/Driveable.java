package ch.inftec.defmet;

public interface Driveable {
  default void drive() {
    System.out.println("drive");
  }

  static void crash() {
    System.out.println("crash");
  }
}
