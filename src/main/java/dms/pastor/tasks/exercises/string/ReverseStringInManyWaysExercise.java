package dms.pastor.tasks.exercises.string;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class ReverseStringInManyWaysExercise {

    public static String reversStringViaStringBuilder(String string) {
        validateInput(string);
        return new StringBuilder(string).reverse().toString();
    }

    private static void validateInput(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
    }

    public static String reversStringViaStringBuffer(String string) {
        validateInput(string);
        return new StringBuffer(string).reverse().toString();
    }

    public static String reversStringViaChar(String string) {
        validateInput(string);
        char[] charArray = string.toCharArray();
        int length = string.length();
        int last = length - 1;
        int middle = length / 2;

        for (int i = 0; i < middle; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[last - i];
            charArray[last - i] = temp;
        }
        return new String(charArray);
    }

    //TODO check
    public static String reverseStringWithoutLibraries(String originalString) {
        validateInput(originalString);
        if (originalString.equalsIgnoreCase(EMPTY_STRING) || originalString.length() == 1) {
            return originalString;
        }

        char[] reversedString = new char[originalString.length()];
        char[] originalArray = originalString.toCharArray();

        int j = 0;

        for (int i = originalArray.length - 1; i >= 0; i--) {
            reversedString[i] = originalArray[j];
            j++;
        }

        return new String(reversedString);
    }
}
