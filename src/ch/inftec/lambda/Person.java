package ch.inftec.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Person {
  private String name;
  private LocalDate birthday;
  private Sex gender;
  private String emailAddress;

  public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.emailAddress = emailAddress;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public int getAge() {
    LocalDate now = LocalDate.now();
    return Period.between(birthday, now).getYears();
  }

  public Sex getGender() {
    return gender;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public String toString() {
    return String.join(", ", name, gender.toString().toLowerCase(), Integer.toString(getAge()));
  }

  public enum Sex {
    MALE, FEMALE
  }
}
