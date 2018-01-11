package dms.pastor.tools.lotto.accuracy.check;

import java.text.DecimalFormat;
import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

public class Result {
    private final double accuracy;
    private final int balance;

    public Result(double accuracy, int balance) {
        this.accuracy = accuracy;
        this.balance = balance;
    }


    public double getAccuracy() {
        return accuracy;
    }

    public int getBalance() {
        return balance;
    }

    public int getBalanceInPennies() {
        return balance;
    }

    public String getBalanceInPounds() {
        final StringBuilder balanceInPounds = new StringBuilder(EMPTY_STRING);
        if (balance < 0) {
            balanceInPounds.append("- ");
        }
        balanceInPounds.append("£");
        final DecimalFormat df = new DecimalFormat("#0.00");
        double value = balance / 100d;
        balanceInPounds.append(df.format(Math.abs(value)));
        return balanceInPounds.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Double.compare(result.getAccuracy(), getAccuracy()) == 0 &&
                getBalance() == result.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccuracy(), getBalance());
    }

    @Override
    public String toString() {
        return "Result{" +
                "accuracy=" + accuracy +
                ", balance=" + balance +
                '}';
    }
}
