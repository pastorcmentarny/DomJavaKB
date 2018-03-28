package dms.pastor.tasks.manipulatedataapplication.data;

import org.junit.Test;

import static dms.pastor.tasks.manipulatedataapplication.data.Genre.FEMALE;
import static dms.pastor.tasks.manipulatedataapplication.data.Genre.MALE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 06/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class GenreTest {

    @Test
    public void fromStringShouldReturnFemaleFromFemaleString() {
        // when
        final Genre result = Genre.fromString("FEMALE");

        // then
        assertThat(result).isEqualTo(FEMALE);
    }

    @Test
    public void fromStringShouldReturnMaleFromMaleString() {
        // when
        final Genre result = Genre.fromString("MALE");

        // then
        assertThat(result).isEqualTo(MALE);
    }
}