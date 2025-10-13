package dms.pastor.utils;

import static dms.pastor.utils.StringUtils.isStringBlank;

public class DataUtils {

    public static String maskToken(String token) {
        if (isStringBlank(token)) {
            return "";
        }

        final int tokenSize = token.length();

        if (tokenSize < 8) {
            return "*".repeat(tokenSize);
        }

        return token.substring(0, 2) + "****" + token.substring(tokenSize - 4);
    }
}
