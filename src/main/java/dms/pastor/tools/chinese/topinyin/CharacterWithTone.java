package dms.pastor.tools.chinese.topinyin;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Author Dominik Symonowicz
 * Created 04/01/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CharacterWithTone {
    private final String word;
    private final int tone;

    CharacterWithTone(String word, int tone) {
        this.word = word;
        this.tone = tone;
    }

    public String getWord() {
        return word;
    }

    int getTone() {
        return tone;
    }

    public static CharacterWithTone fromString(String string) {
        final String[] wordAndTone = string.split(Pattern.quote("("));
        if (wordAndTone.length == 1) {
            return new CharacterWithTone(wordAndTone[0], 0);
        } else {
            return new CharacterWithTone(wordAndTone[0], Integer.parseInt(wordAndTone[1].substring(0, 1)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterWithTone that = (CharacterWithTone) o;
        return getTone() == that.getTone() &&
                Objects.equals(getWord(), that.getWord());
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
