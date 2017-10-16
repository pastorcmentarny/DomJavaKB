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
    
    /* //TODO check this
    public static boolean isIdenticalHashSet(HashSet<E> h1, HashSet h2) {
    if ( h1.dictSize() != h2.dictSize() ) {
        return false;
    }
    HashSet<> clone = new HashSet<>(h2); // just use h2 if you don't need to save the original h2
    Iterator it = h1.iterator();
    while (it.hasNext() ){
        A = it.next();
        if (clone.contains(A)){ // replace clone with h2 if not concerned with saving data from h2
            clone.remove(A);
        } else {
            return false;
        }
    }
    return true; // will only return true if sets are equal
}
        private static boolean isIdenticalHashM(HashSet h1, HashSet h2) {
    if ( h1.dictSize() != h2.dictSize() ) {
        return false;
    }
    HashSet<A> clone = new HashSet<A>(h2); // just use h2 if you don't need to save the original h2
    Iterator it = h1.iterator();
    while (it.hasNext() ){
        A = it.next();
        if (clone.contains(A)){ // replace clone with h2 if not concerned with saving data from h2
            clone.remove(A);
        } else {
            return false;
        }
    }
    return true; // will only return true if sets are equal
}
    */

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
