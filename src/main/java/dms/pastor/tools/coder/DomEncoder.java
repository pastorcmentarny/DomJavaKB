package dms.pastor.tools.coder;

import java.util.Base64;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
