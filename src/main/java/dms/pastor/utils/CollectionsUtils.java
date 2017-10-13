package dms.pastor.utils;

import java.util.*;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class CollectionsUtils {

    private CollectionsUtils() {
    }

    public static int[] convertListToIntArray(List<Integer> integersList) {
        int[] intArray = new int[integersList.size()];
        int i = 0;
        for (Integer n : integersList) {
            intArray[i++] = n;
        }
        return intArray;
    }

    public static int[] convertSetToIntArray(Set<Integer> integersSet) {
        int[] intArray = new int[integersSet.size()];
        int i = 0;
        for (Integer n : integersSet) {
            intArray[i++] = n;
        }
        return intArray;
    }

    public static Set<Character> convertCharArrayToSet(char[] charsArray) {
        Set<Character> characterSet = new HashSet<>();
        for (char character : charsArray) {
            characterSet.add(character);
        }
        return characterSet;
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

}
