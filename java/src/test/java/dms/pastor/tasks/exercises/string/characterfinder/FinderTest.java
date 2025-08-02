package dms.pastor.tasks.exercises.string.characterfinder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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