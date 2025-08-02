package dms.pastor.utils.converters;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 07.05.2020
 */
public class CharArrayToSetConverter implements Converter<char[], Set<Character>> {

    public Set<Character> convert(char[] charsArray) {
        Set<Character> characterSet = new HashSet<>();
        for (char character : charsArray) {
            characterSet.add(character);
        }
        return characterSet;
    }
}
