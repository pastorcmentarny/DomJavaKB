package dms.pastor.tools.chinese.topinyin;

import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.string.ToStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum PseudoPinyinType {
    NUMBER,
    CHARACTER;

    public static boolean contains(String type) {
        for (PseudoPinyinType pseudoType : PseudoPinyinType.values()) {
            if (pseudoType.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotContain(String type) {
        return !contains(type);
    }

    public static String displaySupportedType() {
        List<String> types = new ArrayList<>();
        for (PseudoPinyinType pseudoPinyinType : PseudoPinyinType.values()) {
            types.add(pseudoPinyinType.name().toLowerCase());
        }

        return ToStringUtils.toString(types);
    }

    @SuppressWarnings("UnnecessaryDefault") //default is for new, not supported Converter
    public static Converter getConverterFor(String converterName) {
        return switch (PseudoPinyinType.valueOf(converterName.toUpperCase())) {
            case NUMBER -> new NumberConverter();
            case CHARACTER -> throw new NotImplementYetException();
            default -> throw new SomethingWentWrongException("There is no converter for " + converterName);
        };
    }
}
