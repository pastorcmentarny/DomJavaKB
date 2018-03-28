package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.builders.UnitBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class DrawEventSpellTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void castDrawEventSpellShouldGenerateSomeEvents() {
        // given
        DrawEventSpell drawEventSpell = new DrawEventSpell();
        Unit unit = UnitBuilder.unitBuilder().build();

        // when
        drawEventSpell.castSpell(unit, unit);

        // then
        assertThat("Casting Draw an event spell.");
        assertThat(byteArrayOutputStream.toString()).contains("EVENT");
    }
}