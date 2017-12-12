package ch.inftec.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateTime {
  public static void main(String[] args) {
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);

    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);

    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);

    ZoneId zurich = ZoneId.of("Europe/Zurich");
    ZonedDateTime swissZonedDateTime = ZonedDateTime.now(zurich);
    System.out.println(swissZonedDateTime);

    ZoneId utc = ZoneId.of("UTC");
    ZonedDateTime utcZoneDateTime = ZonedDateTime.now(utc);
    System.out.println(utcZoneDateTime);

    System.out.println(swissZonedDateTime.withZoneSameInstant(utc));

    ZonedDateTime swissSummerTime = ZonedDateTime.of(2017, 10, 29, 2, 30, 0, 0, zurich);
    System.out.println(swissSummerTime);

    ZonedDateTime swissWinterTime = ZonedDateTime.of(2017, 10, 29, 3, 30, 0, 0, zurich);
    System.out.println(swissWinterTime);

    ZonedDateTime inTheGap = swissWinterTime.minusHours(1);
    System.out.println(inTheGap);

    inTheGap = swissWinterTime.minusHours(2);
    System.out.println(inTheGap);

    LocalDate aWhileAgo = LocalDate.of(2017, 8, 25);
    LocalDate aLongTimeAgo = LocalDate.of(1846, 5, 13);
    Period period = Period.between(aLongTimeAgo, aWhileAgo);
    System.out.println(period.getYears());

    Date date = new Date();
    System.out.println(date);
    ZonedDateTime fromDate = ZonedDateTime.ofInstant(date.toInstant(), zurich);
    System.out.println(fromDate);

    ZoneId mumbai = ZoneId.of("Asia/Calcutta");
    ZonedDateTime mumbaiZoneDateTime = ZonedDateTime.now(mumbai);
    System.out.println(mumbaiZoneDateTime);
  }
}
