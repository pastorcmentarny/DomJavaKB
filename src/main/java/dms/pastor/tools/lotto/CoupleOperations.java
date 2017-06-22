package dms.pastor.tools.lotto;

import java.util.Set;

/**
 * Author Dominik Symonowicz
 * Created 13/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class CoupleOperations {

    static Set<Couple> deleteDiscardedCouples(Set<Couple> couples, Set<Couple> couplesToDelete) {
        for (Couple couple : couplesToDelete) {
            if (couples.contains(couple)) {
                couples.remove(couple);
            }
        }
        return couples;
    }
}
