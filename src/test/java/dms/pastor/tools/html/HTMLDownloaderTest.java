package dms.pastor.tools.html;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static dms.pastor.tools.html.HTMLDownloader.download;
import static dms.pastor.utils.FileTools.saveTextToFile;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	http:   //pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HTMLDownloaderTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    @Ignore //as I move to new site
    public void acceptanceCriteria() throws Exception {
        // given
        final String content = download("http://pastor.ovh.org/ok.html");
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
        download("");
    }

    @Test
    @Ignore //as I move to new site
    public void testShouldReturnOKPage() throws IOException {
        Assert.assertThat(download("http://pastor.ovh.org/ok.html"), is(getOKPage()));
    }

    private String getOKPage() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\"/>\n" +
                "    <meta name=\"Description\" content=\"Page is used for test connection in my app.\" />\n" +
                "    <meta name=\"Author\" content=\"Dominik Symonowicz\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/pro.css\" type=\"text/css\"/>\n" +
                "  </head>\n" +
                "  <body>\n" +
                '\n' +
                "    <div class=\"all\">\n" +
                "        <p class=\"headline\">\n" +
                "          <strong>DOM'S DIAGNOSTIC TOOLS</strong> test network site<br/>\n" +
                '\n' +
                "\t\t\tIT SEEMS ,THAT YOUR NETWORK CONNECTION WORKS :)<br/>\t\n" +
                "\t\t\t\t(what you see is html file used to display page in web browser)\n" +
                '\n' +
                "        </p>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";
    }

}