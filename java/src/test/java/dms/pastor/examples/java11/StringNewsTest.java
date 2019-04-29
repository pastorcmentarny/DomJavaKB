package dms.pastor.examples.java11;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 29/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StringNewsTest {

    @Test
    public void stringRepeatMethod() {
        assertThat(StringNews.stringRepeatMethod()).isEqualTo("&nbsp;&nbsp;&nbsp;");
    }

    @Test
    public void stringIsBlankMethod() {
        assertThat(StringNews.stringIsBlankMethod()).isTrue();
    }

    @Test
    public void stringStripMethod() {
        assertThat(StringNews.stringStripMethod()).isEqualTo("Dominik");
    }

    @Test
    public void stringLinesMethod() {
        assertThat(StringNews.stringLinesMethod()).isEqualTo(3);
    }
}