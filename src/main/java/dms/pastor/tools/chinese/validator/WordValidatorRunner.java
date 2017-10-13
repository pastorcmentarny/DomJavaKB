package dms.pastor.tools.chinese.validator;

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
 *
 */
class WordValidatorRunner {

    //TODO improve it
    private static final String PATH = "C:\\ds\\projects\\DomLearnsChinese\\res\\raw\\dictionary.txt";

    public static void main(String[] args) {
        InMemoryDictionary dictionary = new InMemoryDictionary(PATH, new FromFileImporter());
        dictionary.load();

        System.out.println("Dictionary Status: " + dictionary.getStatus());
    }
}
