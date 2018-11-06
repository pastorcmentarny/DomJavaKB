package dms.pastor.blog.getyear;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.toIntExact;
import static java.time.LocalDate.now;

/**
 * Author Dominik Symonowicz
 * Created 18/08/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Person {
    private final String name;
    private final LocalDate birthday;

    Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return toIntExact(ChronoUnit.YEARS.between(birthday, now()));
    }

    int getAgeInMonths() {
        return toIntExact(ChronoUnit.MONTHS.between(birthday, now()));
    }

    int getAgeInDays() {
        return toIntExact(ChronoUnit.DAYS.between(birthday, now()));
    }
}
