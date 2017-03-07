package dms.pastor.utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * version 20141011
 * author: Pastor cmentarny
 * #WWW:			http://pastor.ovh.org
 * #Github:		https://github.com/pastorcmentarny
 * #Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * #LinkedIn: 		uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * #Email: 		email can be found on my website
 * #Created Oct 4, 2014 at 7:05:29 PM
 */
class HashTools {

    private HashTools() {
    }
    
    /*
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

    public static HashSet<Character> stringToCharacterSet(String aString) {
        char[] chars = aString.toCharArray();
        HashSet<Character> charsSet = new HashSet<>();
        for (char ch : chars) {
            charsSet.add(ch);
        }
        return charsSet;
    }

    public static HashMap<Character, Integer> stringToCharacterMap(String aString) {
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
