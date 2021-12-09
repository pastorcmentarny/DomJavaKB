package dms.pastor.utils;

import java.util.*;

import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;
import static java.util.Objects.isNull;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CollectionsUtils {

    private CollectionsUtils() {
    }

    //TODO remove it as it is part of Java itself
    public static List<String> emptyArrayList() {
        return new ArrayList<>(0);
    }

    public static Set<Object> emptyHashSet() {
        return new HashSet<>(0);
    }

    public static boolean isStringArrayEmpty(String[] array) {
        return (array == null || array.length == 0);
    }

    public static boolean isListNotEmpty(List<Object> list) {
        return list != null && !list.isEmpty();
    }

    public static <E extends Enum<E>> List<E> toList(E[] enums) {
        validateIfObjectValueIsNotNull(enums, "Enum values");
        return Arrays.asList(enums);
    }

    static boolean isCharInCharArray(char[] charArray, char character) {
        for (char charElement : charArray) {
            if (Character.toLowerCase(character) == charElement) {
                return true;
            }
        }
        return false;

    }

    public static List<String> returnShuffledListAsNewCollection(List<String> original) {
        if (isNull(original) || original.isEmpty()) {
            return original;
        }
        List<String> destination = new ArrayList<>(original.size());
        destination.addAll(original);
        Collections.shuffle(destination);
        return destination;

    }
}
