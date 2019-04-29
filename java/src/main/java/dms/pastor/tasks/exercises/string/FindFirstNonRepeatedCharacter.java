package dms.pastor.tasks.exercises.string;

import dms.pastor.utils.ValidatorUtils;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * author Pastor
 * Created  2015-05-09.
 */
public class FindFirstNonRepeatedCharacter {

    public Optional<Character> findFirstNonRepeatedCharacter(String text) {
        Map<Character, Integer> charList = new TreeMap<>();

        ValidatorUtils.validateIfNotEmpty(text, "Text");

        convertTextIntoCharacterMap(text, charList);

        for (Map.Entry<Character, Integer> entry : charList.entrySet()) {
            if (entry.getValue() == 1) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    private void convertTextIntoCharacterMap(String text, Map<Character, Integer> charList) {
        char[] stringAsChar = text.toCharArray();
        for (char ch : stringAsChar) {
            charList.merge(ch, 1, Integer::sum);
        }
    }
}
