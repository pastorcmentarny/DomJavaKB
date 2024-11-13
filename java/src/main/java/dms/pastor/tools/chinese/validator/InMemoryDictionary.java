package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dms.pastor.tools.chinese.validator.Word.noCategories;

/**
 * Author Dominik Symonowicz
 * Created 10/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class InMemoryDictionary {
    private static final Logger LOGGER = LoggerFactory.getLogger(FromFileImporter.class);

    private final Importer<List<Word>> fromFileImporter;
    private final String source;

    private Result<List<Word>> dictionaryStatus = new Result<>(false,"Unknown state.");
    private List<Word> wordsList = new ArrayList<>();

    public InMemoryDictionary(String source, Importer<List<Word>> importer) {
        this.source = source;
        this.fromFileImporter = importer;
    }

    public void load() {
        dictionaryStatus = fromFileImporter.importDictionary(source, noCategories());
        if (dictionaryStatus.isSuccess()) {
            LOGGER.info(dictionaryStatus.getMessage());
            if (dictionaryStatus.getItem() != null) {
                setWordListFromResult(dictionaryStatus.getItem());
            }
            dictionaryStatus.setItem(null);
        }
    }

    private void setWordListFromResult(List<Word> wordListAsObject) {
        if (Objects.nonNull(wordListAsObject)) {
            wordsList = wordListAsObject;
        } else {
            dictionaryStatus = new Result<>(false,"Unable to retrieve word list.");
            LOGGER.error("Unable to retrieve word list.");
        }
    }

    public String getStatus() {
        return dictionaryStatus.isSuccess() ? "OK" : "ERROR (" + dictionaryStatus.getMessage() + ")";
    }

    public Word getWordFromDictionary(int id) {
        for (Word word : wordsList) {
            if (word.getId() == id) {
                return word;
            }
        }
        LOGGER.warn("Word not found in rpg for id: " + id);
        return Word.noWord();
    }

}
