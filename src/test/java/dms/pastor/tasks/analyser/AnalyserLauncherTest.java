package dms.pastor.tasks.analyser;

import dms.pastor.utils.RandomDataGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tasks.analyser.AnalyserLauncher.THIS_PROJECT_PATH;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class AnalyserLauncherTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnThisProjectPathWhenArgumentIsNullTest() throws Exception {
        // given
        AnalyserLauncher analyserLauncher = new AnalyserLauncher();

        // when
        final String path = analyserLauncher.getPath(null);

        // then
        assertThat(THIS_PROJECT_PATH).isEqualTo(path);
    }

    @SuppressWarnings("ZeroLengthArrayAllocation")
    @Test
    public void shouldReturnThisProjectPathWhenArgumentArrayIsEmptyArrayTest() throws Exception {
        // given
        AnalyserLauncher analyserLauncher = new AnalyserLauncher();

        // when
        final String path = analyserLauncher.getPath(new String[0]);

        // then
        assertThat(THIS_PROJECT_PATH).isEqualTo(path);
    }

    @Test
    public void shouldReturnThisProjectPathWhenArgumentIsEmptyTest() throws Exception {
        // given
        AnalyserLauncher analyserLauncher = new AnalyserLauncher();

        // when
        final String emptyString = "";
        final String path = analyserLauncher.getPath(new String[]{emptyString});

        // then
        assertThat(emptyString).isEqualTo(path);
    }

    @Test
    public void shouldReturnPathTest() throws Exception {
        // given
        AnalyserLauncher analyserLauncher = new AnalyserLauncher();

        // when
        final String randomPath = RandomDataGenerator.generateString();
        final String path = analyserLauncher.getPath(new String[]{randomPath});

        // then
        assertThat(randomPath).isEqualTo(path);
    }

    @Test
    public void shouldAnalyseFile() throws Exception {

        //when
        AnalyserLauncher.main(new String[]{THIS_PROJECT_PATH});

    }

}