package dms.pastor.tools.chinese.validator;

import java.util.Arrays;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This tool is used to validate words while they are loaded to dictionary in Doms learn Chinese
 * This is slightly modified version of Word class from my game Dom Learn Chinese
 * Validator is here not in App due fact that testing in Android is pain in the ass
 */
public final class Word {

    private static final String DEFAULT_NOTE = "none";
    private int id;
    private String chineseCharacter;
    private String pinyin;
    private int strokes;
    private String englishMeaning;
    private String polish;
    private String[] groups;
    private String notes = DEFAULT_NOTE;
    private int difficulty;

    public Word(int id, String chineseCharacter, String pinyin, int strokes, String englishMeaning, String polish, String[] groups, String notes, int difficulty) {
        setId(id);
        setChineseCharacter(chineseCharacter);
        setPinyin(pinyin);
        setStrokes(strokes);
        setEnglishMeaning(englishMeaning);
        setPolishMeaning(polish);
        setGroups(groups);
        setNotes(notes);
        setDifficulty(difficulty);
    }

    public static Word noWord() {
        return new Word(-1, null, null, -1, null, null, null, null, -1);
    }

    public String getChineseCharacter() {
        return chineseCharacter;
    }

    private void setChineseCharacter(String chineseCharacter) {
        this.chineseCharacter = chineseCharacter;
    }

    public int getDifficulty() {
        return difficulty;
    }

    private void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getPinyin() {
        return pinyin;
    }

    private void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getWordInEnglish() {
        return englishMeaning;
    }

    private void setEnglishMeaning(String wEnglish) {
        this.englishMeaning = wEnglish;
    }

    public String getWordInPolish() {
        return polish;
    }

    private void setPolishMeaning(String wPolish) {
        this.polish = wPolish;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getStrokes() {
        return strokes;
    }

    private void setStrokes(int strokes) {
        this.strokes = strokes;
    }

    public String[] getGroups() {
        return groups;
    }

    private void setGroups(String[] groups) {
        this.groups = groups;
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

    public static String[] noCategories() {
        return null;
    }
}
