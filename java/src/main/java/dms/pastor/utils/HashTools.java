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
        char[] characters = string.toCharArray();
        HashSet<Character> charsSet = new HashSet<>();
        for (char character : characters) {
            charsSet.add(character);
        }
        return charsSet;
    }

    static HashMap<Character, Integer> stringToCharacterMap(String aString) {
        char[] characters = aString.toCharArray();
        HashMap<Character, Integer> charHashMap = new HashMap<>();
        Integer counter;
        for (char character : characters) {
            if (charHashMap.containsKey(character)) {
                counter = charHashMap.get(character);
                counter += 1;
                charHashMap.put(character, counter);
            } else {
                charHashMap.put(character, 1);
            }
        }
        return charHashMap;
    }
}
