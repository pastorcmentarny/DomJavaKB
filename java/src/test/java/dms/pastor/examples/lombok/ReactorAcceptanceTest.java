package dms.pastor.examples.lombok;

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