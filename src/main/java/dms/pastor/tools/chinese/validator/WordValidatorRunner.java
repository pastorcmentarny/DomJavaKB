package dms.pastor.tools.chinese.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This tool is used to validate words
 * while they are loaded to dictionary database in Doms learn Chinese from file
 * This is slightly modified version of Word class from my game Dom Learn Chinese
 * Validator is here not in App due fact that testing in Android is pain in the ass
 */
final class WordValidatorRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordValidatorRunner.class);

    //TODO improve it
    private static final String PATH = "C:\\ds\\projects\\DomLearnsChinese\\res\\raw\\dictionary.txt";

    private WordValidatorRunner() {
    }

    public static void main(String[] args) {
        LOGGER.info("Validating dictionary in  this path: " + PATH);
        InMemoryDictionary dictionary = new InMemoryDictionary(PATH, new FromFileImporter());
        dictionary.load();
        LOGGER.info("Dictionary Status: " + dictionary.getStatus());
    }
}
