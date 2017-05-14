package dms.pastor.tools.chinese.topinyin;

import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.StringUtils;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
        ArrayList<String> types = new ArrayList<>();
        for (PseudoPinyinType pseudoPinyinType : PseudoPinyinType.values()) {
            types.add(pseudoPinyinType.name().toLowerCase());
        }

        return StringUtils.toString(types);
    }

    public static Converter getConverterFor(String converterName) {
        switch (PseudoPinyinType.valueOf(converterName.toUpperCase())) {
            case NUMBER:
                return new NumberConverter();
            case CHARACTER:
                throw new NotImplementYetException();
            default:
                throw new SomethingWentWrongException("There is no converter for " + converterName);

        }
    }
}
