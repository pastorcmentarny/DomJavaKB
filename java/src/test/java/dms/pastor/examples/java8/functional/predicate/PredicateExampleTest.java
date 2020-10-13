package dms.pastor.examples.java8.functional.predicate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PredicateExampleTest {


    @Test
    public void predicateExample() throws Exception {
        // given
        final String expectedResult = """
                City: Wroclaw is: false and negation will be true
                City: Tianjin is: false and negation will be true
                City: London is: false and negation will be true
                City: Aberystwyth is: false and negation will be true
                City: Bangor is: true and negation will be false
                City: York is: false and negation will be true
                City: Beijing is: true and negation will be false
                """;
        // when
        final String result = PredicateExample.example();
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}