package dms.pastor.prototypes.xp;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.prototypes.xp.LearnerType.*;
import static org.assertj.core.api.Assertions.assertThat;

/*
    Rules:
    XP gain for kill monster is 128,96,64,(-1/per monster kills)
    Game should be able to finish around 50
 */
public class XPUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeNumber() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        // given
        int totalKills = -1;
        // when
        XPUtils.getXPForKill(totalKills);

    }

    @Test
    public void shouldGet128XPForKill1Monster() {
        // given
        int totalKills = 0;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(128);
    }

    @Test
    public void shouldGet96XPForKill2Monster() {
        // given
        int totalKills = 1;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(96);
    }

    @Test
    public void shouldGet64XPForKill3Monster() {
        // given
        int totalKills = 2;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(64);
    }

    @Test
    public void shouldGet63XPForKill4Monster() {
        // given
        int totalKills = 3;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(63);
    }

    @Test
    public void shouldGet62XPForKill5Monster() {
        // given
        int totalKills = 4;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(62);
    }

    @Test
    public void shouldGet57XPForKill10Monster() {
        // given
        int totalKills = 9;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(57);
    }

    @Test
    public void shouldGet47XPForKill20Monster() {
        // given
        int totalKills = 19;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(47);
    }

    @Test
    public void shouldGet5XPForKill62Monster() {
        // given
        int totalKills = 61;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(5);
    }

    @Test
    public void shouldGet3XPForKill64Monster() {
        // given
        int totalKills = 63;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(3);
    }

    @Test
    public void shouldGet2XPForKill65Monster() {
        // given
        int totalKills = 64;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(2);
    }

    @Test
    public void shouldGet1XPForKill66Monster() {
        // given
        int totalKills = 65;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(1);
    }

    @Test
    public void shouldGet3XPForKill67Monster() {
        // given
        int totalKills = 66;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(1);
    }

    @Test
    public void shouldGet3XPForKill68Monster() {
        // given
        int totalKills = 67;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(1);
    }

    @Test
    public void shouldGet1XPForKill100Monster() {
        // given
        int totalKills = 99;
        // when
        final var xp = XPUtils.getXPForKill(totalKills);
        // then
        assertThat(xp).isEqualTo(1);
    }


    @Test
    public void calculateXPNeededForShouldThrowExceptionIfLevelIsNegative() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        // given
        int level = -1;
        // when
        XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
    }

    @Test
    public void calculateXPNeededForShouldThrowExceptionIfLevelIsZero() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        // given
        int level = 0;
        // when
        XPUtils.calculateXPNeededFor(level, LearnerType.SLOW_LEARNER);
    }

    @Test
    public void calculateXPNeededForShouldThrowExceptionIfLearnerTypeIsNull() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        // given
        int level = 1;
        // when
        XPUtils.calculateXPNeededFor(level, null);
    }


    @Test
    public void calculateXPNeededForShouldReturn0ForLevel1() {
        // given
        int level = 1;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isZero();
    }

    @Test
    public void calculateXPNeededForShouldReturn1142ForLevel2() {
        // given
        int level = 2;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(1142);
    }

    @Test
    public void calculateXPNeededForShouldReturn2398ForLevel3() {
        // given
        int level = 3;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(2398);
    }

    @Test
    public void calculateXPNeededForShouldReturn3779ForLevel4() {
        // given
        int level = 4;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(3779);
    }

    @Test
    public void calculateXPNeededForShouldReturn7935ForLevel5() {
        // given
        int level = 5;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(5298);
    }

    @Test
    public void calculateXPNeededForShouldReturn7935ForLevel10() {
        // given
        int level = 10;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(15491);
    }

    @Test
    public void calculateXPNeededForShouldReturn123226ForLevel25ForSlowLearner() {
        // given
        int level = 25;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, SLOW_LEARNER);
        // then
        assertThat(xp).isEqualTo(134597);
    }

    @Test
    public void calculateXPNeededForShouldReturn123226ForLevel25ForAverageLearner() {
        // given
        int level = 25;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(100811);
    }

    @Test
    public void calculateXPNeededForShouldReturn123226ForLevel25ForCleverLearner() {
        // given
        int level = 25;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, CLEVER_LEARNER);
        // then
        assertThat(xp).isEqualTo(87303);
    }

    @Test
    public void calculateXPNeededForShouldReturn123226ForLevel25ForGeniusLearner() {
        // given
        int level = 25;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, GENIUS_LEARNER);
        // then
        assertThat(xp).isEqualTo(66130);
    }

    @Test
    public void calculateXPNeededForShouldReturn142554361ForLevel100() {
        // given
        int level = 100;
        // when
        final var xp = XPUtils.calculateXPNeededFor(level, AVERAGE_LEARNER);
        // then
        assertThat(xp).isEqualTo(142554361);
    }

}
