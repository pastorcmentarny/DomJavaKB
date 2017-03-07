package dms.pastor.tools.coder;

import static java.util.Base64.getDecoder;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
