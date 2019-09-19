package dms.pastor.protoype.xp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/*
    Rules:
    XP gain for kill monster is 128,96,64,(-1/per monster kills)
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
        final var xp = XPUtils.getXPForKill(totalKills);

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
}