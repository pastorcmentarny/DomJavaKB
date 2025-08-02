package dms.pastor.examples.lombok;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ReactorAcceptanceTest {

    @Test
    public void lombokToStringExample() {
        // given
        Reactor reactor = new Reactor();

        // expect
        final String expectedResult = "Reactor(cores=[Core(number=0, description=null), Core(number=0, description=null)], enabled=false, status=null, temperature=0)";

        // when
        assertThat(reactor.toString()).isEqualTo(expectedResult);
    }
}