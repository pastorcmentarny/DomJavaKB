package dms.pastor.tools.chinese;

import dms.pastor.domain.Result;
import dms.pastor.tools.chinese.validator.Word;
import lombok.Setter;

import java.util.List;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.util.Collections.emptyList;

/**
 * Author Dominik Symonowicz
 * Created 18/10/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@Setter
public final class WordResult extends Result<List<Word>> {

    private List<Word> wordList;

    private WordResult(boolean success, String message, List<Word> wordList) {
        super(success, message);
        this.wordList = wordList;
    }

    public static WordResult success(String message, List<Word> wordList) {
        return new WordResult(true, message, wordList);
    }

    public static WordResult fail() {
        return new WordResult(false, "Fail", emptyList());
    }

    public static WordResult fail(String message) {
        return new WordResult(false, message, emptyList());
    }


    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public List<Word> getWordList() {
        return wordList;
    }

    @Override
    public String toString() {
        return "Result{" +
                "\n\tsuccess: " + isSuccess() +
                "\n\tmessage: '" + getMessage() + '\'' +
                (wordList != null ? "\n\thasItem: " + wordList : EMPTY_STRING) +
                "\n}";
    }


}
