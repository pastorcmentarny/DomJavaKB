package dms.pastor.utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author Dominik Symonowicz
 * Created 2014-10-04 19.05
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class HashTools {

    private HashTools() {
    }

    @SuppressWarnings("QuestionableName") // because string is valid name
    static HashSet<Character> stringToCharacterSet(String string) {
        ValidatorUtils.validateIfNotEmpty(string);
        char[] chars = string.toCharArray();
        HashSet<Character> charsSet = new HashSet<>();
        for (char ch : chars) {
            charsSet.add(ch);
        }
        return charsSet;
    }

    static HashMap<Character, Integer> stringToCharacterMap(String aString) {
        char[] chars = aString.toCharArray();
        HashMap<Character, Integer> charHashMap = new HashMap<>();
        Integer counter;
        for (char ch : chars) {
            if (charHashMap.containsKey(ch)) {
                counter = charHashMap.get(ch);
                counter += 1;
                charHashMap.put(ch, counter);
            } else {
                charHashMap.put(ch, 1);
            }
        }
        return charHashMap;
    }
}
