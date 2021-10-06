package dms.pastor.prototypes.littlefighter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StatusAcceptanceTest {
    private Status status;

    @BeforeEach
    public void setUp() {
        status = new Status();
    }

    @Test
    public void purifyAcceptanceTest() {
        // given
        status.setBlind();
        status.setBerserk();
        status.setPoisoned();
        status.setWeak();
        // when
        status.purify();

        // then
        assertThat(status.isBlind()).isFalse();
        assertThat(status.isBerserk()).isFalse();
        assertThat(status.isPoisoned()).isFalse();
        assertThat(status.isWeak()).isFalse();

    }

    @Test
    public void setActiveStatusesAcceptanceTest() {

        // given
        status.setBlind();
        status.setBerserk();
        status.setPoisoned();
        status.setWeak();
        // when
        final String activeStatuses = status.setActiveStatuses();

        // then
        assertThat(activeStatuses).isEqualTo("Poison Berserk Weak Blind ");
    }

    @Test
    public void setBlindAcceptanceTest() {

        // given
        status.setBlind();
        // when and then
        assertThat(status.isBlind()).isTrue();
    }

    @Test
    public void setBerserkAcceptanceTest() {

        // given
        status.setBerserk();
        // when and then
        assertThat(status.isBerserk()).isTrue();
    }

    @Test
    public void setWeakAcceptanceTest() {

        // given
        status.setWeak();
        // when and then
        assertThat(status.isWeak()).isTrue();
    }


    @Test
    public void decreaseLengthOfPoison() {

        // given
        status.setPoisoned();
        status.setLengthOfPoison(2);
        // when
        status.decreaseLengthOfPoison();

        // then
        assertThat(status.getLengthOfPoison()).isEqualTo(1);
        assertThat(status.isPoisoned()).isTrue();
        status.decreaseLengthOfPoison();
        assertThat(status.getLengthOfPoison()).isZero();
        assertThat(status.isPoisoned()).isFalse();
    }


}