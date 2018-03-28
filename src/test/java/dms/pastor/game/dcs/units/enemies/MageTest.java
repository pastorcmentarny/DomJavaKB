package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.CreateShieldSpell;
import dms.pastor.game.dcs.spells.ShieldRecoverySpell;
import dms.pastor.game.dcs.units.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.conditions.ElementType.*;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/09/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MageTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MageTest.class);
    private static final Unit UNUSED_UNIT = null;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void turnShouldCastShieldIfMageDoesNotHave() {
        // given
        Unit mage = new Mage();
        mage.setSp(0);
        mage.setElementsFor(EARTH, 2);
        mage.setElementsFor(WATER, 2);

        // verify
        assertThat(mage.isShielded()).isFalse();

        // when
        mage.turn(new Dummy()); // it need dummy unit as mage can cast random spell;

        // then
        assertThat(mage.isShielded()).isTrue();
        assertThat(outputStream.toString()).contains(format("%s casting %s on %s", mage.getName(), new CreateShieldSpell().getName(), mage.getName()));
    }

    @Test
    public void turnShouldCastShieldRegenIfShieldPointsAreLow() {
        // given
        Unit mage = new Mage();
        final int lowSp = mage.getSp() / 4;
        mage.setSp(lowSp);
        mage.setElementsFor(AIR, 10);
        mage.setElementsFor(EARTH, 5);
        mage.setElementsFor(FIRE, 5);
        mage.setElementsFor(WATER, 10);

        // verify
        assertThat(mage.isShielded()).isTrue();

        // when
        mage.turn(UNUSED_UNIT);

        // debug
        LOGGER.debug(format("SP: %d", mage.getSp()));

        // then
        assertThat(mage.getSp()).isGreaterThan(lowSp);
        assertThat(outputStream.toString()).contains(format("%s casting %s on %s", mage.getName(), new ShieldRecoverySpell().getName(), mage.getName()));

    }

    //TODO random spell cast ??

}