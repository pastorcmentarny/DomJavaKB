package dms.pastor.utils.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharArrayToListConverter implements Converter<char[], List<String>> {

    public List<String> convert(char[] from) {
        if (Objects.isNull(from)) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (char character : from) {
            list.add(String.valueOf(character));
        }
        return list;
    }
}
