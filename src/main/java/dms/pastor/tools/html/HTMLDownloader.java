package dms.pastor.tools.html;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static dms.pastor.tools.html.HTMLValidator.validateUrl;
import static org.apache.log4j.Logger.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2011-11-01
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HTMLDownloader {

    private final static Logger LOGGER = getLogger(HTMLDownloader.class);

    static String download(String urlStr) throws IOException {
        String type;
        String content;

        validateUrl(urlStr);

        LOGGER.info("Starting download and read html page from URL:" + urlStr);
        URL url = new URL(urlStr);
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
            content.append(new StringBuffer(line)).append('\n');
        }
        return content.toString();
    }



}
