package dms.pastor.examples.java8.interfaces.defaultmethod;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
interface Formula {

    default double sqrt(int number) {
        return Math.sqrt(number);
    }
}