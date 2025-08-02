package dms.pastor.blog.getyear;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.toIntExact;
import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.*;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 18/08/2016
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
        return toIntExact(YEARS.between(birthday, now()));
    }

    int getAgeInMonths() {
        return toIntExact(MONTHS.between(birthday, now()));
    }

    int getAgeInDays() {
        return toIntExact(DAYS.between(birthday, now()));
    }
}
