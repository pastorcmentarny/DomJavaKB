package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.tools.chinese.validator.Word.noCategories;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FromFileImporterTest {

    @Disabled //FIXME
    @Test
    public void importDictionaryShouldLoadDictionaryFromFile() {
        // given
        String path = BASE_PATH + "word" + File.separator + "validDictionary.txt";
        Importer<List<Word>> importer = new FromFileImporter();

        // when
        final Result<List<Word>> result = importer.importDictionary(path, noCategories());

        // then
        assertThat(result.isSuccess()).isTrue();
        final List<Word> wordList = result.getItem();
        assertThat(wordList).hasSize(10);

    }

    @Test
    public void importDictionaryShouldNotLoadDictionaryFromFileIfFileHasEntryWithValidationErrors() {
        // given
        String path = BASE_PATH + "word" + File.separator + "invalidDictionary.txt";
        Importer<List<Word>> importer = new FromFileImporter();

        // when
        final Result<List<Word>> result = importer.importDictionary(path, noCategories());

        // then
        assertThat(result.isFail()).isTrue();
        assertThat(result.getMessage()).isEqualTo("Error at line: 0 caused by For input string: \"x\" in ;;x;;x;;X;;WRONG;;ENTRY;;x;;~~;;e;;x;;x;;");
        assertThat(result.getItem()).isEmpty();

    }
}