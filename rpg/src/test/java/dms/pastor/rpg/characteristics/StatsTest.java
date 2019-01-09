package dms.pastor.rpg.characteristics;

import dms.pastor.rpg.units.RaceBasicStatsBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 09/01/2019
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StatsTest {
    private Stats stats;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        stats = RaceBasicStatsBuilder.humanBuilder();
    }

    @After
    public void cleanUp() {
        stats = null;
    }

    @Test
    public void addToDmgShouldTNotChangeMinDamageForMaxDamageForExtensionBelowZero() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        int dmg = 3;
        int range = -1;

        // when
        stats.addToDmg(dmg, range);

        // debug
        System.out.println(stats.toString());

        // then
        assertThat(stats.getMinDMG()).isEqualTo(1);
        assertThat(stats.getMaxDMG()).isEqualTo(6);
    }

    @Test
    public void addToDmgShouldIncreaseBy3ToMinDamageAndMaxDamageWhenExtensionIdZero() {
        // given
        int dmg = 3;
        int range = 0;

        // when
        stats.addToDmg(dmg, range);

        // debug
        System.out.println(stats.toString());

        // then
        assertThat(stats.getMinDMG()).isEqualTo(4);
        assertThat(stats.getMaxDMG()).isEqualTo(9);
    }


    @Test
    public void addToDmgShouldIncreaseByOneForMinDamageAndFourForMaxDamage() {
        // given
        int dmg = 3;
        int range = 1;

        // when
        stats.addToDmg(dmg, range);

        // debug
        System.out.println(stats.toString());

        // then
        assertThat(stats.getMinDMG()).isEqualTo(2); //1+(3-2)
        assertThat(stats.getMaxDMG()).isEqualTo(10); //6+(3+1)
    }

    @Test
    public void addToDmgShouldIncreaseByOneForMaxDamage() {
        // given
        int dmg = 1;
        int range = 1;

        // when
        stats.addToDmg(dmg, range);

        // debug
        System.out.println(stats.toString());

        // then
        assertThat(stats.getMinDMG()).isEqualTo(1); //1+(3-2)
        assertThat(stats.getMaxDMG()).isEqualTo(7); //6+(3+1)
    }

}
