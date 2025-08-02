package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class DummyImporter implements Importer<List<Word>> {
    @Override
    public Result<List<Word>> importDictionary(String source, String[] requestedCategories) {
        List<Word> wordList = new ArrayList<>();
        wordList.add(Word.defaultWord());
        return new Result<>(true, "Dummy", wordList);
    }
}
