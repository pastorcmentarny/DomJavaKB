package dms.pastor.tasks.exercises.string;

import java.util.LinkedHashSet;

/**
 * Author Dominik Symonowicz
 * Created 12/02/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class DuplicateCharacterInStringRemove {

    private static final String EMPTY_STRING = "";

    @SuppressWarnings("ReturnOfNull")
    static String removeDuplicateCharacterFromString(String string) {
        if (string == null) {
            return null;
        }
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (Character character : string.toCharArray()) {
            linkedHashSet.add(character);
        }
        return toString(linkedHashSet);
    }

    //TODO move to StringUtils
    private static String toString(LinkedHashSet<Character> charactersList) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (Character character : charactersList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
