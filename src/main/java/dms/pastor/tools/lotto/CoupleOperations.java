package dms.pastor.tools.lotto;

import java.util.Set;

/**
 * Author Dominik Symonowicz
 * Created 13/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CoupleOperations {
    public static Set<Couple> deleteDiscardedCouples(Set<Couple> couples, Set<Couple> couplesToDelete) {
        for (Couple couple : couplesToDelete) {
            if (couples.contains(couple)) {
                couples.remove(couple);
            }
        }
        return couples;
    }
}
