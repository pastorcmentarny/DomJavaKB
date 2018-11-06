package dms.pastor.domain;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class AwesomeRequest {

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