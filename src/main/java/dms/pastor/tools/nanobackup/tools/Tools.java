package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author Dominik Symonowicz ( dominik.symonowicz@thebookpeople.co.uk )
 * 01-Feb-2012 09:42:43 UTF-8
 */
public class Tools {
    public static final String EMPTY = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(Tools.class);
    //Settings settings = Settings.getSettings();
    private static char[] charArray = new char[36];

    public static void exitProgramOnRequest() {
        Settings settings = Settings.getSettings();
        if (settings.isExitAfterBackup()) {
            System.exit(0);
        }
    }

    /**
     * Gives currect time in format yyyyMMdd-HHmm
     *
     * @return date with time
     */
    public static String getCurrentDateWithTime() {
        String temp;
        Date date = new Date();
        DateFormat dfDate = new SimpleDateFormat("yyyyMMdd-HHmm", Locale.getDefault());
        temp = dfDate.format(date);
        LOGGER.debug("Program:\tCurrent date and  time used for sitemap is:  " + temp);
        return temp;
    }

    /**
     * Gives currect time in format yyyyMMdd-HHmm
     *
     * @return date with time
     */
    public static String getCurrentTime() {
        String temp;
        Date date = new Date();
        DateFormat dfDate = new SimpleDateFormat("HHmm", Locale.getDefault());
        temp = dfDate.format(date);
        LOGGER.debug("Program:\tCurrent date and  time used for sitemap is:  " + temp);
        return temp;
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
                LOGGER.warn("Prgoram was unable to shutdown OS");
            }
        }
    }

    /**
     * Generate random color.
     *
     * @return Random dark color
     */
    public static Color getRandomColor() {
        Random rrgb = new Random();
        return new Color(rrgb.nextInt(128), rrgb.nextInt(128), rrgb.nextInt(128));
    }

    /**
     * Changes status to Warning,if is not
     *
     * @param result status
     */
    public static void changeToYelloStatus(List<String> result) {
        if (!result.get(0).equalsIgnoreCase("ERROR")) {
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

    public static String[] genArray() {
        populateCharArray();
        SecureRandom random = new SecureRandom();
        char currChar;
        String[] s = new String[random.nextInt(4000) + 1000];
        for (int i = 0; i < s.length; i++) {
            s[i] = "";
            for (int j = 0; j < random.nextInt(49) + 1; j++) {
                currChar = charArray[random.nextInt(35)];
                if (currChar == ' ') {
                    j--;
                    continue;
                }
                s[i] += currChar;
            }
        }
        return s;
    }

    public static void populateCharArray() {
        int j = 0;

        for (char i = 'A'; i <= 'Z'; i++, j++)
            charArray[j] = i;

        for (char i = '0'; i <= '9'; i++, j++)
            charArray[j] = i;
    }

    /**
     * based from StringUtils.java and belong to
     *
     * @param string
     * @return
     */
    public static String nullFreeString(String string) {
        return string == null ? EMPTY : string;
    }

}