package dms.pastor.tools.salarycalc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 08/01/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CalculatorTest {
    final Calculator calculator = new Calculator();

    @Test //TODO do proper test
    public void shouldGetBasicSalary() throws Exception {

        // when
        final int result = calculator.getBasicSalary();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThanOrEqualTo(50000);
    }

    @Test
    public void shouldZoneOneAddonAcceptanceTest() throws Exception {
        // given

        // when
        final int result = calculator.zoneOneAddon();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThan(2000);
    }

}