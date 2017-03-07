package dms.pastor.domain;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class AwesomeRequest {

    private final UUID id;
    private final String data;

    public AwesomeRequest(UUID id, String data) {
        this.id = id;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}