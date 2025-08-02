package dms.pastor.tasks.exercises.string;

import dms.pastor.utils.character.ToStringUtils;

import java.util.LinkedHashSet;

/**
 * Author Dominik Symonowicz
 * Created 12/02/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
