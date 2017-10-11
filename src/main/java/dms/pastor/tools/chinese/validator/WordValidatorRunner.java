package dms.pastor.tools.chinese.validator;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class WordValidatorRunner {

    public static final String PATH = "C:\\ds\\projects\\DomLearnsChinese\\res\\raw\\dictionary.txt";

    public static void main(String[] args) {
        InMemoryDictionary dictionary = new InMemoryDictionary(PATH);
        dictionary.load();

        System.out.println("Dictionary Status: " + dictionary.getStatus());
    }
}
