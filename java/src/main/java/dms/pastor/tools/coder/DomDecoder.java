package dms.pastor.tools.coder;

import static java.util.Base64.getDecoder;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class DomDecoder extends DomCoder {

    DomDecoder(String content) {
        super(content);
    }

    String decode() {
        validateContent();
        applySwapCharacters();
        applyReverseString();
        unApplyBase64();
        return getContent();
    }

    private void unApplyBase64() {
        setContent(new String(getDecoder().decode(getContent().getBytes())));
    }
}
