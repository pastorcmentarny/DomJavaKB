package dms.pastor.tools.html;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static dms.pastor.tools.html.HTMLDownloader.download;
import static dms.pastor.utils.FileTools.saveTextToFile;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http:   //pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HTMLDownloaderTest {

    private static final String URL = "http://dominiksymonowicz.com/about/";
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Ignore //need implement https version
    @Test
    public void acceptanceCriteria() throws Exception {
        // given
        final String content = download(URL);
        System.out.println(content);

        // when
        final boolean fileSaved = saveTextToFile(content, "example.txt");

        assertThat(fileSaved).isTrue();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUrlIsNullTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        download(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUrlIsEmptyTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        download(EMPTY_STRING);
    }

    @Ignore //need implement https version
    @Test
    public void testShouldReturnOKPage() throws IOException {
        // when
        final String result = download(URL);

        // then
        assertThat(result).contains(" I have done a proper IQ test." +
                " My result is 106. It means I am painfully average male with one exception. I have a special talent." +
                " According to the result, I am a genius in combine Lego bricks together. Agreed." +
                " It is not a key skill that guarantees to achieve successes in everything in your life." +
                " However, it is always something!");
    }

}
