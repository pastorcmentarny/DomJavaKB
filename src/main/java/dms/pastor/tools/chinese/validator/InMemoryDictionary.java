package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dms.pastor.domain.Result.fail;

/**
 * Author Dominik Symonowicz
 * Created 10/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InMemoryDictionary {
    private static final Logger LOGGER = LoggerFactory.getLogger(FromFileImporter.class);

    private final Importer fromFileImporter = new FromFileImporter();
    private final String source;

    private Result dictionaryStatus = fail("Unknown state.");
    private List<Word> wordsList = new ArrayList<>();

    public InMemoryDictionary(String source) {
        this.source = source;
    }

    public void load() {
        dictionaryStatus = fromFileImporter.importDictionary(source, null);
        if (dictionaryStatus.isSuccess()) {
            setWordListFromResult(dictionaryStatus.getItem());
            dictionaryStatus.setItem(null);
        }
    }

    private void setWordListFromResult(Object wordListAsObject) {
        if (Objects.nonNull(wordListAsObject) && wordListAsObject instanceof ArrayList) {
            wordsList = (List<Word>) wordListAsObject;
        } else {
            dictionaryStatus = fail("Unable to retrive word list.");
            LOGGER.error("Unable to retrive word list.");
        }
    }

    public String getStatus() {
        return dictionaryStatus.isSuccess() ? "OK" : "ERROR (" + dictionaryStatus.getMessage() + ")";
    }

    public Word getWordFromDictionary(int id) {
        id++;
        for (Word word : wordsList) {
            if (word.getId() == id) {
                return word;
            }
        }
        LOGGER.warn("Word not found in dictionary for id:" + id);
        return Word.noWord();
    }

}
