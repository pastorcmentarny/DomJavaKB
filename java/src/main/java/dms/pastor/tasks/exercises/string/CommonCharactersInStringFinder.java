package dms.pastor.tasks.exercises.string;

/**
 * Author Dominik Symonowicz
 * Created  Created Nov 6, 2014
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CommonCharactersInStringFinder {

    private static final int ASCII_CHARACTERS_COUNT = 256; // As ascii has 256 chars (ISO-8859-1)

    public String getCommonCharN(String stringA, String stringB) {
        StringBuilder result = new StringBuilder();
        boolean[] booleanArray = new boolean[ASCII_CHARACTERS_COUNT];
        char[] arrayA = stringA.toCharArray();
        char[] arrayB = stringB.toCharArray();
        setBooleanArrayToTrue(stringB, booleanArray, arrayB);

        for (int i = 0; i < stringA.length(); i++) {
            if (booleanArray[arrayA[i]]) {
                result.append(arrayA[i]);
                booleanArray[arrayA[i]] = false;
            }
        }
        return result.toString();
    }

    private void setBooleanArrayToTrue(String stringB, boolean[] booleanArray, char[] arrayB) {
        for (int i = 0; i < stringB.length(); i++) {
            booleanArray[arrayB[i]] = true;
        }
    }

    public String getCommonCharNSquared(String stringA, String stringB) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringA.length(); i++) {
            char character = stringA.charAt(i);
            for (int j = 0; j < stringB.length(); j++) {
                if (character == stringB.charAt(j) && result.indexOf(Character.toString(character)) < 0) {
                    result.append(character);
                }
            }
        }

        return result.toString();
    }
}
