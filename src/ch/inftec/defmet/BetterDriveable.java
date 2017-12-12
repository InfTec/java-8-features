package ch.inftec.defmet;

public interface BetterDriveable extends Driveable {
  @Override
  default void drive() {
    System.out.println("better driveable");
  }
}
