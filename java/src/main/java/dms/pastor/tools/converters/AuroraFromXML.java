package dms.pastor.tools.converters;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class AuroraFromXML {
    public static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static String toJson(String xml) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
            return jsonPrettyPrintString;
        } catch (JSONException jsonException) {
            System.out.printf("It was a problem with JSON: %s%n", jsonException);
            return null;
        }

    }
}
