package dms.pastor.spring.examples.json;


import dms.pastor.spring.DomUtils;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JsonObjectBuilder {
    private static final int MAX = 32;
    private final Random random = new Random();
    private final String name = DomUtils.generateString(MAX);
    private final int version = random.nextInt(MAX);
    private final boolean ok = random.nextBoolean();

    private JsonObjectBuilder() {
    }

    public static JsonObjectBuilder jsonObjectBuilder() {
        return new JsonObjectBuilder();
    }

    public JsonObject build() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setName(name);
        jsonObject.setVersion(version);
        jsonObject.setOk(ok);
        String ignoredField = "IGNORED";
        jsonObject.setIgnoredField(ignoredField);
        return jsonObject;
    }

}
