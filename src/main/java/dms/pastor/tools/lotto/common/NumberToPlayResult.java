package dms.pastor.tools.lotto.common;

public class NumberToPlayResult {
    private final int firstNumber;
    private final int secondNumber;

    public NumberToPlayResult(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }
}
