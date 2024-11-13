package dms.pastor.tasks.analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.io.File.separator;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ProjectAnalyserTest {


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ProjectAnalyser().analyse(null));

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ProjectAnalyser().analyse(EMPTY_STRING));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ProjectAnalyser().analyse(generateString(10)));
    }

    @SuppressWarnings("AccessOfSystemProperties")
    @Test
    public void shouldGetResults() {
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