package dms.pastor.tools.lotto.accuracy.check;

import dms.pastor.tools.lotto.common.NumberToPlayResult;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;

/*
    You send 3 draws
    firstNumber
    SecondNumber
    BothNumbers
    If you one of them then is 1 hit
    if you hit both of them there is 3
 */
class AccuracyCounter {
    private int hit = 0;
    private int total = 0;

    public void updateCount(HotPickDraw currentDraw, NumberToPlayResult numberToPlayResult) {
        if (currentDraw.containsBalls(numberToPlayResult.getFirstNumber(), numberToPlayResult.getSecondNumber())) {
            hit += 3;
        } else {
            if (currentDraw.containsBalls(numberToPlayResult.getFirstNumber())) {
                hit++;
            }
            if (currentDraw.containsBalls(numberToPlayResult.getSecondNumber())) {
                hit++;
            }

        }
        total += 3;
    }

    public double getAccuracy() {
        if (total == 0) {
            return 0;
        }
        return hit * 100 / total;
    }

    public int getHit() {
        return hit;
    }

    public int getTotal() {
        return total;
    }


    @Override
    public String toString() {
        return "AccuracyCounter{" +
                "hit=" + hit +
                ", total=" + total +
                '}';
    }
}
