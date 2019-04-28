package dms.pastor.examples.java8.interfaces.defaultmethod;

import dms.pastor.ExampleRunner;
import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 28/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DefaultInterfaceExampleTest  implements ExampleRunner {

    @Test
    @Override
    public void runExamples() throws Exception {
        //given
        DefaultInterfaceExample example = new DefaultInterfaceExample();

        // when and then u see console output
        example.displayFormula();
    }
}