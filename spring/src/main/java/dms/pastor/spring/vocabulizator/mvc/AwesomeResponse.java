package dms.pastor.spring.vocabulizator.mvc;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class AwesomeResponse {

    private final boolean success;

    public AwesomeResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
