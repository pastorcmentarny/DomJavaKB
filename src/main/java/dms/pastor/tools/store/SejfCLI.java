package dms.pastor.tools.store;

import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SejfCLI {

    public static final String KEY = "key";
    public static final String VALUE = "value";
    private Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(SejfCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";
    private final ValueOperations valueOperations;

    public SejfCLI(ValueOperations valueOperations) {
        this.valueOperations = valueOperations;
    }

    public void menu() {
        boolean showMenu = true;
        while (showMenu) {
            displayAllAvailable();
            try {
                final int option = scanner.nextInt();
                scanner.nextLine();
                if (option == 0) {
                    showMenu = false;
                    scanner.close();
                } else {
                    chooseOption(option);

                }
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish." + e.getMessage(), e);
                scanner.next();
            }
        }
    }

    private void chooseOption(int option) {
        if (option == 1) {
            putValue();
        } else if (option == 2) {
            displayValueFor();
        } else {
            System.out.println(INVALID_CHOICE_MESSAGE);
        }
    }

    private void putValue() {
        final String key = scanner.nextLine();
        ValidatorUtils.validateIfNotEmpty(key, KEY);
        final String value = scanner.nextLine();
        ValidatorUtils.validateIfNotEmpty(value, VALUE);
        valueOperations.addValueForKey(key, value);
    }

    public void displayValueFor() {
        final String key = scanner.nextLine();
        ValidatorUtils.validateIfNotEmpty(key, KEY);
        valueOperations.displayValueFor(key);
    }

    public void displayAllAvailable() {
        System.out.println("1. Add/Modify Value");
        System.out.println("2. Get Value");
        System.out.println("0. Exit");
    }


}
