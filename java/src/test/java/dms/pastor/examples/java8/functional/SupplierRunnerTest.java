package dms.pastor.examples.java8.functional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SupplierRunnerTest {

    @Test
    public void supplierExampleAcceptanceTest() {
        // given
        SupplierRunner example = new SupplierRunner();

        // when
        final String result = example.supplierExample();

        // then
        assertThat(result).isEqualTo("Not required");
    }

}