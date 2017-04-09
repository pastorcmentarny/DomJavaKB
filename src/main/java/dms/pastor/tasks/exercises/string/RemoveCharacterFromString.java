package dms.pastor.tasks.exercises.string;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;

class RemoveCharacterFromString {

    static String removeCharacterFromStringUsingIterative(String text, char character) {
        validateIfNotNull(text);

        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        char[] chars = text.toLowerCase().toCharArray();
        for (char ch : chars) {
            if (ch != character) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    static String removeCharacterFromStringUsingRecursive(String text, char character) {
        int index = text.toLowerCase().indexOf(character);
        if (index == -1) {
            return text;
        }
        return removeCharacterFromStringUsingRecursive(text.substring(0, index) + text.substring(index + 1, text.length()), character);
    }

}
