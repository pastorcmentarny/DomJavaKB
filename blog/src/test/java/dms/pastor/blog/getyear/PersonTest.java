package dms.pastor.blog.getyear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 18/08/2016
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PersonTest {
    private Person person;
    private static final String name = "Dominik";

    @BeforeEach
    public void setup() {
        person = new Person(name, now().minusYears(18).minusMonths(1).minusDays(1));
    }

    @Test
    public void shouldReturn18YearsTest() {
        //When
        final int age = person.getAge();

        //Then
        assertThat(person.getName()).isEqualTo(person.getName());
        assertThat(age).isEqualTo(18);
    }

    @Test
    public void shouldReturn217MonthsTest() {
        //When
        final int age = person.getAgeInMonths();

        //Then
        assertThat(age).isEqualTo(217);
    }

    @Test
    public void shouldReturn28DaysTest() {
        //Given
        Person toddler = new Person("Toddler", now().minusDays(28));

        //When
        final int age = toddler.getAgeInDays();

        //Then
        assertThat(age).isEqualTo(28);
    }
}