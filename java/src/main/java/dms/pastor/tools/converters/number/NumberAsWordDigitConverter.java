package dms.pastor.tools.converters.number;

import java.util.Objects;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

final class NumberAsWordDigitConverter {

    private static final String SPLIT_CHARACTER = " ";

    private NumberAsWordDigitConverter() {
    }

    public static int toDigit(String numberAsString) {
        validateIfNotEmpty(numberAsString, "number as text");
        final String[] number = numberAsString.toLowerCase().split(SPLIT_CHARACTER);
        int total = 0;
        for (String partOfNumber : number) {
            if (!"and".equalsIgnoreCase(partOfNumber)) {
                total += getNumberFor(partOfNumber);
            }
        }
        return total;
    }

    private static int getNumberFor(String partOfNumber) {

        if ("hundred".equals(partOfNumber)) {
            return 100;
        }

        Integer tensOfNumber = getTensOfNumber(partOfNumber);
        if (tensOfNumber != null) return tensOfNumber;

        Integer integer = getIntegerInRangeFrom11To19(partOfNumber);
        if (Objects.nonNull(integer)) return integer;

        integer = getIntegerInRange0To9(partOfNumber);
        if (Objects.nonNull(integer)) return integer;

        throw new IllegalArgumentException(partOfNumber + " is not a valid number word.");
    }

    @SuppressWarnings("MagicNumber")
    private static Integer getIntegerInRangeFrom11To19(String partOfNumber) {
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
        return null;
    }

    @SuppressWarnings("MagicNumber")
    private static Integer getTensOfNumber(String partOfNumber) {
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
        return null;
    }

    private static Integer getIntegerInRange0To9(String partOfNumber) {
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
        return null;
    }
}
