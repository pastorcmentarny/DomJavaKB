package dms.pastor.spring.commons;

import com.fasterxml.jackson.core.JsonEncoding;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author Dominik Symonowicz
 * Created 17.06.2020
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class QuirkyUtils {
    private QuirkyUtils() {
    }

    //to remember what encoding are supported in Jackson
    public static Map<String, JsonEncoding> getJsonEncodingsAsMap() {
        return EnumSet.allOf(JsonEncoding.class).stream()
                .collect(Collectors.toMap(JsonEncoding::getJavaName, Function.identity()));

    }
}