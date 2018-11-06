package dms.pastor.tools.coder;

import java.util.Base64;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
