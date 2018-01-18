package dms.pastor.tools.lotto.common;


import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

public final class NumberToPlayResultBuilder {
    private int firstNumber = randomPositiveInteger(1, 59);
    private int secondNumber = randomPositiveInteger(1, 59);

    private NumberToPlayResultBuilder() {
    }

    public static NumberToPlayResultBuilder numberToPlayResultBuilder() {
        return new NumberToPlayResultBuilder();
    }

    public NumberToPlayResult build() {
        return new NumberToPlayResult(firstNumber, secondNumber);
    }

    public NumberToPlayResultBuilder firstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
        return this;
    }

    public NumberToPlayResultBuilder secondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
        return this;
    }
}