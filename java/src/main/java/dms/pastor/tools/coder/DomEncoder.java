package dms.pastor.tools.coder;

import java.util.Base64;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class DomEncoder extends DomCoder {

    DomEncoder(String content) {
        super(content);
    }

    String encode() {
        validateContent();
        applyBase64();
        applyReverseString();
        applySwapCharacters();
        return getContent();
    }

    private void applyBase64() {
        setContent(new String(Base64.getEncoder().encode(getContent().getBytes())));
    }

}
