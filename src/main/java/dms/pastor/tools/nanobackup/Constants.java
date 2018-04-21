package dms.pastor.tools.nanobackup;

import java.io.File;

/**
 * Author Dominik Symonowicz
 * Created 21/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Constants {
    public static final String DEFAULT_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "nanobackup" + File.separator;
    public static final String DATA_PATH = DEFAULT_PATH + "data" + File.separator;
    public static final String MESSAGE_PATH = DATA_PATH + File.separator + "message.properties";
    public static final String SETTINGS_PATH = DATA_PATH + "settings.properties";
    public static final String RECENT_SRC_PATHS_FILE = DATA_PATH + "recentSrcPaths.nbd";
    public static final String RECENT_DEST_PATHS_FILE = DATA_PATH + "recentDestPaths.nbd";
    public static final String QUICK_MODE_FILENAME = "quickMode.nbd";

    private Constants() {
    }
}
