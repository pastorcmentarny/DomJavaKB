package dms.pastor.tools.chinese.validator;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Getter
@EqualsAndHashCode
public final class Word {

    private static final String DEFAULT_NOTE = "none";
    private final int id;
    private final String chineseCharacter;
    private final String pinyin;
    private final int strokes;
    private final String englishMeaning;
    private final String polish;
    private final String[] groups;
    private final int difficulty;
    private String notes = DEFAULT_NOTE;
    private final String hash;

    @SuppressWarnings("ConstructorWithTooManyParameters") //it is object value
    public Word(int id, String chineseCharacter, String pinyin, int strokes, String englishMeaning, String polish, String[] groups, String notes, int difficulty, String hash) {
        this.id = id;
        this.chineseCharacter = chineseCharacter;
        this.pinyin = pinyin;
        this.strokes = strokes;
        this.englishMeaning = englishMeaning;
        this.polish = polish;
        this.groups = groups;
        this.hash = hash;
        setNotes(notes);
        this.difficulty = difficulty;
    }

    static Word noWord() {
        return new Word(none(), null, null, none(), null, null, null, null, none(), null);
    }

    private static int none() {
        return -1;
    }

    @SuppressWarnings("MagicNumber")
    public static Word defaultWord() {
        return new Word(292, "字", "zì", 6,
                "character", "znak", new String[]{"hsk1"}, "note", 2, "abcdef12");
    }

    @SuppressWarnings("SameReturnValue") // no categories is represented as null should wrap this with object
    public static String[] noCategories() {
        return null;
    }


    public String getWordInEnglish() {
        return englishMeaning;
    }

    public String getWordInPolish() {
        return polish;
    }

    public String[] getGroups() {
        return groups == null ? new String[0] : copyOf(groups, groups.length);
    }

    private void setNotes(String note) {
        this.notes = Objects.requireNonNullElse(note, DEFAULT_NOTE);
    }

    public String toShortString() {
        return chineseCharacter + " - '" +
                pinyin + "' - [ " +
                englishMeaning + " ]";
    }


    @Override //TODO use lombok and use custom get word method
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", chineseCharacter='" + chineseCharacter + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", strokes=" + strokes +
                ", englishMeaning='" + englishMeaning + '\'' +
                ", polish='" + polish + '\'' +
                ", groups=" + Arrays.toString(groups) +
                ", notes='" + notes + '\'' +
                ", difficulty=" + difficulty + '\'' +
                ", hash=" + hash +
                '}';
    }

    public String asWord() {
        return "ID: " + id + "\nChinese: " + chineseCharacter + "\nPinyin: " + pinyin + "(" + strokes + ")\nEnglish: " + englishMeaning + "\nPolish:" + polish + "\nNotes: " + notes + "\nDifficulty: " + difficulty;
    }
}
