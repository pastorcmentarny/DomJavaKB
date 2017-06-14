package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class AsteroidStormSpellTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private final AsteroidStormSpell asteroidStormSpell = new AsteroidStormSpell();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }


    @Test
    public void castAsteroidStormShouldCauseDamageToUnit() throws Exception {
        // given
        final int initHp = 100;
        final Unit unit = unitBuilder()
                .withoutShield()
                .hp(initHp)
                .build();

        // when
        asteroidStormSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isLessThan(initHp);
    }

    @Test
    public void castAsteroidStormShouldHitAtLeastOnceUnitOneUnitTwoAndMissOnce() throws Exception {
        // given
        final int initHp = 1000;
        final Unit unit1 = unitBuilder()
                .withoutShield()
                .hp(initHp)
                .build();
        final Unit unit2 = unitBuilder()
                .withoutShield()
                .hp(initHp)
                .build();

        // when
        for (int i = 0; i < 10; i++) {
            asteroidStormSpell.castSpell(unit1, unit2);
        }

        // then
        assertThat(unit1.getHp()).isLessThan(initHp);
        assertThat(unit2.getHp()).isLessThan(initHp);
        String output = outputStream.toString();
        assertThat(output).contains("Asteroid hit Unit1.");
        assertThat(output).contains("Asteroid hit Unit2.");
        assertThat(output).contains("Asteroid missed.");
    }

}
