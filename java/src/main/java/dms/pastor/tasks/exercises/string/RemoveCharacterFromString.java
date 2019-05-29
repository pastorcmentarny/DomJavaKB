package dms.pastor.tasks.exercises.string;

import dms.pastor.utils.ValidatorUtils;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

final class RemoveCharacterFromString {

    private RemoveCharacterFromString() {
    }

    static String removeCharacterFromStringUsingIterative(String text) {
        ValidatorUtils.validateIfObjectValueIsNotNull(text);

        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        char[] chars = text.toLowerCase().toCharArray();
        for (char ch : chars) {
            if (ch != 't') {
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
        return removeCharacterFromStringUsingRecursive(text.substring(0, index) + text.substring(index + 1), character);
    }

}
