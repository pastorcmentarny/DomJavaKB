package dms.pastor.examples.java12;

import dms.pastor.ExampleRunner;
import org.junit.jupiter.api.Test;

import static dms.pastor.examples.java12.NewFeaturesInJava12.*;

/**
 * Author Dominik Symonowicz
 * Created 28/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NewFeaturesInJava12Test implements ExampleRunner {

    @Test
    @Override
    public void runExamples() {
        System.out.println(returnsClassForAnArrayType());
        System.out.println(stringIntentMethod());
        System.out.println(compactNumberFormat());

    }
}