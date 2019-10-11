package dms.pastor.examples.java10;

import dms.pastor.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableUnmodifiableExample {

    public List<String> getUnmodifiableListOfCharactersFromText(String text) {
        List<String> list = null;
        return Arrays.asList(text.toCharArray()).stream().filter(x -> StringUtils.hasNonAlphanumericCharactersOnly(x)).collect(Collectors.toUnmodifiableList());
        return null;
    }


    /*
    toUnmodifiableList()
    toUnmodifiableMap()
    toUnmodifiableSet()
     */
}
