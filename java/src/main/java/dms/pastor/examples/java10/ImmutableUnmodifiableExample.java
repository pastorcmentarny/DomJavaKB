package dms.pastor.examples.java10;

import java.util.List;

public class ImmutableUnmodifiableExample {

    public List<String> getUnmodifiableListOfCharactersFromText(String text) {
        List<String> list = null;
        // return Arrays.asList(text.toCharArray()).stream().filter(x -> StringUtils.hasNonAlphanumericCharactersOnly(x)).collect(Collectors.toUnmodifiableList());
        return null;
    }


    /*
    toUnmodifiableList()
    toUnmodifiableMap()
    toUnmodifiableSet()
     */
}
