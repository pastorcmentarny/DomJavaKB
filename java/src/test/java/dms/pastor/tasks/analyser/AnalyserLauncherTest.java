package dms.pastor.tasks.analyser;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.analyser.AnalyserLauncher.THIS_PROJECT_PATH;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AnalyserLauncherTest {



    @Test
    public void shouldReturnThisProjectPathWhenArgumentIsNullTest() {
        // when
        final String path = AnalyserLauncher.getPath(null);

        // then
        assertThat(THIS_PROJECT_PATH).isEqualTo(path);
    }

    @SuppressWarnings("ZeroLengthArrayAllocation")
    @Test
    public void shouldReturnThisProjectPathWhenArgumentArrayIsEmptyArrayTest() {
        // when
        final String path = AnalyserLauncher.getPath(new String[0]);

        // then
        assertThat(THIS_PROJECT_PATH).isEqualTo(path);
    }

    @Test
    public void shouldReturnThisProjectPathWhenArgumentIsEmptyTest() {
        // when
        final String path = AnalyserLauncher.getPath(new String[]{EMPTY_STRING});

        // then
        assertThat(path).isEmpty();
    }

    @Test
    public void shouldReturnPathTest() {
        // when
        final String randomPath = RandomDataGenerator.generateString();
        final String path = AnalyserLauncher.getPath(new String[]{randomPath});

        // then
        assertThat(randomPath).isEqualTo(path);
    }

    @Test
    public void shouldAnalyseFile() {
        // when
        AnalyserLauncher.main(new String[]{THIS_PROJECT_PATH});

    }

}