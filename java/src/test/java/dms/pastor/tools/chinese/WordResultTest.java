package dms.pastor.tools.chinese;

import dms.pastor.tools.chinese.validator.Word;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dms.pastor.tools.chinese.WordResult.success;
import static dms.pastor.tools.chinese.validator.Word.defaultWord;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WordResultTest {
    private WordResult result;

    @Test
    public void shouldCreateSuccessResultWithMessageAndObjectTest() {
        // given
        final String message = generateString();
        final List<Word> wordList = singletonList(defaultWord());

        // when
        result = success(message, wordList);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
        assertThat(result.getWordList()).isEqualTo(wordList);
    }

    @Test
    public void shouldCreateFailResultWithMessageAndObjectTest() {
        // given
        final String message = generateString();

        // when
        result = WordResult.fail(message);

        // then
        assertThat(result.isFail()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
    }

    @Test
    public void shouldUpdateMessageTest() {
        // given
        final String test = "Test";
        final List<Word> wordList = singletonList(defaultWord());

        // when
        result = WordResult.fail();
        result.setSuccess();
        result.setMessage(null);

        // then
        assertThat(result.getMessage()).isEqualTo("Unknown");

        // when
        result.setMessage(test);
        result.setWordList(wordList);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isEqualTo(test);
        assertThat(result.getWordList()).isEqualTo(singletonList(defaultWord()));

    }
}