package dms.pastor.tools.html;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;

import static dms.pastor.tools.html.HTMLValidator.validateUrl;

/**
 * Author Dominik Symonowicz
 * Created 2011-11-01
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class HTMLDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(HTMLDownloader.class);

    private HTMLDownloader() {
    }

    static String download(String urlStr) throws IOException {
        String type;
        String content;

        validateUrl(urlStr);

        LOGGER.info("Starting download and read html page from URL:{}", urlStr);
        URL url = URI.create(urlStr).toURL();
        URLConnection urlConnection = url.openConnection();
        try (InputStream urlStream = url.openStream();
             BufferedReader html = new BufferedReader(new InputStreamReader(urlStream))) {
            type = urlConnection.getContentType();
            HTMLValidator.validateContentType(type);
            content = loadHtml(html);
        }
        LOGGER.info("Read html page is finished.");
        return content;
    }

    private static String loadHtml(BufferedReader html) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = html.readLine()) != null) {
            content.append(line).append('\n');
        }
        return content.toString();
    }

}
