package dms.pastor.tools.coder;

import static java.util.Base64.getDecoder;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
