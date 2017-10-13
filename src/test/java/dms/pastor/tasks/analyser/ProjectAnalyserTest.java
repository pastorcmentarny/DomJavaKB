package dms.pastor.tasks.analyser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.io.File.separator;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ProjectAnalyserTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsNull() throws Exception {
        // Expect
        exception.expect(IllegalArgumentException.class);

        // when
        new ProjectAnalyser().analyse(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsEmpty() throws Exception {
        // Expect
        exception.expect(IllegalArgumentException.class);

        // when
        new ProjectAnalyser().analyse("");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsInvalid() throws Exception {
        // Expect
        exception.expect(IllegalArgumentException.class);

        // when
        new ProjectAnalyser().analyse(generateString(10));
    }

    @SuppressWarnings("AccessOfSystemProperties")
    @Test
    public void shouldGetResults() throws Exception {

        // when
        String path = System.getProperty("user.dir") +
                separator + "src" + separator + "main" + separator;
        final ProjectAnalyser projectAnalyser = new ProjectAnalyser();
        projectAnalyser.analyse(path);

        // then
        assertThat(projectAnalyser.getNumberOfFiles()).isGreaterThan(75);
        assertThat(projectAnalyser.getLinesOfCode()).isGreaterThan(4000);
        assertThat(projectAnalyser.getCharacterNumbers()).isGreaterThan(100_000);
        assertThat(projectAnalyser.getWidestLine()).isGreaterThan(200);
        assertThat(projectAnalyser.getHighestLineCount()).isGreaterThan(200);
    }

}