package dms.pastor.spring.examples.json;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JsonExampleWrapper {
    private String description;
    private List<JsonObject> jsonObjectList;

    //Jackson use only
    @Deprecated
    public JsonExampleWrapper() {
        this(null, null);
    }

    public JsonExampleWrapper(String description, List<JsonObject> jsonObjectList) {
        this.description = description;
        this.jsonObjectList = jsonObjectList;
    }

    public String getDescription() {
        return description;
    }

    public List<JsonObject> getJsonObjectList() {
        return jsonObjectList;
    }
}
