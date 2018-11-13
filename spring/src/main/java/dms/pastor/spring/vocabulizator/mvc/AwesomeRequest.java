package dms.pastor.spring.vocabulizator.mvc;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */


class AwesomeRequest {

    private final UUID id;

    public AwesomeRequest(UUID id, String data) {
        this.id = id;
        String data1 = data;
    }

    public UUID getId() {
        return id;
    }

}