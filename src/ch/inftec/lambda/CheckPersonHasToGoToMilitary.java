package ch.inftec.lambda;

public class CheckPersonHasToGoToMilitary implements CheckPerson {
  @Override
  public boolean test(Person p) {
    return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 30;
  }
}
