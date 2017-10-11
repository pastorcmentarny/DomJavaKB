package dms.pastor.tools.chinese.validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tools.chinese.validator.WordValidator.validateWord;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
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
public class WordValidatorTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordValidatorTest.class);

    private static final int DEFAULT_ID = 292;
    private static final String DEFAULT_CHINESE_CHARACTER = "字";
    private static final String DEFAULT_PINYIN = "zì";
    private static final int DEFAULT_STROKES = 6;
    private static final String DEFAULT_MEANING_IN_ENGLISH = "character,validWord";
    private static final String DEFAULT_MEANING_IN_POLISH = "znak";
    private static final String[] DEFAULT_GROUP = {"hsk1"};
    private static final String DEFAULT_NOTES = "note";
    private static final int DEFAULT_DIFFICULTY = 2;

    private final Word validWord = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, DEFAULT_STROKES,
            DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void validateWordShouldReturnTrueForValidWord() {
        // when
        final boolean result = validateWord(validWord);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void validateWordShouldThrowIllegalArgumentExceptionIfWordIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Word cannot be null.");

        // when
        validateWord(null);
    }

    @Test
    public void validateWordShouldReturnFalseIfIdIsZero() {
        // given
        final Word wordInInvalidId = new Word(0, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInInvalidId);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfIdIsNegative() {
        // given
        final int negativeId = randomNegativeInteger();
        final Word wordInInvalidId = new Word(negativeId, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInInvalidId);

        // debug
        LOGGER.debug("random id used: " + negativeId);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfChineseCharacterIsNull() {
        // given
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, null, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);


        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfChineseCharacterIsEmpty() {
        // given
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, EMPTY_STRING, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfChineseCharacterContainsLetter() {

        // given
        final String invalidChineseCharacter = DEFAULT_CHINESE_CHARACTER + getRandomCharacterAsString();
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, invalidChineseCharacter, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfChineseCharacterContainNumber() {
        // given
        final String invalidChineseCharacter = DEFAULT_CHINESE_CHARACTER + randomInteger(10);
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, invalidChineseCharacter, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);

        // debug
        LOGGER.debug(invalidChineseCharacter);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfChineseCharacterContainPinyinCharacter() {
        // given
        final String invalidChineseCharacter = DEFAULT_CHINESE_CHARACTER + generateRandomPinyinCharacter();
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, invalidChineseCharacter, DEFAULT_PINYIN, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);

        // debug
        LOGGER.debug(invalidChineseCharacter);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfStrokeIsNegativeButNotEqualToMinusOne() {
        // given
        final int negativeStrokeNumber = -2;
        final Word wordWithInvalidStrokes = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, negativeStrokeNumber,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithInvalidStrokes);

        // then
        assertThat(result).isFalse();
    }

    @Test // -1 means I didn't bother to count strokes
    public void validateWordShouldReturnTrueIfStrokeIsNegativeButEqualToMinusOne() {
        // given
        final int negativeStrokeNumber = -1;
        final Word wordWithValidStrokes = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, negativeStrokeNumber,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithValidStrokes);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void validateWordShouldReturnFalseIfStrokeIsZero() {
        // given
        final int zeroStrokes = 0;
        final Word wordWithInvalidStrokes = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, zeroStrokes,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithInvalidStrokes);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnTrueIfStrokeIsPositive() {
        // given
        final int strokes = randomPositiveInteger();
        final Word wordWithValidStrokes = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN, strokes,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithValidStrokes);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void validateWordShouldReturnFalseIfPinyinIsNull() {
        // given
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, null, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);


        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfPinyinIsEmpty() {
        // given
        final Word wordInNullChineseCharacter = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, EMPTY_STRING, DEFAULT_STROKES,
                DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH, DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordInNullChineseCharacter);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfEnglishMeaningIsNull() {
        // given
        final Word wordWithNullEnglishMeaning = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, null, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithNullEnglishMeaning);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfEnglishIsEmpty() {
        // given
        final Word wordWithEmptyEnglishMeaning = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, EMPTY_STRING, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithEmptyEnglishMeaning);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfEnglishContainsPinyinCharacter() {
        // given
        final String englishMeaningWithPinyin = "o with 3rd tone ò";
        final Word wordWithEmptyEnglishMeaning = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, englishMeaningWithPinyin, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithEmptyEnglishMeaning);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfGroupIsNull() {
        // given
        final Word wordWithEmptyEnglishMeaning = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_PINYIN, DEFAULT_MEANING_IN_POLISH,
                null, DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithEmptyEnglishMeaning);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfGroupSizeIsZero() {
        // given
        final Word wordWithNoGroup = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_PINYIN, DEFAULT_MEANING_IN_POLISH,
                new String[0], DEFAULT_NOTES, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithNoGroup);

        // then
        assertThat(result).isFalse();
    }


    @Test
    public void validateWordShouldReturnTrueIfNotesIsNullAsNoteWillSetToDefault() {
        // given
        final Word wordWithNullNotes = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, null, DEFAULT_DIFFICULTY);

        // when
        final boolean result = validateWord(wordWithNullNotes);

        // then
        assertThat(result).isTrue();
    }


    @Test
    public void validateWordShouldReturnFalseIfDifficultyIsAbove8() {
        // given
        final int tooLargeDifficulty = 128;
        final Word wordWithInvalidDifficulty = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, tooLargeDifficulty);

        // when
        final boolean result = validateWord(wordWithInvalidDifficulty);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnFalseIfDifficultyIsBelow1() {
        // given
        final int negativeDifficulty = -2;
        final Word wordWithInvalidDifficulty = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, negativeDifficulty);

        // when
        final boolean result = validateWord(wordWithInvalidDifficulty);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateWordShouldReturnTrueIfDifficultyIsBetween1And8() {
        // given
        final int difficulty = randomPositiveInteger(8) + 1;
        final Word validDifficulty = new Word(DEFAULT_ID, DEFAULT_CHINESE_CHARACTER, DEFAULT_PINYIN,
                DEFAULT_STROKES, DEFAULT_MEANING_IN_ENGLISH, DEFAULT_MEANING_IN_POLISH,
                DEFAULT_GROUP, DEFAULT_NOTES, difficulty);

        // debug
        LOGGER.debug("difficulty: " + difficulty);
        // when
        final boolean result = validateWord(validDifficulty);

        // then
        assertThat(result).isTrue();
    }

}