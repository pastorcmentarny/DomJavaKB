package dms.pastor.utils.converters;

import java.util.List;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 07.05.2020
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StringListToStringArrayConverter implements Converter<List<String>, String[]> {

    @Override
    public String[] convert(List<String> from) {
        if (Objects.isNull(from) || from.isEmpty()) {
            return new String[0];
        }
        String[] temp = new String[from.size()];

        for (int item = 0; item < from.size(); item++) {
            temp[item] = from.get(item);
        }
        return temp;
    }
}
