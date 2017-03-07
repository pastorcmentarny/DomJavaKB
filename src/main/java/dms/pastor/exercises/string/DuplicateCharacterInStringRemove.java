package dms.pastor.exercises.string;

import java.util.LinkedHashSet;

/**
 * Author Dominik Symonowicz
 * Created 12/02/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
