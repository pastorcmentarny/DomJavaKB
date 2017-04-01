package dms.pastor.tasks.exercises.string;

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

        validateInput(text);

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
            if (charList.get(ch) == null) {
                charList.put(ch, 1);
            } else {
                charList.put(ch, charList.get(ch) + 1);
            }
        }
    }

    private void validateInput(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    }

}
