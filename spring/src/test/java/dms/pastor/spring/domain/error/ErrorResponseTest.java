package dms.pastor.spring.domain.error;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ErrorResponseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorResponseTest.class);

    @Test
    public void ErrorResponseExample() {
        // given
        final int id = 1;

        // example
        final String errorMessage = "Unable to save file";
        final String caused = "Unable to find destination directory";
        final String solution = "Check network connection";
        final String moreInfo = "More info can be found here: https://dominiksymonowicz.com (You need device with access to internet :) )";
        ErrorResponse error = new ErrorResponse(id, errorMessage, caused, solution, moreInfo);

        // info
        LOGGER.info(error.toString());

        // then
        assertThat(error).isNotNull();
    }

}