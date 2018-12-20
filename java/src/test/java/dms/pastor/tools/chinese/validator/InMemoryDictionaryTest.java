package dms.pastor.tools.chinese.validator;

import org.junit.Test;

import static dms.pastor.tools.chinese.validator.Word.defaultWord;
import static dms.pastor.tools.chinese.validator.Word.noWord;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InMemoryDictionaryTest {

    @Test
    public void loadShouldLoadDictionaryWithOKStatus() {
        // given
        InMemoryDictionary dictionary = new InMemoryDictionary(generateString(), new DummyImporter());
        // when
        dictionary.load();
        // then
        assertThat(dictionary.getStatus()).isEqualTo("OK");
    }

    @Test
    public void loadShouldLoadDictionaryWithError() {
        // given
        InMemoryDictionary dictionary = new InMemoryDictionary(generateString(), new FromFileImporter());
        // when
        dictionary.load();
        // then
        assertThat(dictionary.getStatus()).isEqualTo("ERROR (File to rpg not found)");
    }

    @Test
    public void getWordFromDictionaryShouldGetWord() {
        // given
        InMemoryDictionary dictionary = new InMemoryDictionary(generateString(), new DummyImporter());
        dictionary.load();
        // when
        final Word result = dictionary.getWordFromDictionary(292);
        // then
        assertThat(result).isEqualTo(defaultWord());
    }

    @Test
    public void getWordFromDictionaryShouldNotGetWordIfIdDoesNotExists() {
        // given
        InMemoryDictionary dictionary = new InMemoryDictionary(generateString(), new DummyImporter());
        dictionary.load();
        // when
        final Word result = dictionary.getWordFromDictionary(10);
        // then
        assertThat(result).isEqualTo(noWord());
    }
}