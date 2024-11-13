package dms.pastor.tools.chinese.topinyin;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Author Dominik Symonowicz
 * Created 04/01/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CharacterWithTone {

    private final String word;
    private final int tone;

    CharacterWithTone(String word, int tone) {
        this.word = word;
        this.tone = tone;
    }

    public static CharacterWithTone fromString(String character) {
        final String[] wordAndTone = character.split(Pattern.quote("("));
        if (wordAndTone.length == 1) {
            return new CharacterWithTone(wordAndTone[0], 0);
        } else {
            return new CharacterWithTone(wordAndTone[0], Integer.parseInt(wordAndTone[1].substring(0, 1)));
        }
    }

    public String getWord() {
        return word;
    }

    int getTone() {
        return tone;
    }

    @Override
    public boolean equals(Object otherCharacterWithTone) {
        if (this == otherCharacterWithTone) {
            return true;
        }
        if (otherCharacterWithTone == null || getClass() != otherCharacterWithTone.getClass()) {
            return false;
        }
        CharacterWithTone characterWithTone = (CharacterWithTone) otherCharacterWithTone;
        return getTone() == characterWithTone.getTone() &&
                Objects.equals(getWord(), characterWithTone.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), getTone());
    }

    @Override
    public String toString() {
        return "CharacterWithTone{" +
                "word='" + word + '\'' +
                ", tone=" + tone +
                '}';
    }
}
