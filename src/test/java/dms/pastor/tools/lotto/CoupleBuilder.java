package dms.pastor.tools.lotto;

import static dms.pastor.tools.lotto.Couple.createWithOrderedNumbers;
import static dms.pastor.utils.RandomDataGenerator.*;

/**
 * Author Dominik Symonowicz
 * Created 13/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CoupleBuilder {
    private int smallerNumber = randomInteger(MAX_SMALL_VALUE);
    private int largerNumber = 11;

    private CoupleBuilder(){}

    public static CoupleBuilder coupleBuilder(){
        return new CoupleBuilder();
    }

    public Couple build(){
        return createWithOrderedNumbers(smallerNumber, largerNumber);
    }

    public CoupleBuilder smallerNumber(int smallerNumber) {
        this.smallerNumber = smallerNumber;
        return this;
    }

    public CoupleBuilder largerNumber(int largerNumber) {
        this.largerNumber = largerNumber;
        return this;
    }
}
