package dms.pastor.tools;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static dms.pastor.tools.HTMLReader.download;
import static dms.pastor.tools.HTMLReader.saveToFile;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	http:   //pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HTMLReaderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    @Ignore //as I move to new site
    public void acceptanceCriteria() throws Exception {
        final String content = download("http://pastor.ovh.org/ok.html");
        System.out.println(content);
        Assert.assertThat(saveToFile(content, "example.txt"), is(true));
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