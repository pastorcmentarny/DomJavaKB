package dms.pastor.tools.chinese.validator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 20/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class GuidGeneratorToolTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuidGeneratorToolTest.class);

    @Test // actually used to generate guid for DLC app
    public void shouldGenerateGuid() {
        // when
        final String guid = GuidGeneratorTool.generateGuid();

        // debug
        LOGGER.info("Genereted GUID: " + guid);

        // then
        assertThat(guid).isNotEmpty();
        assertThat(guid).hasSize(32);
    }
}