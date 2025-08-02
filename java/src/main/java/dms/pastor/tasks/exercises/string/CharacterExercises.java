package dms.pastor.tasks.exercises.string;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@SuppressWarnings("QuestionableName")
public class CharacterExercises {

    public int countCharacterInString(Character character, String string) {
        char[] singleChar = character.toString().toLowerCase().toCharArray();
        char aChar = singleChar[0];
        char[] characterArray = string.toLowerCase().toCharArray();
        return countCharacters(aChar, characterArray);
    }

    //without using length on String
    int countCharacterInStringIgnoringCase(Character character, String string) {
        char[] chars = string.toLowerCase().toCharArray();
        return countCharacters(character, chars);
    }

    int alternatingCharacters(String string) {
        char[] abArray = string.toLowerCase().toCharArray();
        char previous = (abArray[0] == 'a' ? 'b' : 'a');
        int counter = 0;
        for (char ch : abArray) {
            if (ch == previous) {
                counter++;
            } else {
                previous = ch;
            }
        }
        return counter;
    }

    private int countCharacters(char aChar, char[] chars) {
        int counter = 0;
        for (char ch : chars) {
            if (ch == aChar) {
                counter++;
            }
        }
        return counter;
    }
}
