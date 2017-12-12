package ch.inftec.defmet;

public class SportsCar extends Car implements FastDriveable, BetterDriveable {
  @Override
  public void drive() {
    BetterDriveable.super.drive();
    FastDriveable.super.drive();
    FastDriveable.super.driveFast();
    super.drive();

    Driveable.crash();
  }
}
