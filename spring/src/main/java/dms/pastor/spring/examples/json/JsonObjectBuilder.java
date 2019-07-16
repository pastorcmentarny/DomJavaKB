package dms.pastor.spring.examples.json;

import dms.pastor.utils.randoms.RandomDataGenerator;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JsonObjectBuilder {
    private static final int MAX = 32;
    private final Random random = new Random();
    private String name = RandomDataGenerator.generateString(MAX);
    private int version = random.nextInt(MAX);
    private boolean ok = random.nextBoolean();

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
