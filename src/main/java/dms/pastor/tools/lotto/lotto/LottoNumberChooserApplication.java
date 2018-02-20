package dms.pastor.tools.lotto.lotto;

import java.util.stream.IntStream;

/**
 * Author Dominik Symonowicz
 * Created 14/01/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class LottoNumberChooserApplication {

    private LottoNumberChooserApplication() {
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 59).forEach(System.out::println);
        LottoNumberToPlayGenerator generator = new LottoNumberToPlayGenerator();
        System.out.println(generator.generateNumbersToPlay());
    }
}
