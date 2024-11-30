package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;

public class PolishUtils {
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final int RANGE = 999;

    public static String getPolishWordFromNumber(int number) {
        throwExceptionIfOutOfRange(number);

        String result = "";
        if (number == 0) {
            return "zero";
        }

        result = setMinusIfNegativeNumber(number, result);

        number = Math.abs(number);

        int sets = number / 100;
        if (sets > 0) {
            result += getHundredsNumber(sets) + SPACE;
        }
        number -= sets * 100;


        if (number < 20 && number > 10) {
            result = result.trim();
            result += SPACE + getNumberBetween11And19(number);
            return result.trim();
        }

        int teens = number / 10;
        if (teens > 0) {
            result += getTenthNumberFrom(teens) + SPACE;
        }

        number -= teens * 10;

        var singles = number % 10;
        result += getSingleNumberFrom(Math.abs(singles));
        return result.trim();
    }

    private static String setMinusIfNegativeNumber(int number, String result) {
        if (number < 0) {
            result += "minus ";
        }
        return result;
    }

    private static void throwExceptionIfOutOfRange(int number) {
        if (number > RANGE || number < -RANGE) {
            throw new SomethingWentWrongException("Out of range! Supported range is from -" + RANGE + " to " + RANGE);
        }
    }

    private static String getHundredsNumber(int setne) {
        return switch (setne) {
            case 1 -> "sto";
            case 2 -> "dwieście";
            case 3 -> "trzysta";
            case 4 -> "czterysta";
            case 5 -> "pięćset";
            case 6 -> "sześćset";
            case 7 -> "siedemset";
            case 8 -> "osiemset";
            case 9 -> "dziewięćset";
            default -> EMPTY;
        };
    }

    private static String getNumberBetween11And19(int number) {
        return switch (number) {
            case 11 -> "jedenaście";
            case 12 -> "dwanaście";
            case 13 -> "trzynaście";
            case 14 -> "czternaście";
            case 15 -> "piętnaście";
            case 16 -> "szesnaście";
            case 17 -> "siedemnaście";
            case 18 -> "osiemnaście";
            case 19 -> "dziewiętnaście";
            default -> EMPTY;
        };
    }

    private static String getTenthNumberFrom(int number) {
        return switch (number) {
            case 1 -> "dziesięć";
            case 2 -> "dwadzieścia";
            case 3 -> "trzydzieści";
            case 4 -> "czterdzieści";
            case 5 -> "pięćdziesiąt";
            case 6 -> "sześćdziesiąt";
            case 7 -> "siedemdziesiąt";
            case 8 -> "osiemdziesiąt";
            case 9 -> "dziewięćdziesiąt";
            default -> EMPTY;
        };

    }

    private static String getSingleNumberFrom(int number) {
        return switch (number) {
            case 1 -> "jeden";
            case 2 -> "dwa";
            case 3 -> "trzy";
            case 4 -> "cztery";
            case 5 -> "pięć";
            case 6 -> "sześć";
            case 7 -> "siedem";
            case 8 -> "osiem";
            case 9 -> "dziewięć";
            default -> EMPTY;
        };

    }
}
