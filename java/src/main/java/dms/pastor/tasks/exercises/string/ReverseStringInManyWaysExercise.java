package dms.pastor.tasks.exercises.string;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("QuestionableName") // because string is valid name
final class ReverseStringInManyWaysExercise {

    private ReverseStringInManyWaysExercise() {
    }

    static String reversStringViaStringBuilder(String string) {
        validateInput(string);
        return new StringBuilder(string).reverse().toString();
    }

    private static void validateInput(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
    }

    static String reversStringViaStringBuffer(String string) {
        validateInput(string);
        return new StringBuffer(string).reverse().toString();
    }

    static String reversStringViaChar(String string) {
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

    static String reverseStringWithoutLibraries(String originalString) {
        validateInput(originalString);
        if (originalString.isEmpty() || originalString.length() == 1) {
            return originalString;
        }

        char[] reversedString = new char[originalString.length()];
        char[] originalArray = originalString.toCharArray();

        int reversedIndex = 0;

        for (int i = originalArray.length - 1; i >= 0; i--) {
            reversedString[i] = originalArray[reversedIndex];
            reversedIndex++;
        }

        return new String(reversedString);
    }
}
