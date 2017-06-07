package dms.pastor.tasks.exercises.string.characterfinder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FinderTest {

    @Test
    public void shouldFindIn10AttemptsTest() throws Exception {
        // given
        Finder finder = new Finder();

        // when
        final int counter = finder.find();

        // verify
        assertThat(counter).isGreaterThan(0);
        System.out.println("It took " + counter + " attempts to find a and z.");
    }

}