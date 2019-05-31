package dms.pastor.tools.chinese.validator;

import dms.pastor.utils.ValidatorUtils;
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
 * while they are loaded to rpg database in Doms learn Chinese from file
 * This is slightly modified version of Word class from my game Dom Learn Chinese
 * Validator is here not in App due fact that testing in Android is pain in the ass
 */
final class WordValidatorRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordValidatorRunner.class);

    private WordValidatorRunner() {
    }

    public static void main(String[] args) {
        String path = getPath(args);
        LOGGER.info("Validating rpg in  this path: " + path);
        InMemoryDictionary dictionary = new InMemoryDictionary(path, new FromFileImporter());
        dictionary.load();
        LOGGER.info("Dictionary Status: " + dictionary.getStatus());
    }


    private static String getPath(String[] args) {
        //return //copy path here if you are feel lazy today like everyday
        ValidatorUtils.validateIfArrayHasSizeOf(1, args, "main's args");
        return args[0];
    }
}
