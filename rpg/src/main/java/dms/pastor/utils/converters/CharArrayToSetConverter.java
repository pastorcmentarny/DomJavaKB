package dms.pastor.utils.converters;

import java.util.HashSet;
import java.util.Set;

/**
 * Author Dominik Symonowicz
 * Created 07.05.2020
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CharArrayToSetConverter implements Converter<char[], Set<Character>> {

    @Override
    public Set<Character> convert(char[] charsArray) {
        Set<Character> characterSet = new HashSet<>();
        for (char character : charsArray) {
            characterSet.add(character);
        }
        return characterSet;
    }
}
