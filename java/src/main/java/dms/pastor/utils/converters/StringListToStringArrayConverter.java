package dms.pastor.utils.converters;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 07.05.2020
 */
public class StringListToStringArrayConverter implements Converter<List<String>, String[]> {

    public String[] convert(List<String> from) {
        if (isNull(from) || from.isEmpty()) {
            return new String[0];
        }
        String[] temp = new String[from.size()];

        for (int item = 0; item < from.size(); item++) {
            temp[item] = from.get(item);
        }
        return temp;
    }
}
