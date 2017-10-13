package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import org.junit.Test;

import java.util.List;

import static dms.pastor.tools.chinese.validator.Word.noCategories;
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
public class DummyImporterTest {

    @Test
    public void importDictionaryShouldReturnResultWithDefaultWord() {
        // given
        DummyImporter importer = new DummyImporter();

        // when
        final Result result = importer.importDictionary(generateString(), noCategories());

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isNotEmpty();
        List<Word> dictionary = (List<Word>) result.getItem(); //TODO improve it
        assertThat(dictionary.get(0)).isEqualTo(Word.defaultWord());
    }
}