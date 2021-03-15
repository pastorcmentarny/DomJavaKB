package dms.pastor.examples.java8.interfaces.defaultmethod;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CubicFormula implements Formula {

    public double calculate(final int number) {
        return sqrt(number) * number;

    }
}
