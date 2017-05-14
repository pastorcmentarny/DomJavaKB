package dms.pastor.tools.chinese.topinyin;

import dms.pastor.domain.exception.SomethingWentWrongException;

import static dms.pastor.tools.chinese.topinyin.PseudoPinyinType.displaySupportedType;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ToPinyinApplication {

    public static void main(String[] args) {
        validateInputArgs(args);
        Converter converter = PseudoPinyinType.getConverterFor(args[0]);
        final String result = converter.convertToPinyin(args[1]);
        System.out.println(result);
    }


    private static void validateInputArgs(String[] inputArguments) {
        if (inputArguments == null) {
            throw new IllegalArgumentException("Input arguments cannot be null.");
        }

        if (inputArguments.length != 2) {
            throw new IllegalArgumentException("It should contains 2 arguments (type of pinyin (" + displaySupportedType() + ") and text.");
        }

        if (PseudoPinyinType.isNotContain(inputArguments[0])) {
            throw new SomethingWentWrongException("Invalid conversation type(can be: " + displaySupportedType() + ')');
        }

        if (inputArguments[1] == null || inputArguments[1].isEmpty() || inputArguments[1].length() < 2) {
            throw new IllegalArgumentException("Text cannot be null or empty. It must be at least 2 characters or more.");
        }
    }
}
