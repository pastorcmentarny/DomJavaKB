package dms.pastor.examples.java8.functional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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