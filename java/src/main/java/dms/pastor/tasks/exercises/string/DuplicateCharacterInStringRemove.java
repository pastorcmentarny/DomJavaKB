package dms.pastor.tasks.exercises.string;

import dms.pastor.utils.character.ToStringUtils;

import java.util.LinkedHashSet;

/**
 * Author Dominik Symonowicz
 * Created 12/02/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class DuplicateCharacterInStringRemove {

    private DuplicateCharacterInStringRemove() {
    }

    @SuppressWarnings({"ReturnOfNull", "QuestionableName"})
    static String removeDuplicateCharacterFromString(String string) {
        if (string == null) {
            return null;
        }
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (Character character : string.toCharArray()) {
            linkedHashSet.add(character);
        }
        return ToStringUtils.toString(linkedHashSet);
    }


}
