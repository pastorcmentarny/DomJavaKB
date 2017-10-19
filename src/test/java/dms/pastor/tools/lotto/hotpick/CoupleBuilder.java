package dms.pastor.tools.lotto.hotpick;

import static dms.pastor.tools.lotto.hotpick.Couple.createWithOrderedNumbers;
import static dms.pastor.utils.randoms.RandomDataGenerator.MAX_SMALL_VALUE_RANGE;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomInteger;

/**
 * Author Dominik Symonowicz
 * Created 13/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CoupleBuilder {

    private int smallerNumber = randomInteger(MAX_SMALL_VALUE_RANGE);
    private int largerNumber = MAX_SMALL_VALUE_RANGE + 1;

    private CoupleBuilder() {
    }

    public static CoupleBuilder coupleBuilder() {
        return new CoupleBuilder();
    }

    public Couple build() {
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
