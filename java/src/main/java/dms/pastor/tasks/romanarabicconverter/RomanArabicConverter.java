package dms.pastor.tasks.romanarabicconverter;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class RomanArabicConverter {

    int convertRomanToArabic(String number) {
        if (RomanNumberValidator.isNotValidRomanNumber(number)) {
            throw new IllegalArgumentException("Invalid Roman Numeral");
        }

        char[] romanNumber = number.toCharArray();
        int arabicNumber = 0;

        for (int i = 0; i < romanNumber.length; i++) {
            if (isSubtractiveNotationNeeded(i, romanNumber)) {
                arabicNumber -= RomanNumerals.getArabicForRoman(romanNumber[i]);
            } else {
                arabicNumber += RomanNumerals.getArabicForRoman(romanNumber[i]);
            }
        }
        return arabicNumber;
    }

    private boolean isSubtractiveNotationNeeded(int i, char[] romanNumber) {
        if (i + 1 >= romanNumber.length) {
            return false;
        }
        return switch (romanNumber[i]) {
            case 'I' -> romanNumber[i + 1] != 'I';
            case 'X' -> (romanNumber[i + 1] == 'L' || romanNumber[i + 1] == 'C' || romanNumber[i + 1] == 'D');
            case 'C' -> romanNumber[i + 1] == 'D' || romanNumber[i + 1] == 'M';
            default -> false;
        };
    }

    String convertArabicToRoman(int number) {
        if (!RomanNumberValidator.isIntCanBeRomanNumber(number)) {
            throw new IllegalArgumentException("This number cannot be convert to roman.Allowed range is 1-3999");
        }
        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        int numberLeft = number;

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.M, RomanNumerals.C);

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.D, RomanNumerals.C);

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.C, RomanNumerals.X);

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.L, RomanNumerals.X);

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.X, RomanNumerals.I);

        numberLeft = getNumberLeft(numberLeft, sb, RomanNumerals.V, RomanNumerals.I);

        sb.append("I".repeat(Math.max(0, numberLeft)));

        return sb.toString();
    }

    private int getNumberLeft(int number, StringBuilder sb, RomanNumerals numerals, RomanNumerals previous) {
        int amount = number / numerals.arabic();
        int numberLeft = number % numerals.arabic();
        int previousNumber = numerals.arabic() - previous.arabic();
        sb.append(String.valueOf(numerals.roman()).repeat(Math.max(0, amount)));

        if (numberLeft / previousNumber == 1) {
            sb.append(previous.name()).append(numerals.name());
            numberLeft -= previousNumber;
        }
        return numberLeft;
    }

}
