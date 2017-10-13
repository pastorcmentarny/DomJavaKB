package dms.pastor.tools.lotto;

import java.io.File;

/**
 * Author Dominik Symonowicz
 * Created 03/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class LottoFilePathValidator {

    public static void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Path shouldn't be null or empty");
        }

        if (isFileDoesNotExist(filePath)) {
            throw new IllegalArgumentException("Path is invalid or is not a file");
        }

        if (!new File(filePath).getAbsolutePath().endsWith(".csv")) {
            throw new IllegalArgumentException("It must be a csv file.");
        }
    }

    private static boolean isFileDoesNotExist(String filePath) {
        return !(new File(filePath).exists() && new File(filePath).isFile());
    }

}
