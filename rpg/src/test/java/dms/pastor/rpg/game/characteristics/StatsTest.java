package dms.pastor.rpg.game.characteristics;

import dms.pastor.prototypes.xp.XPUtils;
import dms.pastor.rpg.game.units.RaceBasicStatsBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @BeforeEach
    public void setup() {
        stats = RaceBasicStatsBuilder.humanBuilder();
    }

    @AfterEach
    public void cleanUp() {
        stats = null;
    }

    @Test
    public void addToDmgShouldTNotChangeMinDamageForMaxDamageForExtensionBelowZero() {
        // given
        int dmg = 3;
        int range = -1;

        // expect
        assertThrows(IllegalArgumentException.class, () ->
                // when
                stats.addToDmg(dmg, range)
        );

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
