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

    public static String[] convertToStringArray(ArrayList<String> itemsList) {
        if (Objects.isNull(itemsList) || itemsList.isEmpty()) {
            return new String[0];
        }
        String[] temp = new String[itemsList.size()];

        for (int i = 0; i < itemsList.size(); i++) {
            temp[i] = itemsList.get(i);
        }
        return temp;
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


    public static void main(String[] args) {
        final List<String> list = Arrays.asList("One", "Two", "Three", "Four");
        Collections.reverse(list);
        System.out.println(list);
    }
}
