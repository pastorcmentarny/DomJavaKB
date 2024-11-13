package dms.pastor.tasks.exercises.string.characterfinder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FinderTest {

    @Test
    public void shouldFindIn10AttemptsTest() {
        // given
        Finder finder = new Finder();

        // when
        final int counter = finder.find();

        // verify
        assertThat(counter).isGreaterThan(0);
        System.out.println("It took " + counter + " attempts to find a and z.");
    }

}