package dms.pastor.tools.coder;

import java.io.File;

import static dms.pastor.utils.FileTools.readRawData;
import static dms.pastor.utils.StringUtils.reverseString;
import static dms.pastor.utils.StringUtils.swapCaseLettersInString;
import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class DomCoder {
    private static final String PATH = "src" + separator + "main" + separator + "resources" + separator + "input.txt";
    private String content;

    DomCoder(String content) {
        this.content = content;
    }

    static String loadSourceFile() {
        return readRawData(new File(PATH));
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    void applyReverseString() {
        content = reverseString(content);
    }

    void applySwapCharacters() {
        content = swapCaseLettersInString(content);
    }

    void validateContent() {
        if (content == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
    }
}
