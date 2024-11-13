package dms.pastor.examples.mockito;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * this class is used as example for mockito
 * tag-mockito
 * tag-argumentCaptor
 */
class MockitoExampleRequest {

    private final UUID id;
    private final String data;

    public MockitoExampleRequest(UUID id, String data) {
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