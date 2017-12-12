package ch.inftec.defmet;

public interface FastDriveable extends Driveable {
  default void driveFast() {
    System.out.println("drive fast");
  }

  @Override
  default void drive() {
    driveFast();
  }
}
