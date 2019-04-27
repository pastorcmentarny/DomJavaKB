package dms.pastor.examples.java8.datetime;

import dms.pastor.ExampleRunner;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static dms.pastor.examples.java8.datetime.MutableDate.*;
import static org.junit.Assert.*;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MutableDateTest implements ExampleRunner {

    @Override
    public void runExamples()   {
        MutableDate oldDate = new MutableDate();
        //oldDate.mutabilityMadnessExample();

        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(UK));
        System.out.println(dateTime);
        ZonedDateTime wroclawZonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(POLAND));
        System.out.println(wroclawZonedDateTime);
        ZonedDateTime tianjinZonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(CHINA));
        System.out.println(tianjinZonedDateTime);

        System.out.println("=== - ==");
        oldDate.calendarMisconceptions();
    }
}