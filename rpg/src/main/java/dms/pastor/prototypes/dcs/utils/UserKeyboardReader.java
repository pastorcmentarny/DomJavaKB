package dms.pastor.prototypes.dcs.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * Created 02/06/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class UserKeyboardReader implements UserInputReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserKeyboardReader.class);
    private final Scanner scanner;

    public UserKeyboardReader() {
        scanner = new Scanner(System.in);
    }

    UserKeyboardReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getIntegerInput() {
        LOGGER.debug("Getting integer input..");
        int integer = 0;
        try {
            integer = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine();
        }
        LOGGER.debug("Value typed: " + integer);

        return integer;
    }
}
