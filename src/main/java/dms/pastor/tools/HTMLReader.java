package dms.pastor.tools;

import dms.pastor.utils.FileTools;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static dms.pastor.utils.StringUtils.isStringBlank;
import static org.apache.log4j.Logger.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2011-11-01
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HTMLReader {

    private final static Logger LOGGER = getLogger(HTMLReader.class);

    public static String download(String urlStr) throws IOException {
        final String notHtmlType = "WOOPS!\n\tIt is not a html file.Unable to read non-html file.";
        String type;
        String content;

        validateUrl(urlStr);

        LOGGER.info("Starting download and read html page from URL:" + urlStr);
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        try (InputStream urlStream = url.openStream();
             BufferedReader html = new BufferedReader(new InputStreamReader(urlStream))) {
            type = urlConnection.getContentType();
            validateContentType(notHtmlType, type);
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

    private static void validateContentType(String notHtmlType, String type) {
        if (type == null) {
            throw new NullPointerException("Problem with type");
        } else if (type.compareTo("text/html") != 0) {
            LOGGER.error(notHtmlType);
            throw new IllegalArgumentException(notHtmlType);             // only html are here
        }//TODO if(type.compareTo("application/json") )
    }

    private static void validateUrl(String urlStr) {
        if (isStringBlank(urlStr)) {
            throw new IllegalArgumentException("It must be valid url");
        }
    }

    static boolean saveToFile(String content, String pathFile) {
        return FileTools.saveTextToFile(content, pathFile);
    }

}
