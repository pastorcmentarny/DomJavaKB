package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DummyImporter implements Importer<List<Word>> {
    @Override
    public Result<List<Word>> importDictionary(String source, String[] requestedCategories) {
        List<Word> wordList = new ArrayList<>();
        wordList.add(Word.defaultWord());
        return new Result<>(true, "Dummy", wordList);
    }
}
