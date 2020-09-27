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
        return switch (partOfNumber) {
            case "ten" -> 10;
            case "eleven" -> 11;
            case "twelve" -> 12;
            case "thirteen" -> 13;
            case "fourteen" -> 14;
            case "fifteen" -> 15;
            case "sixteen" -> 16;
            case "seventeen" -> 17;
            case "eighteen" -> 18;
            case "nineteen" -> 19;
            default -> null;
        };
    }

    @SuppressWarnings("MagicNumber")
    private static Integer getTensOfNumber(String partOfNumber) {
        return switch (partOfNumber) {
            case "twenty" -> 20;
            case "thirty" -> 30;
            case "forty" -> 40;
            case "fifty" -> 50;
            case "sixty" -> 60;
            case "seventy" -> 70;
            case "eighty" -> 80;
            case "ninety" -> 90;
            default -> null;
        };
    }

    private static Integer getIntegerInRange0To9(String partOfNumber) {
        return switch (partOfNumber) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "zero" -> 0;
            default -> null;
        };
    }
}
