package dms.pastor.utils.converters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringArrayToSetConverter implements Converter<String[], Set<String>> {

    @Override // lost order and duplicated values
    public Set<String> convert(String[] from) {
        return new HashSet<>(Arrays.asList(from));
    }

}

