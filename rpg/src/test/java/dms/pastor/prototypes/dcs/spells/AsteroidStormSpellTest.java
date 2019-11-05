package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.IntStream;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("resource") // auto closable not essential
public class AsteroidStormSpellTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private final AsteroidStormSpell asteroidStormSpell = new AsteroidStormSpell();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUp() throws IOException {
        outputStream.close();
        System.setOut(original);
    }


    @Test
    public void castAsteroidStormShouldCauseDamageToUnit() {
        // given
        final int initHp = 100;
        final Unit unit = unitBuilder()
            .withoutShield()
            .hp(initHp)
            .build();

        // when
        IntStream.rangeClosed(1, 10).forEach(it -> asteroidStormSpell.castSpell(unit, unit));

        // then
        assertThat(unit.getHp()).isLessThan(initHp);
    }

    @Test
    public void castAsteroidStormShouldHitAtLeastOnceUnitOneUnitTwoAndMissOnce() {
        // given
        final int initHp = 1000;
        final Unit unit1 = unitBuilder()
            .name("Unit1")
            .withoutShield()
            .hp(initHp)
            .build();
        final Unit unit2 = unitBuilder()
            .name("Unit2")
            .withoutShield()
            .hp(initHp)
            .build();

        // when
        IntStream.rangeClosed(1, 20).forEach(it -> asteroidStormSpell.castSpell(unit1, unit2));

        // then
        assertThat(unit1.getHp()).isLessThan(initHp);
        assertThat(unit2.getHp()).isLessThan(initHp);
        String output = outputStream.toString();
        assertThat(output).contains("Asteroid hits Unit1!");
        assertThat(output).contains("Asteroid hits Unit2!");
        assertThat(output).contains("Asteroid missed.");
    }

}
