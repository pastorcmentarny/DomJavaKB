package dms.pastor.utils;

import java.util.*;

import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CollectionsUtils {

    private CollectionsUtils() {
    }

    public static int[] convertToIntArray(Collection<Integer> integersList) {
        int[] intArray = new int[integersList.size()];
        int index = 0;
        for (Integer integer : integersList) {
            intArray[index++] = integer;
        }
        return intArray;
    }


    // you will lost order and duplicated value
    public static Set<String> convertStringArrayToSet(String[] stringArray) {
        return new HashSet<>(Arrays.asList(stringArray));
    }

    public static List<String> emptyArrayList() {
        return new ArrayList<>(0);
    }

    public static Set<Object> emptyHashSet() {
        return new HashSet<>(0);
    }

    public static boolean isStringArrayEmpty(String[] array) {
        return (array == null || array.length == 0);
    }

    public static boolean isListNotEmpty(List list) {
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

    public static List<String> convertToStringArray(char[] charArray) {
        if (charArray == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (char c : charArray) {
            list.add(String.valueOf(c));
        }
        return list;
    }

}
