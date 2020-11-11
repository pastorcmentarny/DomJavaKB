package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created: 01-Feb-2012 09:42:43
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
public final class Tools {
    private static final Logger LOGGER = LoggerFactory.getLogger(Tools.class);
    private static final int HALF_OF_MAX_RGB_VALUE = 128;

    private Tools() {
    }

    public static void exitProgramOnRequest() {
        Settings settings = Settings.getSettings();
        if (settings.isExitAfterBackup()) {
            System.exit(0);
        }
    }

    public static String getCurrentDateWithTime() {
        return LocalDateTime.now().toString();
    }

    static String getCurrentTime() {
        String currentTime = LocalTime.now().toString();
        LOGGER.debug("Program:\tCurrent date and  time used for sitemap is:  " + currentTime);
        return currentTime;
    }


    public static Color getRandomColor() {
        Random randomColor = new Random();
        return new Color(randomColor.nextInt(HALF_OF_MAX_RGB_VALUE), randomColor.nextInt(HALF_OF_MAX_RGB_VALUE), randomColor.nextInt(HALF_OF_MAX_RGB_VALUE));
    }

    public static void changeToYellowStatus(List<String> result) {
        if (!"ERROR".equalsIgnoreCase(result.get(0))) {
            result.set(0, "WARNING");
        }
    }

    public static void showStatus(String[] status) {
        Settings settings = Settings.getSettings();
        StringBuilder temp = new StringBuilder();
        if (status.length > 1) {
            for (int i = 1; i < status.length; i++) {
                temp.append(status[i]);
            }
        }
        JOptionPane.showMessageDialog(null, temp.toString() + settings.displayCurrentSettings("STATUS"), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

}
