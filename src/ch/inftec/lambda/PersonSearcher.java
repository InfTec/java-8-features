package ch.inftec.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static ch.inftec.lambda.Person.Sex.FEMALE;
import static ch.inftec.lambda.Person.Sex.MALE;

public class PersonSearcher {
  public static void main(String[] args) {
    List<Person> roster = initialize();
    System.out.println("Person older than 30:");
    printPersonOlderThan(roster, 30);

    System.out.println("\nPerson between 15 and 20");
    printPersonWithinAgeRange(roster, 15, 20);

    System.out.println("\nPerson has to go to military:");
    printPersons(roster, p -> p.getGender() == MALE && 18 <= p.getAge() && p.getAge() <= 30);

    System.out.println("\nPerson has to pay AHV:");
    printPersonWithPredicate(roster, p -> 18 <= p.getAge() && p.getAge() <= 65);

    System.out.println("\nPerson may not drive a car yet:");
    processPerson(roster, p -> p.getAge() < 18, p -> System.out.println(p));

    System.out.println("\nPrint email address if available:");
    Predicate<Person> personPredicate = p -> p.getEmailAddress() != null;
    processPersonWithFunction(roster, personPredicate, p -> p.getEmailAddress(), foobar -> System.out.println(foobar));

    System.out.println("\nPrint email address with generics if available:");
    genericProcessPersonWithFunction(roster, personPredicate, p -> p.getEmailAddress(), email -> System.out.println(email));

    System.out.println("\nPrint email address with streams:");
    roster
            .stream()
            .filter(personPredicate)
            .map(Person::getEmailAddress)
            .forEach(System.out::println);
  }

  private static void printPersonOlderThan(List<Person> roster, int age) {
    for (Person person : roster) {
      if (person.getAge() >= age) {
        System.out.println(person);
      }
    }
  }

  private static void printPersonWithinAgeRange(List<Person> roster, int low, int high) {
    for (Person person : roster) {
      if (low <= person.getAge() && high >= person.getAge()) {
        System.out.println(person);
      }
    }
  }

  private static void printPersons(List<Person> roster, CheckPerson tester) {
    for (Person person : roster) {
      if (tester.test(person)) {
        System.out.println(person);
      }
    }
  }

  private static void printPersonWithPredicate(List<Person> roster, Predicate<Person> tester) {
    for (Person person : roster) {
      if (tester.test(person)) {
        System.out.println(person);
      }
    }
  }

  private static void processPerson(List<Person> roster, Predicate<Person> tester, Consumer<Person> consumer) {
    for (Person person : roster) {
      if (tester.test(person)) {
        consumer.accept(person);
      }
    }
  }

  private static void processPersonWithFunction(
          List<Person> roster,
          Predicate<Person> tester,
          Function<Person, String> mapper,
          Consumer<String> consumer
  ) {
    for (Person person : roster) {
      if(tester.test(person)) {
        String data = mapper.apply(person);
        consumer.accept(data);
      }
    }
  }

  private static <X, Y> void genericProcessPersonWithFunction(
          List<X> roster,
          Predicate<X> tester,
          Function<X, Y> mapper,
          Consumer<Y> consumer
  ) {
    for (X x : roster) {
      if(tester.test(x)) {
        Y y = mapper.apply(x);
        consumer.accept(y);
      }
    }
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
    roster.add(new Person("Mollie Hutchinson", LocalDate.parse("1922-08-26"), FEMALE, null));
    roster.add(new Person("Madeson Barton", LocalDate.parse("2004-12-01"), FEMALE, "madeson.barton@nonsapien.edu"));
    roster.add(new Person("Dominic Lane", LocalDate.parse("2014-03-01"), MALE, "dominic.lane@luctusipsumleo.net"));

    return roster;
  }
}
