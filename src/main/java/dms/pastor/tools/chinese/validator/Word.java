package dms.pastor.tools.chinese.validator;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Word {

    private static final String DEFAULT_NOTE = "none";
    private final int id;
    private final String chineseCharacter;
    private final String pinyin;
    private final int strokes;
    private final String englishMeaning;
    private final String polish;
    private final String[] groups;
    private String notes = DEFAULT_NOTE;
    private final int difficulty;

    @SuppressWarnings("ConstructorWithTooManyParameters") //it is object value
    public Word(int id, String chineseCharacter, String pinyin, int strokes, String englishMeaning, String polish, String[] groups, String notes, int difficulty) {
        this.id = id;
        this.chineseCharacter = chineseCharacter;
        this.pinyin = pinyin;
        this.strokes = strokes;
        this.englishMeaning = englishMeaning;
        this.polish = polish;
        this.groups = groups;
        setNotes(notes);
        this.difficulty = difficulty;
    }

    static Word noWord() {
        return new Word(-1, null, null, -1, null, null, null, null, -1);
    }

    public String getChineseCharacter() {
        return chineseCharacter;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getWordInEnglish() {
        return englishMeaning;
    }

    public String getWordInPolish() {
        return polish;
    }

    public int getId() {
        return id;
    }

    public int getStrokes() {
        return strokes;
    }

    public String[] getGroups() {
        return groups == null ? new String[0] : copyOf(groups, groups.length);
    }

    public String getNotes() {
        return notes;
    }

    private void setNotes(String note) {
        if (note == null) {
            this.notes = DEFAULT_NOTE;
        } else {
            this.notes = note;
        }
    }

    public String toShortString() {
        return chineseCharacter + " - '" +
                pinyin + "' - [ " +
                englishMeaning + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return getId() == word.getId() &&
                getStrokes() == word.getStrokes() &&
                getDifficulty() == word.getDifficulty() &&
                Objects.equals(getChineseCharacter(), word.getChineseCharacter()) &&
                Objects.equals(getPinyin(), word.getPinyin()) &&
                Objects.equals(englishMeaning, word.englishMeaning) &&
                Objects.equals(polish, word.polish) &&
                Arrays.equals(getGroups(), word.getGroups()) &&
                Objects.equals(getNotes(), word.getNotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChineseCharacter(), getPinyin(), getStrokes(), englishMeaning, polish, getGroups(), getNotes(), getDifficulty());
    }

    @Override
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
                ", difficulty=" + difficulty +
                '}';
    }


    public String asWord() {
        return "ID: " + id + "\nChinese: " + chineseCharacter + "\nPinyin: " + pinyin + "(" + strokes + ")\nEnglish: " + englishMeaning + "\nPolish:" + polish + "\nNotes: " + notes + "\nDifficulty: " + difficulty;
    }

    public static Word defaultWord() {
        return new Word(292, "字", "zì", 6,
                "character", "znak", new String[]{"hsk1"}, "note", 2);

    }

    @SuppressWarnings("SameReturnValue") // no categories is represented as null should wrap this with object
    public static String[] noCategories() {
        return null;
    }
}
