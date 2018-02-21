package dms.pastor.tools.lotto.hotpick;

import java.util.Objects;

import static dms.pastor.utils.ValidatorUtils.validateTwoIntsNotEqual;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Couple {

    private int smallerNumber;
    private int largerNumber;

    private Couple(int smallerNumber, int largerNumber) {
        assignValuesInOrder(smallerNumber, largerNumber);
    }

    static Couple createWithOrderedNumbers(int smallerNumber, int largerNumber) {
        validateTwoIntsNotEqual(smallerNumber, largerNumber);
        return new Couple(smallerNumber, largerNumber);
    }

    private void assignValuesInOrder(int smallerNumber, int largerNumber) {
        if (smallerNumber > largerNumber) {
            this.smallerNumber = largerNumber;
            this.largerNumber = smallerNumber;
        } else {
            this.smallerNumber = smallerNumber;
            this.largerNumber = largerNumber;
        }
        validateTwoIntsNotEqual(smallerNumber, largerNumber);
    }

    //TODO rename it to containsAny
    public boolean contains(int... numbers) {
        for (int number : numbers) {
            if (smallerNumber == number || largerNumber == number) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(int... numbers) {
        boolean hasSmallerNumber = false;
        boolean hasLargerNumber = false;
        for (int number : numbers) {
            if (smallerNumber == number) {
                hasSmallerNumber = true;
            }
            if (largerNumber == number) {
                hasLargerNumber = true;
            }
        }
        return hasSmallerNumber && hasLargerNumber;
    }

    public boolean isNotContainNumbers(int[] numbersMustHave) {
        for (int number : numbersMustHave) {
            if (number == smallerNumber || number == largerNumber) {
                return false;
            }
        }
        return true;
    }

    public int getSmallerNumber() {
        return smallerNumber;
    }

    public int getLargerNumber() {
        return largerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Couple couple = (Couple) o;
        return getSmallerNumber() == couple.getSmallerNumber() &&
                getLargerNumber() == couple.getLargerNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSmallerNumber(), getLargerNumber());
    }

    @Override
    public String toString() {
        return format("Couple{smallerNumber=%d, largerNumber=%d}", smallerNumber, largerNumber);
    }

}
