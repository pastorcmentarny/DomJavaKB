package dms.pastor.spring.tools.getdone.model;

import org.junit.jupiter.api.Test;

import static dms.pastor.spring.DomUtils.generateString;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusMessageTest {

    @Test
    public void shouldCreateStatusMessageWithDefaultAdvice() {
        // given 
        final String status = generateString();
        final String message = generateString();
        // when
        final StatusMessage statusMessage = new StatusMessage(status, message);

        // then
        assertThat(statusMessage.getStatus()).isEqualTo(status);
        assertThat(statusMessage.getMessage()).isEqualTo(message);
        assertThat(statusMessage.getAdvice()).isEqualTo("So far,so good!");
    }

    @Test
    public void shouldCreateStatusMessageWithCustomAdvice() {
        // given
        final String status = generateString();
        final String message = generateString();
        final String advice = generateString();
        // when
        final StatusMessage statusMessage = new StatusMessage(status, message, advice);

        // then
        assertThat(statusMessage.getStatus()).isEqualTo(status);
        assertThat(statusMessage.getMessage()).isEqualTo(message);
        assertThat(statusMessage.getAdvice()).isEqualTo(advice);

    }

}