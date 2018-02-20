package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
 */
public final class Tools {
    private static final String EMPTY = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(Tools.class);
    private static final char[] charArray = new char[36];
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

    public static String getCurrentTime() {
        String currentTime = LocalTime.now().toString();
        LOGGER.debug("Program:\tCurrent date and  time used for sitemap is:  " + currentTime);
        return currentTime;
    }

    public static void shutdownComputerOnRequest() {
        LOGGER.debug("shutting down computer");
        Settings settings = Settings.getSettings();
        //TODO implement utilities.shutdown after backup
        if (settings.isShutdownAfterBackup()) {
            String shutdownCmd = null;
            String system = System.getProperty("os.name").toLowerCase();
            if (system.contains("windows")) {
                shutdownCmd = "shutdown -s";
            }
            if (system.contains("linux")) {
                String pass = JOptionPane.showInputDialog(null, "Insert password", "password");
                shutdownCmd = "sudo " + pass + " shutdown";
            }
            if (system.contains("Mac OS X")) {
                String pass = JOptionPane.showInputDialog(null, "Insert password", "password");
                shutdownCmd = "sudo " + pass + " shutdown";
            }
            try {
                if (shutdownCmd != null) {
                    Process systemKiller = Runtime.getRuntime().exec(shutdownCmd);
                }
            } catch (IOException ex) {
                LOGGER.warn("Program was unable to shutdown OS");
            }
        }
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
        StringBuilder temp = new StringBuilder("");
        if (status.length > 1) {
            for (int i = 1; i < status.length; i++) {
                temp.append(status[i]);
            }
        }
        JOptionPane.showMessageDialog(null, temp.toString() + settings.displayCurrentSettings("STATUS"), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    //TODO remove it
//    public static String[] generateArray() {
//        populateCharArray();
//        SecureRandom random = new SecureRandom();
//        char currChar;
//        String[] s = new String[random.nextInt(4000) + 1000];
//        for (int i = 0; i < s.length; i++) {
//            s[i] = "";
//            for (int j = 0; j < random.nextInt(49) + 1; j++) {
//                currChar = charArray[random.nextInt(35)];
//                if (currChar == ' ') {
//                    j--;
//                    continue;
//                }
//                s[i] += currChar;
//            }
//        }
//        return s;
//    }

    //TODO remove it or move to utils
//    private static void populateCharArray() {
//        int j = 0;
//
//        for (char i = 'A'; i <= 'Z'; i++, j++)
//            charArray[j] = i;
//
//        for (char i = '0'; i <= '9'; i++, j++)
//            charArray[j] = i;
//    }

}