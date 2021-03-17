package dms.pastor.tools.chinese.validator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WordTest {
    private static final int DEFAULT_ID = 292;
    private static final String DEFAULT_CHINESE_CHARACTER = "字";
    private static final String DEFAULT_PINYIN = "zì";
    private static final int DEFAULT_STROKES = 6;
    private static final String DEFAULT_MEANING_IN_ENGLISH = "character,validWord";
    private static final String DEFAULT_MEANING_IN_POLISH = "znak";
    private static final String[] DEFAULT_GROUP = {"hsk1"};
    private static final String DEFAULT_NOTES = "note";
    private static final String DEFAULT_HASH = "abcdef12";
    private static final int DEFAULT_DIFFICULTY = 2;
    public static final String NOTE_AS_NULL = null;

    private final Word word = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, DEFAULT_STROKES,
            DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY, DEFAULT_HASH);

    @Test
    public void noWordShouldCreateNoWordObject() {
        // given
        final Word expectedWord = new Word(-1, null, null, -1,
                null, null, null, NOTE_AS_NULL, -1, null);
        // when
        final Word word = Word.noWord();

        // then
        assertThat(word).isEqualTo(expectedWord);
    }

    @Test
    public void toShortStringShouldReturnBasicInformationAboutWord() {
        // given
        final String expectedWordWithBasicInformation = word.getChineseCharacter() + " - '" +
                word.getPinyin() + "' - [ " +
                word.getWordInEnglish() + " ]";

        // when
        final String wordWithBasicInformation = word.toShortString();

        // then
        assertThat(wordWithBasicInformation).isEqualTo(expectedWordWithBasicInformation);
    }

    @Test
    public void asWordShouldReturnWordAsString() {
        // given
        final String expectedWordAsStringWithAllInformation = "ID: " + word.getId()
                + "\nChinese: " + word.getChineseCharacter() + "\nPinyin: " + word.getPinyin() + "(" + word.getStrokes()
                + ")\nEnglish: " + word.getWordInEnglish() + "\nPolish:" + word.getWordInPolish()
                + "\nNotes: " + word.getNotes() + "\nDifficulty: " + word.getDifficulty();

        // when
        final String wordAsString = word.asWord();

        // then
        assertThat(wordAsString).isEqualTo(expectedWordAsStringWithAllInformation);
    }


    @Test
    public void setNotesShouldSetNoteToNoneIfNoteIsNull() {
        // given
        final String expectedNote = "none";

        final Word wordWithNullNote = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, NOTE_AS_NULL, DEFAULT_DIFFICULTY, DEFAULT_HASH);
        // when
        final String notes = wordWithNullNote.getNotes();

        // then
        assertThat(notes).isEqualTo(expectedNote);
    }

}
