package ch.inftec.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ch.inftec.lambda.Person.Sex.FEMALE;
import static ch.inftec.lambda.Person.Sex.MALE;

public class PersonSearcher {
  public static void main(String[] args) {
    List<Person> roster = initialize();
  }

  private static List<Person> initialize() {
    List<Person> roster = new ArrayList<>();

    roster.add(new Person("Tana Schmidt", LocalDate.parse("2001-05-14"), FEMALE, "tana.schmidt@cursuspurus.co.uk"));
    roster.add(new Person("Burke Gray", LocalDate.parse("1998-04-30"), MALE, "burke.gray@non.com"));
    roster.add(new Person("Inez Logan", LocalDate.parse("1997-02-13"), FEMALE, "tana.schmidt@at.edu"));
    roster.add(new Person("Cadman Griffin", LocalDate.parse("1971-05-28"), MALE, "cadman.griffin@nuncmaurissapien.org"));
    roster.add(new Person("Tanner Howard", LocalDate.parse("1979-09-23"), MALE, "tanner.howard@mattis.com"));
    roster.add(new Person("Jeanette Davidson", LocalDate.parse("1961-04-04"), FEMALE, "jeanette.davidson@esttemporbibendum.edu"));
    roster.add(new Person("Iola Lynn", LocalDate.parse("2008-08-28"), FEMALE, "iola.lynn@fusce.edu"));
    roster.add(new Person("Mollie Hutchinson", LocalDate.parse("1949-08-26"), FEMALE, null));
    roster.add(new Person("Madeson Barton", LocalDate.parse("2004-12-01"), FEMALE, "madeson.barton@nonsapien.edu"));
    roster.add(new Person("Dominic Lane", LocalDate.parse("2014-03-01"), MALE, "dominic.lane@luctusipsumleo.net"));

    return roster;
  }
}
