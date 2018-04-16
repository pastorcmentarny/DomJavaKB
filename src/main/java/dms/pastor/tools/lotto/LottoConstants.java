package dms.pastor.tools.lotto;

import java.util.stream.IntStream;

/**
 * Author Dominik Symonowicz
 * Created 26/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class LottoConstants {

    public static final int HOT_PICK_BALL_MINIMUM_VALUE = 1;
    public static final int HOT_PICK_BALL_MAXIMUM_VALUE = 59;
    public static final int[] HOT_PICK_NUMBER_RANGE = IntStream.rangeClosed(HOT_PICK_BALL_MINIMUM_VALUE, HOT_PICK_BALL_MAXIMUM_VALUE).toArray();
    public static final String DASH = "-";
    public static final String NO_RESULT = "We successfully gather no result :)";


    private LottoConstants() {
    } // constant class
}
