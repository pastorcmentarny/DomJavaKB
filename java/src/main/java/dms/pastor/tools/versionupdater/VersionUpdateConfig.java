package dms.pastor.tools.versionupdater;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.ValidatorUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class VersionUpdateConfig {


    public static String getPathFor(String what, String withPrefix) {
        ValidatorUtils.validateIfNotEmpty(what);
        ValidatorUtils.validateIfNotEmpty(withPrefix);
        String path = withPrefix + "\\" + what + "\\build.gradle";

        if (Files.exists(Paths.get(path))) {
            return path;
        }
        throw new SomethingWentWrongException("Please use spellchecker, before you waste CPU cycles on typing gibberish like: " + path);

    }


}
