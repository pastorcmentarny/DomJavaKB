package dms.pastor.tools.lotto.hotpick;

import dms.pastor.tools.lotto.BallCount;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dms.pastor.utils.CollectionsUtils.convertListToIntArray;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CoupleOperations {

    private CoupleOperations() {
    }

    public static Set<Couple> findAllCouplesThatContainsThisBalls(Set<Couple> remainingCouples, int[] balls) {
        Set<Couple> couplesWithMatchedBalls = new HashSet<>();

        for (Couple couple : remainingCouples) {
            if (couple.contains(balls)) {
                couplesWithMatchedBalls.add(couple);
            }
        }
        return couplesWithMatchedBalls;
    }

    public static Set<Couple> findAllCouplesThatContainsThisBalls(Set<Couple> remainingCouples, BallCount[] couples) {
        Set<Couple> couplesWithMatchedBalls = new HashSet<>();
        List<Integer> balls = new ArrayList<>();
        for (BallCount ballCount : couples) {
            balls.addAll(ballCount.getBallNumbers());
        }

        for (Couple couple : remainingCouples) {
            if (couple.contains(convertListToIntArray(balls))) {
                couplesWithMatchedBalls.add(couple);
            }
        }
        return couplesWithMatchedBalls;
    }

    public static Set<Couple> deleteDiscardedCouples(Set<Couple> couples, Set<Couple> couplesToDelete) {
        for (Couple couple : couplesToDelete) {
            couples.remove(couple);
        }
        return couples;
    }

    //TODO replace with better collections later
    public static Set<Couple> removeAllCouplesThatDoNotContainsNumbers(Set<Couple> couples, int[] numbersMustBeInCouples) {
        Set<Couple> coupleSet = new HashSet<>();
        for (Couple couple : couples) {
            if (couple.containsAll(numbersMustBeInCouples)) {
                boolean s = false;
                boolean l = false;
                for (int i : numbersMustBeInCouples) {
                    if (i == couple.getSmallerNumber()) {
                        s = true;
                    }
                    if (i == couple.getLargerNumber()) {
                        l = true;
                    }
                }
                if (l && s) {
                    System.out.println(couple.toString());
                    coupleSet.add(couple);
                }
            }
        }
        return coupleSet;
    }
}
