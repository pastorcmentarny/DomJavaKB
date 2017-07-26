package dms.pastor.tools.converters.number;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

public class NumberAsWordDigitConverter {

    private static final String SPLIT_CHARACTER = " ";

    public static int toDigit(String numberAsString) {
        validateIfNotEmpty(numberAsString, "number as text");
        final String[] number = numberAsString.toLowerCase().split(SPLIT_CHARACTER);
        int total = 0;
        for (String partOfNumber : number) {
            total += getNumberFor(partOfNumber);
        }
        return total;
    }

    @SuppressWarnings("MagicNumber") //as they are meaningful in this context
    private static int getNumberFor(String partOfNumber) {

        switch (partOfNumber) {
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
        }

        switch (partOfNumber) {
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
        }

        switch (partOfNumber) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "zero":
                return 0;
        }

        throw new IllegalArgumentException(partOfNumber + " is not a valid number word.");
    }
}
